package com.huang.springbootdemo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

@Table(name="user")
public class MyUser {

    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 111)
    private String username;
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 111)
    private String password;
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 111)
    private Authority authority;

    public String getPassword() {
        return password;
    }


    public String getUsername() {
        return username;
    }

    public Authority getAuthority() {
        return authority;
    }
}
