package com.example.backend.Service.impl;

import com.example.backend.PO.Paper;
import com.example.backend.Service.PaperService;
import com.example.backend.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperMapper paperMapper;


    @Override
    public List<Paper> getAllPaper(Map map) {
        return paperMapper.selectByMap(map);
    }

    @Override
    public Paper getPaperDetail(String paperid) {
        return paperMapper.selectById(paperid);
    }

    @Override
    public void updatePaper(Paper paper) {
        paperMapper.updateById(paper);
    }

    @Override
    public Paper createPaper(Paper paper) {
        paperMapper.insert(paper);
        return paper;
    }

    @Override
    public Paper generatePaper(Paper paper) {
        return null;
    }

    @Override
    public void deletePaper(String paperid) {
        paperMapper.deleteById(paperid);
    }
}
