package com.huang.springbootdemo.service.Pro_Answer;

import com.huang.springbootdemo.entity.Pro_Answer;

import java.util.List;

public interface Pro_AnswerService {

    Pro_Answer getAnswerProById(int pro_no);

    List<Integer> getAllAnswerId();

    int insertAnswer(String pro_detail, String answer, String explanation, String subject);

    int updateAnswer(String pro_detail, String answer, String explanation, String subject, int pro_no);

    String getSubjectById(int pro_no);

    int deleteAnswer(int pro_no);
}
