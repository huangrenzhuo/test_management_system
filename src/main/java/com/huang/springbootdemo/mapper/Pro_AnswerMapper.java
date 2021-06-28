package com.huang.springbootdemo.mapper;

import com.huang.springbootdemo.entity.Pro_Answer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Pro_AnswerMapper {

    @Select("select * from pro_answer where pro_no=#{pro_no}")
    Pro_Answer getAnswerProById(int pro_no);

    @Select("select pro_no from pro_answer")
    List<Integer> getAllAnswerId();

    @Select("select pro_no from pro_answer where subject=#{subject}")
    List<Integer> getAllAnswerIdBySubject(String subject);

    @Insert("insert into pro_answer(pro_detail, answer, explanation, subject) values(#{pro_detail}, #{answer}, #{explanation}, #{subject})")
    int insertAnswer(String pro_detail, String answer, String explanation, String subject);

    @Update("update pro_answer set pro_detail=#{pro_detail}, answer=#{answer}, explanation=#{explanation}, subject=#{subject} where pro_no=#{pro_no}")
    int updateAnswer(String pro_detail, String answer, String explanation, String subject, int pro_no);

    @Select("select subject from pro_answer where pro_no=#{pro_no}")
    String getSubjectById(int pro_no);

    @Delete("delete from pro_answer where pro_no=#{pro_no}")
    int deleteAnswer(int pro_no);

}
