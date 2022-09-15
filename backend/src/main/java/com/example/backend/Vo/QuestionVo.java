package com.example.backend.Vo;

import com.example.backend.PO.ObjectiveQuestion1;
import com.example.backend.PO.ObjectiveQuestion2;
import com.example.backend.PO.SubjectiveQuestion;
import lombok.Data;

import java.util.List;

@Data
public class QuestionVo {

    List<ObjectiveQuestion1> objectiveQuestion1List;
    List<ObjectiveQuestion2> objectiveQuestion2List;
    List<SubjectiveQuestion> subjectiveQuestionList;

    public QuestionVo(List<ObjectiveQuestion1> objectiveQuestion1List, List<ObjectiveQuestion2> objectiveQuestion2List, List<SubjectiveQuestion> subjectiveQuestionList) {
        this.objectiveQuestion1List = objectiveQuestion1List;
        this.objectiveQuestion2List = objectiveQuestion2List;
        this.subjectiveQuestionList = subjectiveQuestionList;
    }
}
