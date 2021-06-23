package com.huang.springbootdemo.entity;

public enum Authority {
    Responsible_man("responsible_man"), Administrator("administrator"), Student("student");

    String authority;

    Authority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
