package com.example.backend.mapper;

import com.example.backend.PO.ObjectiveQuestion1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OB1mapper {
    public List<ObjectiveQuestion1> selectQuestionByCourseName(String courseName);
    public ObjectiveQuestion1 selectQuestionbyQuestionid(Long questionid);
}
