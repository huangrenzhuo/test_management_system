package com.huang.springbootdemo.mapper;

import com.huang.springbootdemo.entity.Pro_Completion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Pro_CompletionMapper {
    @Select("select * from pro_completion where pro_no=#{pro_no}")
    Pro_Completion getCompletionProById(int pro_no);
}
