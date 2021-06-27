package com.huang.springbootdemo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huang.springbootdemo.entity.Paper;
import com.huang.springbootdemo.entity.Pro_Answer;
import com.huang.springbootdemo.entity.Pro_Choice;
import com.huang.springbootdemo.entity.Pro_Completion;
import com.huang.springbootdemo.service.Paper.PaperService;
import com.huang.springbootdemo.service.Pro_Answer.Pro_AnswerService;
import com.huang.springbootdemo.service.Pro_Choice.Pro_ChoiceService;
import com.huang.springbootdemo.service.Pro_Completion.Pro_CompletionService;
import com.huang.springbootdemo.service.Student.Impl.StudentServiceImpl;
import com.huang.springbootdemo.utils.FileUtils;
import com.huang.springbootdemo.utils.GetUserContextUtil;
import com.huang.springbootdemo.utils.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/student")
@ConfigurationProperties(prefix = "system-params")
public class StudentController {
    @Resource
    StudentServiceImpl studentService;

    @Resource
    Pro_ChoiceService pro_choiceService;

    @Resource
    Pro_CompletionService pro_completionService;

    @Resource
    Pro_AnswerService pro_answerService;

    @Resource
    PaperService paperService;

    private String path;

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


    //学生根据paper id 获取试卷
    @RequestMapping(value = "/paper", method = RequestMethod.GET)
    public Result<Object> getPaperById(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(body);
        int paper_no = jsonObject.getInteger("paper_no");
        Paper paper = paperService.getPaperById(paper_no);

        if (paper == null) {
            return Result.fail(-1, "不存在该试卷");
        }
        List<Pro_Choice> choiceList = new ArrayList<>();
        List<Pro_Completion> completionList = new ArrayList<>();
        List<Pro_Answer> answerList = new ArrayList<>();

        List<Integer> choiceIdList = JSON.parseArray(paper.getChoice_string(), Integer.class);
        List<Integer> completionIdList = JSON.parseArray(paper.getChoice_string(), Integer.class);
        List<Integer> answerIdList = JSON.parseArray(paper.getChoice_string(), Integer.class);
        for (int id : choiceIdList) {
            choiceList.add(pro_choiceService.getChoiceProById(id));
        }
        for (int id : completionIdList) {
            completionList.add(pro_completionService.getCompletionProById(id));
        }
        for (int id : answerIdList) {
            answerList.add(pro_answerService.getAnswerProById(id));
        }
        paper.setChoices(choiceList);
        paper.setAnswers(answerList);
        paper.setCompletions(completionList);
        return Result.success(paper);
    }


    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public Result<Void> answerPaperById(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException {
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(body);
        int paper_no = jsonObject.getInteger("paper_no");//获取试题号
        String user_name = new GetUserContextUtil().getCurrentUsername();//获取用户名
        //List<Object> answer_list = jsonObject.getInteger("data");
        return  Result.success();
    }

    @RequestMapping("/imageUpload")
    public Result<Object> upload(@RequestParam("filename") MultipartFile file, Map<String, Object> map){
        String username=new GetUserContextUtil().getCurrentUsername();
        String realPath= FileUtils.upload(file, path, file.getOriginalFilename());
        if (realPath!=null){
            studentService.saveUserImage(realPath,username);
            return Result.success("图片上传成功");
        }else {
            return Result.success("图片上传失败");
        }

    }

    @RequestMapping(value = "/getUserImage",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage() throws IOException {
        String userName =new GetUserContextUtil().getCurrentUsername();
        FileInputStream inputStream=new FileInputStream(new File(studentService.getUserImageSrc(userName)));
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }



}
