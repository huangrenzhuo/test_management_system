package com.huang.springbootdemo.service.Student;

public interface StudentService {
    void updateName(String name, String username);

    void updateSchool(String school, String username);

    void updateSex(String sex, String username);

    void updateGrade(String grade, String username);

    void updateClass(String _class, String username);

    void updateEmail(String email, String username);
}
