package com.huang.springbootdemo.Mapper;


import com.huang.springbootdemo.domain.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface StudentMapper {

    @Select("select * from studentInformation ")
    public List<Student> findALL();

    @Select("select * from studentInformation where id=#{id}")
   public Student selectById(@Param("id") String id);

    @Delete("delete from studentInformation where id=#{id}")
    public void  deleteById(@Param("id") String id);

    @Update("update studentInformation set name=#{name},sex=#{sex},phone=#{phone},address=#{address} where id=#{id} ")
     public  void updateStudent(Student student);

    @Insert("insert into studentInformation values(#{id},#{name},#{sex},#{phone},#{address})")
    public void insertStudent(Student student);

}
