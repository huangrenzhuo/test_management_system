package com.huang.springbootdemo.service.Pro_Answer.Impl;

import com.huang.springbootdemo.entity.Pro_Answer;
import com.huang.springbootdemo.mapper.Pro_AnswerMapper;
import com.huang.springbootdemo.service.Pro_Answer.Pro_AnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Pro_AnswerServiceImpl implements Pro_AnswerService {
    @Resource
    Pro_AnswerMapper pro_answerMapper;


    @Override
    public Pro_Answer getAnswerProById(int pro_no) {
        Pro_Answer pro_answer = pro_answerMapper.getAnswerProById(pro_no);
        return pro_answer;
    }

    @Override
    public List<Integer> getAllAnswerId() {
        List<Integer> list = pro_answerMapper.getAllAnswerId();
        return list;
    }

    @Override
    public int insertAnswer(String pro_detail, String answer, String explanation, String subject) {
        int result = pro_answerMapper.insertAnswer(pro_detail, answer, explanation, subject);
        return 0;
    }
}
