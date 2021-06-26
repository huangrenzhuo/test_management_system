package com.huang.springbootdemo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

//问答题
@Table(name = "pro_answer")
public class Pro_Answer {
    @Column(name = "pro_no",type = MySqlTypeConstant.BIGINT,isKey = true,isAutoIncrement = true,isNull = false,length = 10)
    private int pro_no;
    @Column(name = "pro_detail",type = MySqlTypeConstant.VARCHAR,length = 2000)
    private String pro_detail;
    @Column(name = "answer",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String answer;
    @Column(name = "explanation",type = MySqlTypeConstant.VARCHAR,length = 2000)
    private String explanation;
    @Column(name = "subject",type = MySqlTypeConstant.VARCHAR,length = 255)
    private  String subject;

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
}
