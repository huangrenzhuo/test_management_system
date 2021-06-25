package com.huang.springbootdemo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

//选择题
@Table(name = "pro_choice")
public class Pro_Choice {
    @Column(name = "pro_no",type = MySqlTypeConstant.BIGINT,isKey = true,isAutoIncrement = true,isNull = false,length = 10)
    private int pro_no;
    @Column(name = "pro_detail",type = MySqlTypeConstant.VARCHAR,length = 2000)
    private String pro_detail;
    @Column(name = "choice_a",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String choice_a;
    @Column(name = "choice_b",type = MySqlTypeConstant.VARCHAR,length =255)
    private String choice_b;
    @Column(name = "choice_c",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String choice_c;
    @Column(name = "choice_d",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String choice_d;
    @Column(name = "answer",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String answer;
    @Column(name = "explanation",type = MySqlTypeConstant.VARCHAR,length = 2000)
    private String explanation;

    public int getPro_no() {
        return pro_no;
    }

    public String getPro_detail() {
        return pro_detail;
    }

    public String getChoice_a() {
        return choice_a;
    }

    public String getChoice_b() {
        return choice_b;
    }

    public String getChoice_c() {
        return choice_c;
    }

    public String getChoice_d() {
        return choice_d;
    }

    public String getAnswer() {
        return answer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setPro_no(int pro_no) {
        this.pro_no = pro_no;
    }

    public void setPro_detail(String pro_detail) {
        this.pro_detail = pro_detail;
    }

    public void setChoice_a(String choice_a) {
        this.choice_a = choice_a;
    }

    public void setChoice_b(String choice_b) {
        this.choice_b = choice_b;
    }

    public void setChoice_c(String choice_c) {
        this.choice_c = choice_c;
    }

    public void setChoice_d(String choice_d) {
        this.choice_d = choice_d;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

}
