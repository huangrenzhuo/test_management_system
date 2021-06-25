package com.huang.springbootdemo.service.Paper.Impl;

import com.huang.springbootdemo.entity.Paper;
import com.huang.springbootdemo.mapper.PaperMapper;
import com.huang.springbootdemo.service.Paper.PaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {
    @Resource
    PaperMapper paperMapper;

    @Override
    public Paper getPaperById(int paper_no) {
        Paper paper = paperMapper.getPaperById(paper_no);
        return paper;
    }

    @Override
    public int insertPaper(Paper paper) {
        int result = paperMapper.insertPaper(paper.getChoice_string(), paper.getAnswer_string(), paper.getCompletion_string());
        return result;
    }

    @Override
    public List<Integer> getAllPaperId() {
        List<Integer> idList = paperMapper.getAllPaperId();
        return idList;
    }

}
