package com.mt.mapper;

import com.mt.domain.Objective_question2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OB2mapper {
    public List<Objective_question2> selectQuestionByCourseName(String courseName);
    public Objective_question2 selectQuestionbyQuestionid(Long questionid);
}
