package com.huang.springbootdemo.service.Pro_Completion;


import com.huang.springbootdemo.entity.Pro_Completion;

import java.util.List;

public interface Pro_CompletionService {

    Pro_Completion getCompletionProById(int pro_no);

    List<Integer> getAllCompletionId();

    int insertCompletion(String pro_detail, int blank_num, String answer, String explanation, String subject);

    String getSubjectById(int pro_no);

}
