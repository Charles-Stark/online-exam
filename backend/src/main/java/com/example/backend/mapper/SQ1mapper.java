package com.example.backend.mapper;


import com.example.backend.domain.Subjective_question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SQ1mapper {
    public List<Subjective_question> selectQuestionByCourseName(String courseName);
    public Subjective_question selectQuestionbyQuestionid(Long questionid);
}
