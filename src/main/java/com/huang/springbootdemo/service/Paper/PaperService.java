package com.huang.springbootdemo.service.Paper;

import com.huang.springbootdemo.entity.Paper;

import java.util.List;

public interface PaperService {
    Paper getPaperById(int paper_no);
    int insertPaper(Paper paper);
    List<Integer> getAllPaperId();
}
