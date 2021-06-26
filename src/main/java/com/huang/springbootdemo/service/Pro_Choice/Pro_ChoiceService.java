package com.huang.springbootdemo.service.Pro_Choice;

import com.huang.springbootdemo.entity.Pro_Choice;

import java.util.List;

public interface Pro_ChoiceService {

    Pro_Choice getChoiceProById(int pro_no);
    List<Integer> getAllChoiceId();

}
