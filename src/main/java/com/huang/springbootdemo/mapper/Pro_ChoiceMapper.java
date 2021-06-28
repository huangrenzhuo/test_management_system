package com.huang.springbootdemo.mapper;

import com.huang.springbootdemo.entity.Pro_Choice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Pro_ChoiceMapper {

    @Select("select * from pro_choice where pro_no=#{pro_no}")
    Pro_Choice getChoiceProById(int pro_no);

    @Select("select pro_no from pro_choice")
    List<Integer> getAllChoiceId();

    @Select("select pro_no from pro_choice where subject=#{subject}")
    List<Integer> getAllAnswerIdBySubject(String subject);

    @Insert("insert into pro_choice(pro_detail,choice_a,choice_b,choice_c,choice_d,answer,explanation,subject) values(#{pro_detail},#{choice_a},#{choice_b},#{choice_c},#{choice_d},#{answer},#{explanation},#{subject})")
    int insertChoice(String pro_detail, String choice_a, String choice_b, String choice_c, String choice_d, String answer, String explanation, String subject);

    @Update("update pro_choice set pro_detail=#{pro_detail}, choice_a=#{choice_a}, choice_b=#{choice_b}, choice_c=#{choice_c}, choice_d=#{choice_d}, answer=#{answer}, explanation=#{explanation}, subject=#{subject} where pro_no=#{pro_no}")
    int updateChoice(String pro_detail, String choice_a, String choice_b, String choice_c, String choice_d, String answer, String explanation, String subject, int pro_no);

    @Select("select subject from pro_choice where pro_no=#{pro_no}")
    String getSubjectById(int pro_no);

    @Delete("delete from pro_choice where pro_no=#{pro_no}")
    int deleteChoice(int pro_no);

}
