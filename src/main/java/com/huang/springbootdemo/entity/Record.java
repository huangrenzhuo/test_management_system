package com.huang.springbootdemo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.sql.Date;

//做题记录
@Table(name = "record")
public class Record {

    @Column(name = "username", type = MySqlTypeConstant.VARCHAR,isKey = false, isNull = false, length = 111)
    private String username;
    @Column(name = "pro_no", type = MySqlTypeConstant.BIGINT, isKey = false, isNull = false, length = 10)
    private int pro_no;
    @Column(name = "pro_type", type = MySqlTypeConstant.VARCHAR,isKey = false, isNull = false, length = 111)
    private String pro_type;
    @Column(name = "answer",type = MySqlTypeConstant.VARCHAR,length = 2000)
    private String answer;
    @Column(name = "date",type = MySqlTypeConstant.DATE)
    private Date date;

    public String getUsername() {
        return username;
    }

    public int getPro_no() {
        return pro_no;
    }

    public String getPro_type() {
        return pro_type;
    }

    public String getAnswer() {
        return answer;
    }

    public Date getDate() {
        return date;
    }
}
