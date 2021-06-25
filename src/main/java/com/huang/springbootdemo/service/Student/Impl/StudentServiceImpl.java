package com.huang.springbootdemo.service.Student.Impl;

import com.huang.springbootdemo.mapper.StudentMapper;
import com.huang.springbootdemo.service.Student.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Override
    public void updateName(String name, String username) {
        studentMapper.updateName(name, username);
    }

    @Override
    public void updateSchool(String school, String username) {
        studentMapper.updateSchool(school, username);
    }

    @Override
    public void updateSex(String sex, String username) {
        studentMapper.updateSex(sex, username);
    }

    @Override
    public void updateGrade(String grade, String username) {
        studentMapper.updateGrade(grade, username);
    }

    @Override
    public void updateClass(String _class, String username) {
        studentMapper.updateClass(_class, username);
    }

    @Override
    public void updateEmail(String email, String username) {
        studentMapper.updateEmail(email, username);
    }
}
