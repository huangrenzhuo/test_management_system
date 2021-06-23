package com.huang.springbootdemo.controller;


//import com.huang.springbootdemo.utils.JWTUtils;

import com.alibaba.fastjson.JSON;
import com.huang.springbootdemo.utils.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class Controller {


    @RequestMapping("/hello")
    public Result<String> hello(HttpServletResponse response) throws IOException {
        return Result.success("/hello");


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
