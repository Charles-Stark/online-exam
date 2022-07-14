package com.example.backend.mapper;

import com.example.backend.domain.Objective_question2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OB22mapper {
    public List<Objective_question2> selectQuestionByCourseName(String courseName);
    public Objective_question2 selectQuestionbyQuestionid(Long questionid);
}
