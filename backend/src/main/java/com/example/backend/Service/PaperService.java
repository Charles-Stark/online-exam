package com.example.backend.Service;

import com.example.backend.PO.Paper;

import java.util.List;
import java.util.Map;

public interface PaperService {

    List<Paper> getAllPaper(Map map);

    Paper getPaperDetail(String paperid);

    void updatePaper(Paper paper);

    Paper createPaper(Paper paper);

    Paper generatePaper(Paper paper);

    void deletePaper(String paperid);

    Long generatePaperId();
}
