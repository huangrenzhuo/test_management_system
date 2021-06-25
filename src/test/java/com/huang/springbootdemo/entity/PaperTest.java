package com.huang.springbootdemo.entity;

import com.alibaba.fastjson.JSON;
import com.huang.springbootdemo.mapper.PaperMapper;
import com.huang.springbootdemo.mapper.Pro_AnswerMapper;
import com.huang.springbootdemo.mapper.Pro_ChoiceMapper;
import com.huang.springbootdemo.mapper.Pro_CompletionMapper;
import com.huang.springbootdemo.service.Paper.PaperService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PaperTest {

    @Resource
    PaperMapper paperMapper;

    @Resource
    PaperService paperService;

    @Resource
    Pro_AnswerMapper pro_answerMapper;

    @Resource
    Pro_CompletionMapper pro_completionMapper;

    @Resource
    Pro_ChoiceMapper pro_choiceMapper;

    @Test
    void jsonTest(){
//        ArrayList<Integer> choice_ids = new ArrayList<>();
//        choice_ids.add(1);
//        choice_ids.add(5);
//        ArrayList<Integer> answer_ids = new ArrayList<>();
//        answer_ids.add(2);
//        ArrayList<Integer> completion_ids = new ArrayList<>();
//        completion_ids.add(3);
//        Paper paper = new Paper(choice_ids,answer_ids,completion_ids);
//        System.out.println(jsonUtils.intListToJson(choice_ids));
    }

    @Test
    void getAllPaperId(){
        List<Integer> list = paperMapper.getAllPaperId();
        System.out.println(list);

    }

    @Test
    void addPaper(){
        ArrayList<Pro_Choice> choices = new ArrayList<>();
        choices.add(pro_choiceMapper.getChoiceProById(2));
        choices.add(pro_choiceMapper.getChoiceProById(3));
        choices.add(pro_choiceMapper.getChoiceProById(4));
        ArrayList<Pro_Answer> answers = new ArrayList<>();
        answers.add(pro_answerMapper.getAnswerProById(1));
        answers.add(pro_answerMapper.getAnswerProById(2));
        ArrayList<Pro_Completion> completions = new ArrayList<>();
        completions.add(pro_completionMapper.getCompletionProById(1));
        completions.add(pro_completionMapper.getCompletionProById(2));
        completions.add(pro_completionMapper.getCompletionProById(3));

        ArrayList<Integer> choices_ids = new ArrayList<>();
        choices_ids.add(2);
        choices_ids.add(3);
//        choices_ids.add(4);
        ArrayList<Integer> answers_ids = new ArrayList<>();
        answers_ids.add(1);
        answers_ids.add(2);
        ArrayList<Integer> completions_ids = new ArrayList<>();
        completions_ids.add(1);
        completions_ids.add(2);
        completions_ids.add(3);
        paperService.insertPaper(new Paper(JSON.toJSONString(choices_ids),JSON.toJSONString(answers_ids),JSON.toJSONString(completions_ids)));
    }


}