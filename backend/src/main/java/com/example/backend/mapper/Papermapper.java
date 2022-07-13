package com.example.backend.mapper;


import com.example.backend.PO.Paper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Papermapper {
    public Paper selectPaperByPaperId(Long id);
    public void insertPaper(Integer id,Long paperid,String testlevel,String testcourse,Long questionteacher,String question,String questiontype,String questionanswer);
}
