package com.mt.mapper;


import com.mt.domain.Subjective_question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SQmapper {
    public List<Subjective_question> selectQuestionByCourseName(String courseName);
    public Subjective_question selectQuestionbyQuestionid(Long questionid);
}
