package com.huang.springbootdemo.entity;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

@Table(name = "image")
public class Image {

    @Column(name = "username", type = MySqlTypeConstant.VARCHAR,isKey = true, length = 111)
    private String username;
    @Column(name = "imageUrl", type = MySqlTypeConstant.VARCHAR, length = 111)
    private String imageUrl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}

