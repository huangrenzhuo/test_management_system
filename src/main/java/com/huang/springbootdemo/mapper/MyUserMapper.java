package com.huang.springbootdemo.mapper;

import com.huang.springbootdemo.entity.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MyUserMapper {

    @Select("select *from user where username=#{username}")
    public MyUser getMyUser(String username);


}
