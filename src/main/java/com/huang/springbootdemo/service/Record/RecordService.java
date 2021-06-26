package com.huang.springbootdemo.service.Record;

import com.huang.springbootdemo.entity.Record;

import java.util.List;

public interface RecordService {
    List<Record> getRecordsByUsername(String username);
}
