package com.huang.springbootdemo.mapper;

import com.huang.springbootdemo.entity.Pro_Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Pro_AnswerMapper {

    @Select("select * from pro_answer where pro_no=#{pro_no}")
    Pro_Answer getAnswerProById(int pro_no);

    @Select("select pro_no from pro_answer")
    List<Integer> getAllAnswerId();
}
