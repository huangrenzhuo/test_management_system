package com.huang.springbootdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface StudentMapper {

    @Update("update student set name=#{name} where username=#{username} ")
    void updateName(String name, String username);

    @Update("update student set school=#{school} where username=#{username} ")
    void updateSchool(String school, String username);

    @Update("update student set sex=#{sex} where username=#{username} ")
    void updateSex(String sex, String username);

    @Update("update student set grade=#{grade} where username=#{username} ")
    void updateGrade(String grade, String username);

    @Update("update student set _class=#{_class} where username=#{username} ")
    void updateClass(String _class, String username);

    @Update("update student set email=#{email} where username=#{username} ")
    void updateEmail(String email, String username);
}
