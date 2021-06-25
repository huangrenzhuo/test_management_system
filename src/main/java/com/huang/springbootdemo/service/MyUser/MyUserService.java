package com.huang.springbootdemo.service.MyUser;

import com.huang.springbootdemo.mapper.MyUserMapper;
import com.huang.springbootdemo.entity.MyUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 * 实现UserDetailsService接口
 */
@Service
public class MyUserService implements UserDetailsService {


    @Resource
    MyUserMapper myUserMapper;

    @Resource
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据username查询数据库
        MyUser myUser = myUserMapper.getUser(username);
        //返回UserDetails
        UserDetails userDetails = User.withUsername(myUser.getUsername()).password(myUser.getPassword()).authorities(myUser.getAuthority()).build();
        return userDetails;
    }


    public void register(String username, String password, String authority) {
        myUserMapper.addUser(username, passwordEncoder.encode(password), authority);
    }
}
