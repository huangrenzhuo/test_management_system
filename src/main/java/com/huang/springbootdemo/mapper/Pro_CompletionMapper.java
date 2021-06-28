package com.huang.springbootdemo.mapper;

import com.huang.springbootdemo.entity.Pro_Completion;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Pro_CompletionMapper {

    @Select("select * from pro_completion where pro_no=#{pro_no}")
    Pro_Completion getCompletionProById(int pro_no);

    @Select("select pro_no from pro_completion")
    List<Integer> getAllCompletionId();

    @Select("select pro_no from pro_completion where subject=#{subject}")
    List<Integer> getAllAnswerIdBySubject(String subject);

    @Insert("insert into pro_completion(pro_detail, blank_num, answer, explanation, subject) values(#{pro_detail}, #{blank_num}, #{answer}, #{explanation}, #{subject})")
    int insertCompletion(String pro_detail, int blank_num, String answer, String explanation, String subject);

    @Update("update pro_completion set pro_detail=#{pro_detail}, blank_num=#{blank_num}, answer=#{answer}, explanation=#{explanation}, subject=#{subject} where pro_no = #{pro_no}")
    int updateCompletion(String pro_detail, int blank_num, String answer, String explanation, String subject, int pro_no);

    @Select("select subject from pro_completion where pro_no=#{pro_no}")
    String getSubjectById(int pro_no);

    @Delete("delete from pro_completion where pro_no=#{pro_no}")
    int deleteCompletion(int pro_no);

}
