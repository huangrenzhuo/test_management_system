package com.huang.springbootdemo.service.Student;


import java.util.Date;

public interface StudentService {

    void addStudent(String username, String name,String id,String _class,String school,String grade,String sex,String email);

    void updateName(String name, String username);

    void updateSchool(String school, String username);

    void updateSex(String sex, String username);

    void updateGrade(String grade, String username);

    void updateClass(String _class, String username);

    void updateEmail(String email, String username);

    void doProblem(String username, int pro_no, String pro_type, String answer, Date date);

    int getProSumByDate(String username, Date date);

    int getProSumBySubject(String username, String subject);

}
