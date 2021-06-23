package com.huang.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication

@ComponentScan({"com.gitee.sunchenbin.mybatis.actable.manager.*"})
@MapperScan({"com.gitee.sunchenbin.mybatis.actable.dao.*","com.huang.springbootdemo.mapper"})
@ComponentScan("com.huang.springbootdemo.entity")
@ComponentScan("com.huang.springbootdemo.entity")
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }


}