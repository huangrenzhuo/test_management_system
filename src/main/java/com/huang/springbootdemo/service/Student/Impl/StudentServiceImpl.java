package com.huang.springbootdemo.service.Student.Impl;

import com.huang.springbootdemo.mapper.ImageMapper;
import com.huang.springbootdemo.mapper.StudentMapper;
import com.huang.springbootdemo.service.Student.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Resource
    ImageMapper imageMapper;

    @Override
    public void addStudent(String username, String name, String id, String _class, String school, String grade, String sex, String email) {
        studentMapper.addStudent(username,name,id,_class,school,grade,sex,email);
    }

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

    @Override
    public void saveUserImage(String path, String username) {
        imageMapper.updateUserImageByName(username,path);
    }

    @Override
    public String getUserImageSrc(String username) {
        return imageMapper.getUserImageUrl(username);
    }

}
