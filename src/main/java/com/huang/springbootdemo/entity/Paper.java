package com.huang.springbootdemo.entity;

import com.alibaba.fastjson.JSON;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.util.ArrayList;
import java.util.List;

//试卷
@Table(name = "paper")
public class Paper {

    private List<Pro_Choice> choices;
    private List<Pro_Answer> answers;
    private List<Pro_Completion> completions;

    @Column(name = "paper_no", type = MySqlTypeConstant.BIGINT, isKey = true, isAutoIncrement = true, isNull = false, length = 10)
    private int paper_no;
    @Column(name = "choice_string", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String choice_string;
    @Column(name = "answer_string", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String answer_string;
    @Column(name = "completion_string", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String completion_string;

    public Paper(String choice_string, String answer_string, String completion_string) {
        this.choice_string = choice_string;
        this.answer_string = answer_string;
        this.completion_string = completion_string;
    }

    public Paper(List<Pro_Choice> choices, List<Pro_Answer> answers, List<Pro_Completion> completions, String choice_string, String answer_string, String completion_string) {
        this.choices = choices;
        this.answers = answers;
        this.completions = completions;
        this.choice_string = choice_string;
        this.answer_string = answer_string;
        this.completion_string = completion_string;
    }

    public int getPaper_no() {
        return paper_no;
    }

    public String getChoice_string() {
        return choice_string;
    }

    public String getAnswer_string() {
        return answer_string;
    }

    public String getCompletion_string() {
        return completion_string;
    }

    public List<Pro_Choice> getChoices() {
        return choices;
    }

    public List<Pro_Answer> getAnswers() {
        return answers;
    }

    public List<Pro_Completion> getCompletions() {
        return completions;
    }
}

