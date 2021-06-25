package com.huang.springbootdemo.entity;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

//填空题
@Table(name = "pro_completion")
public class Pro_Completion {
    @Column(name = "pro_no",type = MySqlTypeConstant.BIGINT,isKey = true,isAutoIncrement = true,isNull = false,length = 10)
    private int pro_no;
    @Column(name = "pro_detail",type = MySqlTypeConstant.VARCHAR,length = 2000)
    private String pro_detail;
    @Column(name = "blank_num",type = MySqlTypeConstant.INT)
    private int blank_num;
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

    public int getBlank_num() {
        return blank_num;
    }

    public String getAnswer() {
        return answer;
    }

    public String getExplanation() {
        return explanation;
    }
}
