package com.huang.springbootdemo.entity;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

//学生
@Table(name = "student")
public class Student {
    @Column(name = "username", type = MySqlTypeConstant.VARCHAR, isKey = true, isNull = false, length = 10)
    public String username;//用户名
    @Column(name = "name", type = MySqlTypeConstant.VARCHAR, length = 111)
    public String name;//姓名
    @Column(name = "id", type = MySqlTypeConstant.VARCHAR, length = 111)
    public String id;//id
    @Column(name = "_class", type = MySqlTypeConstant.VARCHAR, length = 111)
    public String _class;//班级
    @Column(name = "school", type = MySqlTypeConstant.VARCHAR, length = 111)
    public String school;//学校
    @Column(name = "grade", type = MySqlTypeConstant.VARCHAR, length = 111)
    public String grade;//年级
    @Column(name = "sex", type = MySqlTypeConstant.VARCHAR, length = 111)
    public String sex;//性别
    @Column(name = "email", type = MySqlTypeConstant.VARCHAR, length = 111)
    public String email;//邮件
}
