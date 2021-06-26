package com.huang.springbootdemo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Mapper
@Repository
public interface StudentMapper {

    @Insert("insert into student(username,name,id,_class,school,grade,sex,email) values(#{username},#{name},#{id},#{_class},#{school},#{grade},#{sex},#{email})")
    void addStudent(String username, String name, String id, String _class, String school, String grade, String sex, String email);

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

    @Insert("insert into record(username,pro_no,pro_type,answer,date) values(#{username},#{pro_no},#{pro_type},#{answer},#{date})")
    void doProblem(String username, int pro_no, String pro_type, String answer, Date date);

    @Select("select count(*) from record where username=#{username} and date=#{date}")
    int getProSumByDate(String username, Date date);

}
