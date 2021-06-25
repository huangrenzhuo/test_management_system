package com.huang.springbootdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huang.springbootdemo.entity.Pro_Choice;
import com.huang.springbootdemo.mapper.MyUserMapper;
import com.huang.springbootdemo.service.Pro_Choice.Pro_ChoiceService;
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
    MyUserMapper myUserMapper;

    @RequestMapping("/getProblem")
    public Result<Object> getProblem(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(body);
        int pro_no = jsonObject.getInteger("pro_no");
        Pro_Choice pro_choice = pro_choiceService.getChoiceProById(pro_no);
        return Result.success(pro_choice);
    }


}
