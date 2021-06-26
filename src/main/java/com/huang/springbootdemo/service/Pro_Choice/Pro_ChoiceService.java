package com.huang.springbootdemo.service.Pro_Choice;

import com.huang.springbootdemo.entity.Pro_Choice;

import java.util.List;

public interface Pro_ChoiceService {

    Pro_Choice getChoiceProById(int pro_no);

    List<Integer> getAllChoiceId();

    int insertChoice(String pro_detail, String choice_a, String choice_b, String choice_c, String choice_d, String answer, String explanation, String subject);

    int updateChoice(Pro_Choice pro_choice);

}
