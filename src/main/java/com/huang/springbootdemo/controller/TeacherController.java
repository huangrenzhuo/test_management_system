package com.huang.springbootdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huang.springbootdemo.entity.Paper;
import com.huang.springbootdemo.entity.Pro_Answer;
import com.huang.springbootdemo.entity.Pro_Choice;
import com.huang.springbootdemo.entity.Pro_Completion;
import com.huang.springbootdemo.service.Pro_Answer.Pro_AnswerService;
import com.huang.springbootdemo.service.Pro_Choice.Pro_ChoiceService;
import com.huang.springbootdemo.service.Pro_Completion.Pro_CompletionService;
import com.huang.springbootdemo.utils.RandomUtils;
import com.huang.springbootdemo.utils.Result;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class TeacherController {
    @Resource
    Pro_ChoiceService pro_choiceService;

    @Resource
    Pro_CompletionService pro_completionService;

    @Resource
    Pro_AnswerService pro_answerService;

    @RequestMapping(value = "/problem", method = RequestMethod.GET)
    public Result<Object> getProblem(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(body);
        String pro_type = jsonObject.getString("pro_type");
        int pro_no = jsonObject.getInteger("pro_no");
        if (pro_type.equals("pro_choice")) {
            Pro_Choice pro_choice = pro_choiceService.getChoiceProById(pro_no);
            return Result.success(pro_choice);
        } else if (pro_type.equals("pro_answer")) {
            Pro_Answer pro_answer = pro_answerService.getAnswerProById(pro_no);
            return Result.success(pro_answer);
        } else if (pro_type.equals("pro_completion")) {
            Pro_Completion pro_completion = pro_completionService.getCompletionProById(pro_no);
            return Result.success(pro_completion);
        } else {
            return Result.fail(-1, "错误的pro_type格式");
        }
    }

    @RequestMapping("/getRandomPaper")
    public Result<Object> getRandomPaper(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(body);
        int choiceNum = jsonObject.getInteger("choiceNum");
        int answerNum = jsonObject.getInteger("answerNum");
        int completionNum = jsonObject.getInteger("completionNum");

        List<Integer> choiceIdList = pro_choiceService.getAllChoiceId();
        List<Integer> answerIdList = pro_answerService.getAllAnswerId();
        List<Integer> completionIdList = pro_completionService.getAllCompletionId();

        List<Pro_Choice> choiceList = new ArrayList<>();
        List<Pro_Completion> completionList = new ArrayList<>();
        List<Pro_Answer> answerList = new ArrayList<>();

        if (choiceNum > choiceIdList.size()) {
            return Result.fail(-1, "所选选择题数量超过题库总量");
        } else if (answerNum > answerIdList.size()) {
            return Result.fail(-1, "所选问答题数量超过题库总量");
        } else if (completionNum > completionIdList.size()) {
            return Result.fail(-1, "所选填空题数量超过题库总量");
        } else {
            for(int index : RandomUtils.getNIntBetweenRange(0,choiceIdList.size()-1,choiceNum)){
                choiceList.add(pro_choiceService.getChoiceProById(choiceIdList.get(index)));
            }
            for(int index : RandomUtils.getNIntBetweenRange(0,answerIdList.size()-1,answerNum)){
                answerList.add(pro_answerService.getAnswerProById(answerIdList.get(index)));
            }
            for(int index : RandomUtils.getNIntBetweenRange(0,completionIdList.size()-1,completionNum)){
                completionList.add(pro_completionService.getCompletionProById(completionIdList.get(index)));
            }
            //待改！！！ID_LIST
            Paper paper = new Paper(choiceList,answerList,completionList,null,null,null);
//            Paper paper = new Paper(choiceList,answerList,completionList,JSON.toJSONString(choiceIdList),JSON.toJSONString(answerIdList),JSON.toJSONString(completionIdList));
            return Result.success(paper);
        }

    }


}
