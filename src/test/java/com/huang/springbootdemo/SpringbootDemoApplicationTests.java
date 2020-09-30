package com.huang.springbootdemo;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.huang.springbootdemo.domain.Student;
import com.huang.springbootdemo.Mapper.StudentMapper;
import com.huang.springbootdemo.utils.JWTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
class SpringbootDemoApplicationTests {

    @Autowired
    StudentMapper studentMapper;

    @Test
    void contextLoads() {
       // Student student=new Student();
      // List<Student> list=studentMapper.findALL();
//        student=studentMapper.selectById("99");
//        System.out.println(student);
//          student.setId(767);
//          student.setName("孟川");
//          student.setSex("male");
//          student.setPhone("7");
//          student.setAddress("沧元界");
//          studentMapper.insertStudent(student);
       //System.out.println(list);
//        JWTUtils.getToken();
        Map<String, Object>map=new HashMap<>();
        map.put("3242","324");
        String token= JWTUtils.getToken(map);
        DecodedJWT verify=JWTUtils.verify(token);
         System.out.println(verify.getClaims().get("3242").asString());
        //System.out.println(JWTUtils.getToken(map).);

    }
}