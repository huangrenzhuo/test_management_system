package com.huang.springbootdemo.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ImageMapper {

    @Update("update image set imageUrl=#{imageUrl} where username=#{username} ")
    void updateUserImageByName(String username,String imageUrl);

    @Select("select  imageUrl from image where username=#{username}")
    String getUserImageUrl(String username);

}