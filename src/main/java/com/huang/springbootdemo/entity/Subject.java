package com.huang.springbootdemo.entity;

public enum Subject {

    MATH("数学"),
    CHINESE("语文"),
    ENGLISH("英语");

    private String subject;

    Subject(String subject){
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
