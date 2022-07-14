package com.example.backend.mapper;


import com.example.backend.domain.Paper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Paper1mapper {
    public Paper selectPaperByPaperId(Long id);
    public void insertPaper(Integer id,Long paperid,String testlevel,String testcourse,Long questionteacher,String question,String questiontype,String questionanswer);
}
