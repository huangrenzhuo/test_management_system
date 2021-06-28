package com.huang.springbootdemo.mapper;

import com.huang.springbootdemo.entity.Paper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PaperMapper {
    @Select("select * from paper where paper_no=#{paper_no}")
    Paper getPaperById(int paper_no);

    @Insert("insert into paper(choice_string, answer_string, completion_string) values(#{choice},#{answer},#{completion})")
    int insertPaper(String choice, String answer, String completion);

    @Select("select paper_no from paper")
    List<Integer> getAllPaperId();

    @Delete("delete from paper where paper_no=#{paper_no}")
    int deletePaper(int pro_no);
}
