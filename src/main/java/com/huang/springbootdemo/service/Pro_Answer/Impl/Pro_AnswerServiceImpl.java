package com.huang.springbootdemo.service.Pro_Answer.Impl;

import com.huang.springbootdemo.entity.Pro_Answer;
import com.huang.springbootdemo.mapper.Pro_AnswerMapper;
import com.huang.springbootdemo.service.Pro_Answer.Pro_AnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Pro_AnswerServiceImpl implements Pro_AnswerService {
    @Resource
    Pro_AnswerMapper pro_answerMapper;


    @Override
    public Pro_Answer getAnswerProById(int pro_no) {
        Pro_Answer pro_answer = pro_answerMapper.getAnswerProById(pro_no);
        return pro_answer;
    }
}
