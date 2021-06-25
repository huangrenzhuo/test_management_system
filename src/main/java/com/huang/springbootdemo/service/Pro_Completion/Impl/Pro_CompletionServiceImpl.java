package com.huang.springbootdemo.service.Pro_Completion.Impl;

import com.huang.springbootdemo.entity.Pro_Completion;
import com.huang.springbootdemo.mapper.Pro_CompletionMapper;
import com.huang.springbootdemo.service.Pro_Completion.Pro_CompletionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Pro_CompletionServiceImpl implements Pro_CompletionService {

    @Resource
    Pro_CompletionMapper pro_completionMapper;

    @Override
    public Pro_Completion getCompletionProById(int pro_no) {
        Pro_Completion pro_completion = pro_completionMapper.getCompletionProById(pro_no);
        return pro_completion;
    }
}
