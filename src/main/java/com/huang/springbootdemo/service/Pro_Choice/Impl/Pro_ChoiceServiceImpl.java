package com.huang.springbootdemo.service.Pro_Choice.Impl;

import com.huang.springbootdemo.entity.Pro_Choice;
import com.huang.springbootdemo.mapper.Pro_ChoiceMapper;
import com.huang.springbootdemo.service.Pro_Choice.Pro_ChoiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Pro_ChoiceServiceImpl implements Pro_ChoiceService {

    @Resource
    Pro_ChoiceMapper pro_choiceMapper;

    @Override
    public Pro_Choice getChoiceProById(int pro_no) {
        Pro_Choice pro_choice = pro_choiceMapper.getChoiceProById(pro_no);
        return pro_choice;
    }

    @Override
    public List<Integer> getAllChoiceId() {
        List<Integer> list = pro_choiceMapper.getAllChoiceId();
        return list;
    }

    @Override
    public int insertChoice(String pro_detail, String choice_a, String choice_b, String choice_c, String choice_d, String answer, String explanation, String subject) {
        int result = pro_choiceMapper.insertChoice(pro_detail, choice_a, choice_b, choice_c, choice_d, answer, explanation, subject);
        return result;
    }

    @Override
    public int updateChoice(Pro_Choice pro_choice) {
        return 0;
    }


}
