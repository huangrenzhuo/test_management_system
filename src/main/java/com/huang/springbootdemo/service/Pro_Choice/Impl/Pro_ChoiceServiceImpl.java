package com.huang.springbootdemo.service.Pro_Choice.Impl;

import com.huang.springbootdemo.entity.Pro_Choice;
import com.huang.springbootdemo.mapper.Pro_ChoiceMapper;
import com.huang.springbootdemo.service.Pro_Choice.Pro_ChoiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Pro_ChoiceServiceImpl implements Pro_ChoiceService {

    @Resource
    Pro_ChoiceMapper pro_choiceMapper;

    @Override
    public Pro_Choice getChoiceProById(int pro_no) {
        Pro_Choice pro_choice = pro_choiceMapper.getChoiceProById(pro_no);
        return pro_choice;
    }
}
