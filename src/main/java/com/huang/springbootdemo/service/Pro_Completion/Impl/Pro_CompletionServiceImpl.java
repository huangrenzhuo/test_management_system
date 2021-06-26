package com.huang.springbootdemo.service.Pro_Completion.Impl;

import com.huang.springbootdemo.entity.Pro_Completion;
import com.huang.springbootdemo.mapper.Pro_CompletionMapper;
import com.huang.springbootdemo.service.Pro_Completion.Pro_CompletionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Pro_CompletionServiceImpl implements Pro_CompletionService {

    @Resource
    Pro_CompletionMapper pro_completionMapper;

    @Override
    public Pro_Completion getCompletionProById(int pro_no) {
        Pro_Completion pro_completion = pro_completionMapper.getCompletionProById(pro_no);
        return pro_completion;
    }

    @Override
    public List<Integer> getAllCompletionId() {
        List<Integer> list = pro_completionMapper.getAllCompletionId();
        return list;
    }

    @Override
    public int insertCompletion(String pro_detail, int blank_num, String answer, String explanation, String subject) {
        int result = pro_completionMapper.insertCompletion(pro_detail, blank_num, answer, explanation, subject);
        return result;
    }

    @Override
    public String getSubjectById(int pro_no) {
        return pro_completionMapper.getSubjectById(pro_no);
    }

}
