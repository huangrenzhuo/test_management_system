package com.huang.springbootdemo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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


@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    StudentServiceImpl studentService;

    /**
     * 修改姓名 ！！！非用户名
     * @param httpServletRequest
     * @param httpServletResponse
     * @return 成功信息
     * @throws IOException
     */
    @RequestMapping(value = "/name", method = RequestMethod.PUT)
    public Result<Void> updateName(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(body);
        String name = jsonObject.getString("name");
        studentService.updateName(name, new GetUserContextUtil().getCurrentUsername());
        return Result.success();
    }

    /**
     * 修改性别
     * @param httpServletRequest
     * @param httpServletResponse
     * @return 成功信息
     * @throws IOException
     */
    @RequestMapping(value = "/sex", method = RequestMethod.PUT)
    public Result<Void> updateSex(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(body);
        String sex = jsonObject.getString("sex");
        studentService.updateSex(sex, new GetUserContextUtil().getCurrentUsername());
        return Result.success();
    }

    /***
     * 修改email地址
     * @param httpServletRequest
     * @param httpServletResponse
     * @return 成功信息
     * @throws IOException
     */
    @RequestMapping(value = "/email", method = RequestMethod.PUT)
    public Result<Void> updateEmail(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(body);
        String email = jsonObject.getString("email");
        studentService.updateEmail(email, new GetUserContextUtil().getCurrentUsername());
        return Result.success();
    }

    /***
     * 修改学校
     * @param httpServletRequest
     * @param httpServletResponse
     * @return 成功信息
     * @throws IOException
     */
    @RequestMapping(value = "/school", method = RequestMethod.PUT)
    public Result<Void> updateSchool(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(body);
        String school = jsonObject.getString("school");
        studentService.updateSchool(school, new GetUserContextUtil().getCurrentUsername());
        return Result.success();
    }

    /***
     * 修改年级
     * @param httpServletRequest
     * @param httpServletResponse
     * @return 成功信息
     * @throws IOException
     */
    @RequestMapping(value = "/grade", method = RequestMethod.PUT)
    public Result<Void> updateGrade(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(body);
        String grade = jsonObject.getString("grade");
        studentService.updateGrade(grade, new GetUserContextUtil().getCurrentUsername());
        return Result.success();
    }

    /***
     * 修改班级
     * @param httpServletRequest
     * @param httpServletResponse
     * @return 成功信息
     * @throws IOException
     */
    @RequestMapping(value = "/class", method = RequestMethod.PUT)
    public Result<Object> updateClass(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(body);
        String _class = jsonObject.getString("_class");
        studentService.updateClass(_class, new GetUserContextUtil().getCurrentUsername());
        return Result.success("恭喜你发现这个彩蛋 MangoStudio 招聘 ");
    }


}
