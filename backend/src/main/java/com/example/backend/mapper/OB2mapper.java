package com.example.backend.mapper;

import com.example.backend.PO.ObjectiveQuestion2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OB2mapper {
    public List<ObjectiveQuestion2> selectQuestionByCourseName(String courseName);
    public ObjectiveQuestion2 selectQuestionbyQuestionid(Long questionid);
}
