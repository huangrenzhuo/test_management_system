package com.huang.springbootdemo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

//选择题
@Table(name = "pro_choice")
public class Pro_Choice {
    @Column(name = "pro_no",type = MySqlTypeConstant.BIGINT,isKey = true,isAutoIncrement = true,isNull = false,length = 10)
    int pro_no;
    @Column(name = "pro_detail",type = MySqlTypeConstant.VARCHAR,length = 2000)
    String pro_detail;
    @Column(name = "choice_a",type = MySqlTypeConstant.VARCHAR,length = 255)
    String choice_a;
    @Column(name = "choice_b",type = MySqlTypeConstant.VARCHAR,length =255)
    String choice_b;
    @Column(name = "choice_c",type = MySqlTypeConstant.VARCHAR,length = 255)
    String choice_c;
    @Column(name = " choice_d",type = MySqlTypeConstant.VARCHAR,length = 255)
    String choice_d;
    @Column(name = "answer",type = MySqlTypeConstant.VARCHAR,length = 255)
    String answer;
    @Column(name = "explanation",type = MySqlTypeConstant.VARCHAR,length = 2000)
    String explanation;
}
