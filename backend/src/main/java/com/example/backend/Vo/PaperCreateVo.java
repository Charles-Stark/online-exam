package com.example.backend.Vo;

import com.example.backend.PO.Paper;
import com.example.backend.PO.Test;
import lombok.Data;

@Data
public class PaperCreateVo {

    Long paperid;
    Long testid;

    Paper paper;
    Test test;

    public PaperCreateVo(Long paperid, Long testid, Paper paper, Test test) {
        this.paperid = paperid;
        this.testid = testid;
        this.paper = paper;
        this.test = test;
    }
}
