package com.huang.springbootdemo;

import com.huang.springbootdemo.mapper.MyUserMapper;

//import com.huang.springbootdemo.utils.JWTUtils;
import com.huang.springbootdemo.utils.JWTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringbootDemoApplicationTests {


    @Autowired
    MyUserMapper myUserMapper;

    @Test
    void contextLoads() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("username","huang");
//        String token=JWTUtils.getToken(map);
       try {
           int[] a={1,2};
           System.out.println(a[2]);
       }catch (Exception e){
           System.out.println("hhh");
       }
    }

}