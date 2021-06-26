package com.huang.springbootdemo.mapper;

import com.huang.springbootdemo.entity.MyUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MyUserMapper {

    @Select("select * from user where username=#{username}")
    MyUser getUser(String username);

    @Insert("insert into user(username,password,authority) values(#{username},#{password},#{authority})")
    void addUser(String username, String password, String authority);

}
