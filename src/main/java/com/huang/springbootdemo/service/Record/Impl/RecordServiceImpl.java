package com.huang.springbootdemo.service.Record.Impl;

import com.huang.springbootdemo.entity.Record;
import com.huang.springbootdemo.mapper.RecordMapper;
import com.huang.springbootdemo.service.Record.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Resource
    RecordMapper recordMapper;

    @Override
    public List<Record> getRecordsByUsername(String username) {
        return recordMapper.getRecordsByUsername(username);
    }
}
