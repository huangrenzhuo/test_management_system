package com.huang.springbootdemo.config;

import com.huang.springbootdemo.interceptors.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         //除了登录其他都进行拦截
          registry.addInterceptor(new JWTInterceptor()).
                  addPathPatterns("/**").
                  excludePathPatterns("/login");
    }
}
