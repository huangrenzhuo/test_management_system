package com.huang.springbootdemo.service;

import com.huang.springbootdemo.mapper.MyUserMapper;
import com.huang.springbootdemo.entity.MyUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MyUserService implements UserDetailsService {


    @Resource
    MyUserMapper myUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserMapper.getUser(username);
        UserDetails userDetails = User.withUsername(myUser.getUsername()).password(myUser.getPassword()).authorities("p1").roles().build();
        return userDetails;
    }


}
