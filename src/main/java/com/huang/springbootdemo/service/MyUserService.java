package com.huang.springbootdemo.service;

import com.huang.springbootdemo.mapper.MyUserMapper;
import com.huang.springbootdemo.entity.MyUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MyUserService implements UserDetailsService {


    @Resource
    MyUserMapper myUserMapper;

    @Resource
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserMapper.getUser(username);
        UserDetails userDetails = User.withUsername(myUser.getUsername()).password(myUser.getPassword()).authorities(myUser.getAuthority()).roles().build();
        return userDetails;
    }


    public void register(String username, String password, String authority) {
        myUserMapper.addUser(username, passwordEncoder.encode(password), authority);
    }
}
