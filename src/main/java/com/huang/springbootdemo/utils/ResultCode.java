package com.huang.springbootdemo.utils;

//用于封装返回的提示码和提示信息
//用于无
public enum ResultCode {

    //成功
    SUCCESS(1),
    //失败
    FAILURE(-1);


    private final Integer code;


    ResultCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }


}
