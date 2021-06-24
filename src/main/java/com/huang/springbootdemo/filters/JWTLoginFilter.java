package com.huang.springbootdemo.filters;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huang.springbootdemo.entity.MyUser;
import com.huang.springbootdemo.utils.JWTUtils;
import com.huang.springbootdemo.utils.ResponseUtils;
import com.huang.springbootdemo.utils.ResultCode;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StreamUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


//UsernamePasswordAuthenticationFilter过滤器用于处理基于表单方式的登录验证，
// 该过滤器默认只有当请求方法为post、请求页面为/login时过滤器才生效，
// 如果想修改默认拦截url，只需在刚才介绍的Spring Security配置类WebSecurityConfig中
// 配置该过滤器的拦截url：.loginProcessingUrl("url")即可;
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        ;
        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            MyUser myUser = objectMapper.readValue(request.getInputStream(), MyUser.class);
//            String username = myUser.getUsername();
//            String password = myUser.getPassword();
            String body= StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
            JSONObject jsonObject= JSON.parseObject(body);
            String username=jsonObject.getString("username");
            String password=jsonObject.getString("password");
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            return authenticationManager.authenticate(authRequest);
            //交给Spring security框架去验证
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
//上面的函数成功就会执行这个方法
    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws
            IOException, ServletException {
        String username = ((org.springframework.security.core.userdetails.User) authResult.getPrincipal()).getUsername();
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        String token = JWTUtils.getToken(map);
        response.addHeader("Authorization", JWTUtils.token_prefix + token);
        ResponseUtils.SuccessResponse(response);
    }

 //上面的函数失败就会执行这个方法
    @Override
    public void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        //403 Forbidden
        ResponseUtils.FailResponse(response, ResultCode. USER_NOT_LOGIN_ERROR);
        return;
    }

}
