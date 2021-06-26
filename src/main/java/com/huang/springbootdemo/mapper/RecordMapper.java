package com.huang.springbootdemo.mapper;

import com.huang.springbootdemo.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RecordMapper {

    @Select("select * from record where username=#{username}")
    List<Record> getRecordsByUsername(String username);

}
