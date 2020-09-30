package com.huang.springbootdemo.interceptors;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huang.springbootdemo.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,Object>map=new HashMap<>();
        String token=request.getHeader("token");
        try {
            JWTUtils.verify(token);
             return true;
        }catch(SignatureVerificationException e){
             e.printStackTrace();
            map.put("message","签名错误");
        }catch(TokenExpiredException e){
            e.printStackTrace();
            map.put("message","token过期");
        }catch(AlgorithmMismatchException e){
            e.printStackTrace();
            map.put("message","token算法不一致");
        }catch(Exception e){
            e.printStackTrace();
            map.put("message","token无效");
        }
        map.put("state",false);
        String json=new ObjectMapper().writeValueAsString(map);//转换成json
        response.setContentType("application/json,charset=UTF-8");
        response.getWriter().println(json);
        return false;
        //return map;
    }
}
