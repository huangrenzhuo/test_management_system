package com.huang.springbootdemo;

import com.huang.springbootdemo.mapper.MyUserMapper;

//import com.huang.springbootdemo.utils.JWTUtils;
import com.huang.springbootdemo.utils.JWTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class SpringbootDemoApplicationTests {


    @Resource
    MyUserMapper myUserMapper;

    @Test
    void contextLoads() {

    }

}