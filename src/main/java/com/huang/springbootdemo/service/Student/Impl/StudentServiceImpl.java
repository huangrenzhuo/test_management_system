package com.huang.springbootdemo.service.Student.Impl;

import com.huang.springbootdemo.entity.Record;
import com.huang.springbootdemo.mapper.*;
import com.huang.springbootdemo.service.Student.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Resource
    Pro_ChoiceMapper pro_choiceMapper;

    @Resource
    Pro_CompletionMapper pro_completionMapper;

    @Resource
    Pro_AnswerMapper pro_answerMapper;

    @Resource
    RecordMapper recordMapper;

    @Override
    public void addStudent(String username, String name, String id, String _class, String school, String grade, String sex, String email) {
        studentMapper.addStudent(username, name, id, _class, school, grade, sex, email);
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
    public void doProblem(String username, int pro_no, String pro_type, String answer, Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        studentMapper.doProblem(username, pro_no, pro_type, answer, sqlDate);
    }

    @Override
    public int getProSumByDate(String username, Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return studentMapper.getProSumByDate(username, sqlDate);
    }

    @Override
    public int getProSumBySubject(String username, String subject) {
        List<Record> recordList = recordMapper.getRecordsByUsername(username);
        int count = 0;
        for(Record record: recordList){
            int pro_no = record.getPro_no();
            if(record.getPro_type().equals("pro_choice")){
                String str = pro_choiceMapper.getSubjectById(pro_no);
                if(str!=null && str.equals(subject)){
                    count+=1;
                }
            }else if(record.getPro_type().equals("pro_answer")){
                String str = pro_answerMapper.getSubjectById(pro_no);
                if(str!=null && str.equals(subject)){
                    count+=1;
                }
            }else if(record.getPro_type().equals("pro_completion")){
                String str = pro_completionMapper.getSubjectById(pro_no);
                if(str!=null && str.equals(subject)){
                    count+=1;
                }
            }else{
                System.out.println("未知题目类型"+record.getPro_type());
            }
        }
        return count;
    }
}
