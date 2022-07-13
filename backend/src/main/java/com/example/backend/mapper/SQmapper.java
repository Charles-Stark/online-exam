package com.example.backend.mapper;


import com.example.backend.PO.SubjectiveQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SQmapper {
    public List<SubjectiveQuestion> selectQuestionByCourseName(String courseName);
    public SubjectiveQuestion selectQuestionbyQuestionid(Long questionid);
}
