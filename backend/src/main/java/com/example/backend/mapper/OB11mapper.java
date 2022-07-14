package com.example.backend.mapper;

import com.example.backend.domain.Objective_question1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OB11mapper {
    public List<Objective_question1> selectQuestionByCourseName(String courseName);
    public Objective_question1 selectQuestionbyQuestionid(Long questionid);
}
