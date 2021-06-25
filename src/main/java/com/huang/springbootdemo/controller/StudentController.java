package com.huang.springbootdemo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huang.springbootdemo.mapper.StudentMapper;
import com.huang.springbootdemo.service.Student.Impl.StudentServiceImpl;
import com.huang.springbootdemo.utils.GetUserContextUtil;
import com.huang.springbootdemo.utils.Result;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//新增 post
//获取  get
//更新  put
//删除  delete
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    StudentServiceImpl studentService;


    @RequestMapping(value = "/name", method = RequestMethod.PUT)
    public Result<Void> updateName(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(body);
        String name = jsonObject.getString("name");
        studentService.updateName(name, new GetUserContextUtil().getCurrentUsername());
        return Result.success();
    }

    @RequestMapping(value = "/sex", method = RequestMethod.PUT)
    public Result<Void> updateSex(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        return Result.success();
    }

    @RequestMapping(value = "/email", method = RequestMethod.PUT)
    public Result<Void> updateEmail(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        return Result.success();
    }

    @RequestMapping(value = "/school", method = RequestMethod.PUT)
    public Result<Void> updateSchool(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        return Result.success();
    }

    @RequestMapping(value = "/grade", method = RequestMethod.PUT)
    public Result<Void> updateGrade(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        return Result.success();
    }

    @RequestMapping(value = "/class", method = RequestMethod.PUT)
    public Result<Void> updateClass(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        return Result.success();
    }


}
