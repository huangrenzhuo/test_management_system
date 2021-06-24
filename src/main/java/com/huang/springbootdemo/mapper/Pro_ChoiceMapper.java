package com.huang.springbootdemo.mapper;

import com.huang.springbootdemo.entity.Pro_Choice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Pro_ChoiceMapper {

    @Select("select * from pro_choice where pro_no=#{pro_no}")
    Pro_Choice getChoiceProById(int pro_no);

}
