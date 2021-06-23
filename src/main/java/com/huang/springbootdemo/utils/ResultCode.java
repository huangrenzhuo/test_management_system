package com.huang.springbootdemo.utils;

//用于封装返回的提示码和提示信息
//用于无
public enum ResultCode {



    SUCCESS(0, "成功"),
    FAILURE(-1, "失败"),
    USER_NOT_LOGIN_ERROR(403, "用户不存在或密码错误"),
    USER_TOKEN_ERROR(403, "token为空或不符合规范"),
    USER_TOKEN_SIGNATURE(403, "签名错误"),
    USER_TOKEN_EXPIRED(403, "Token过期"),
    USER_TOKEN_AlgorithmMis_Match(403, "生成Token失败"),
    USER_TOKEN_Other_ERROR(403, "其他错误");


    private final Integer code;
    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
