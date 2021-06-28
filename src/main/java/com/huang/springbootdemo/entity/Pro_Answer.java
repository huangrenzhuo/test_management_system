package com.huang.springbootdemo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

//问答题
@Table(name = "pro_answer")
public class Pro_Answer {
    @Column(name = "pro_no",type = MySqlTypeConstant.BIGINT,isKey = true,isAutoIncrement = true,isNull = false,length = 10)
    private int pro_no;//问题编号
    @Column(name = "pro_detail",type = MySqlTypeConstant.VARCHAR,length = 2000)
    private String pro_detail;//问题内容
    @Column(name = "answer",type = MySqlTypeConstant.VARCHAR,length = 2000)
    private String answer;//问题答案
    @Column(name = "explanation",type = MySqlTypeConstant.VARCHAR,length = 2000)
    private String explanation;//问题解析
    @Column(name = "subject",type = MySqlTypeConstant.VARCHAR,length = 255)
    private  String subject;//问题对应科目

    public int getPro_no() {
        return pro_no;
    }

    public String getPro_detail() {
        return pro_detail;
    }

    public String getAnswer() {
        return answer;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getSubject() {
        return subject;
    }

    public Pro_Answer(String pro_detail, String answer, String explanation, String subject) {
        this.pro_detail = pro_detail;
        this.answer = answer;
        this.explanation = explanation;
        this.subject = subject;
    }

    public Pro_Answer(int pro_no, String pro_detail, String answer, String explanation, String subject) {
        this.pro_no = pro_no;
        this.pro_detail = pro_detail;
        this.answer = answer;
        this.explanation = explanation;
        this.subject = subject;
    }

}
