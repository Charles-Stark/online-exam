package com.example.backend.Service.impl;

import com.example.backend.PO.Paper;
import com.example.backend.Service.PaperService;
import com.example.backend.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperMapper paperMapper;


    @Override
    public List<Paper> getAllPaper(Map map) {
        return null;
    }

    @Override
    public Paper getPaperDetail(String paperid) {
        return null;
    }

    @Override
    public void updatePaper(Paper paper) {

    }

    @Override
    public Paper createPaper(Paper paper) {
        return null;
    }

    @Override
    public void deletePaper(String paperid) {

    }
}
