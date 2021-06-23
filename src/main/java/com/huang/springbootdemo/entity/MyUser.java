package com.huang.springbootdemo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

@Table(name="user")
public class MyUser {

    @Column(name = "username", type = MySqlTypeConstant.VARCHAR, length = 111)
    private String username;
    @Column(name = "password", type = MySqlTypeConstant.VARCHAR, length = 111)
    private String password;
    @Column(name = "authority", type = MySqlTypeConstant.VARCHAR, length = 111)
    private String authority;

    public String getPassword() {
        return password;
    }


    public String getUsername() {
        return username;
    }

    public String getAuthority() {
        return authority;
    }
}
