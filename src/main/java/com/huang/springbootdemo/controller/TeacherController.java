package com.huang.springbootdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huang.springbootdemo.entity.Pro_Answer;
import com.huang.springbootdemo.entity.Pro_Choice;
import com.huang.springbootdemo.entity.Pro_Completion;
import com.huang.springbootdemo.service.Pro_Answer.Pro_AnswerService;
import com.huang.springbootdemo.service.Pro_Choice.Pro_ChoiceService;
import com.huang.springbootdemo.service.Pro_Completion.Pro_CompletionService;
import com.huang.springbootdemo.utils.Result;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@CrossOrigin
public class TeacherController {
    @Resource
    Pro_ChoiceService pro_choiceService;

    @Resource
    Pro_CompletionService pro_completionService;

    @Resource
    Pro_AnswerService pro_answerService;

    @RequestMapping("/getProblem")
    public Result<Object> getProblem(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(body);
        String pro_type = jsonObject.getString("pro_type");
        int pro_no = jsonObject.getInteger("pro_no");
        if (pro_type.equals("pro_choice")){
            Pro_Choice pro_choice = pro_choiceService.getChoiceProById(pro_no);
            return Result.success(pro_choice);
        }else if(pro_type.equals("pro_answer")){
            Pro_Answer pro_answer = pro_answerService.getAnswerProById(pro_no);
            return Result.success(pro_answer);
        }else if(pro_type.equals("pro_completion")){
            Pro_Completion pro_completion = pro_completionService.getCompletionProById(pro_no);
            return Result.success(pro_completion);
        }else{
            return Result.fail(-1,"错误的pro_type格式");
        }

    }


}
