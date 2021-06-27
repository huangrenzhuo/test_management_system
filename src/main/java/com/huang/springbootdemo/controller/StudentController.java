package com.huang.springbootdemo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huang.springbootdemo.entity.Subject;
import com.huang.springbootdemo.service.Student.Impl.StudentServiceImpl;
import com.huang.springbootdemo.utils.GetUserContextUtil;
import com.huang.springbootdemo.utils.Result;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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

    @RequestMapping(value = "/doProblem", method = RequestMethod.POST)
    public Result<Object> doProblem(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException{
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(body);
        String username = jsonObject.getString("username");
        int pro_no = jsonObject.getInteger("pro_no");
        String pro_type = jsonObject.getString("pro_type");
        String answer = jsonObject.getString("answer");
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        studentService.doProblem(username,pro_no,pro_type,answer, c.getTime());
        return Result.success("做题记录已加入数据库");
    }

    @RequestMapping(value = "/problemSum", method = RequestMethod.GET)
    public Result<Object> getProblemSum(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException{


        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(body);
        String type = jsonObject.getString("type");
        String username = jsonObject.getString("username");
        if(type.equals("byDate")){
            int daySum = jsonObject.getInteger("daySum");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Map<String,Integer> map = new HashMap<>();
            Date today = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(today);

            for (int i = 0; i < daySum; i++) {

                Date tempDate = c.getTime();
//                int testInt = studentService.getProSumByDate(username,tempDate);

                map.put(sdf.format(tempDate), studentService.getProSumByDate(username,tempDate));
                c.add(Calendar.DAY_OF_MONTH, -1);
            }
            return Result.success(map);

        }else if(type.equals("bySubject")){
            Map<String,Integer> map = new HashMap<>();
            for(Subject subject:Subject.values()){
                int sum = studentService.getProSumBySubject(username,subject.getSubject());
                map.put(subject.getSubject(),sum);
            }
            return Result.success(map);
        }else{
            return Result.fail(-1,"请输入正确的请求类型");
        }

    }
}
