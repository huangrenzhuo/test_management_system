package com.huang.springbootdemo.mapper;

import com.huang.springbootdemo.entity.Pro_Completion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Pro_CompletionMapper {

    @Select("select * from pro_completion where pro_no=#{pro_no}")
    Pro_Completion getCompletionProById(int pro_no);

    @Select("select pro_no from pro_completion")
    List<Integer> getAllCompletionId();
}
