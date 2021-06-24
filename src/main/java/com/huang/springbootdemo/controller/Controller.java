package com.huang.springbootdemo.controller;


//import com.huang.springbootdemo.utils.JWTUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huang.springbootdemo.entity.MyUser;
import com.huang.springbootdemo.mapper.MyUserMapper;
import com.huang.springbootdemo.service.MyUserService;
import com.huang.springbootdemo.utils.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class Controller {

    @Resource
    MyUserMapper myUserMapper;
    @Resource
    MyUserService myUserService;

    @RequestMapping("/register")
    public Result<String> register(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String body= StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject=JSON.parseObject(body);
        String username=jsonObject.getString("username");
        String password=jsonObject.getString("password");
        String authority=jsonObject.getString("authority");
        myUserService.register(username,password,authority);
        return Result.success("");
    }

    @RequestMapping("/hello")
    public Result<String> hello(HttpServletResponse response) throws IOException {
        return Result.success("hello");


    }

    @RequestMapping("/name")
    public Result<String> name() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        return Result.success(name);

    }


    @RequestMapping("/test")
    public void test(HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "成功");
        response.getWriter().write(JSON.toJSONString(map));
    }


}
