package com.huang.springbootdemo;

import com.huang.springbootdemo.mapper.MyUserMapper;

//import com.huang.springbootdemo.utils.JWTUtils;
import com.huang.springbootdemo.utils.JWTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;


@SpringBootTest
class SpringbootDemoApplicationTests {


    @Resource
    MyUserMapper myUserMapper;

    @Resource
    PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
       //用来手动向表中添加用户
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String passHash = encoder.encode("123456");
//        System.out.println(encoder.matches("123456",passHash));
      myUserMapper.addUser("k",passHash,"administrator");
    }

}