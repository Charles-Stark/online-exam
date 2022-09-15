package com.example.backend.Service;

import com.example.backend.PO.ObjectiveQuestion1;
import com.example.backend.PO.ObjectiveQuestion2;
import com.example.backend.PO.Paper;
import com.example.backend.PO.SubjectiveQuestion;
import com.example.backend.Vo.QuestionVo;
import com.example.backend.mapper.OB1Mapper;
import com.example.backend.mapper.OB2Mapper;
import com.example.backend.mapper.SQMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PaperReader {

    @Autowired
    OB1 ob1;
    @Autowired
    OB2 ob2;
    @Autowired
    SQ sq;
    @Autowired
    OB1Mapper ob1Mapper;
    @Autowired
    OB2Mapper ob2Mapper;
    @Autowired
    SQMapper sqMapper;

    private String question;
    private String questiontype;
    private String questionanswer;

    public List<String> read(Paper paper1) {
        questiontype = paper1.getQuestiontype();
        question = paper1.getQuestion();

        List<String> paper = new ArrayList<>();
        List<String> type = new ArrayList<>();
        List<String> question1 = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();

        map.put("objective_question1", "选择题");
        map.put("objective_question2", "判断题");
        map.put("subjective_question", "填空题");
        map.put("选择题", "选择题");
        map.put("判断题", "判断题");
        map.put("填空题", "填空题");
        map.put("选择", "选择题");
        map.put("判断", "判断题");
        map.put("填空", "填空题");

        int begin = 0, k = 0;
        for (int i = 0; i < questiontype.length(); i++) {
            char a = questiontype.charAt(i);
            if (a == ',') {
                type.add(questiontype.substring(begin, i));
                begin = i + 1;
            }
        }
        if (begin != questiontype.length()) {
            type.add(questiontype.substring(begin, questiontype.length()));
        }

        question1.add(map.get(type.get(k)));
        k++;
        begin = 0;
        for (int i = 0; i < question.length(); i++) {
            char a = question.charAt(i);
            if (a == ';') {
                question1.add(question.substring(begin, i));
                if (i != question.length() - 1) {
                    question1.add(map.get(type.get(k++)));
                }
                begin = i + 1;
            } else if (a == ',') {
                question1.add(question.substring(begin, i));
                begin = i + 1;
            }
        }
        if (begin != question.length()) {
            question1.add(question.substring(begin, question.length()));
        }

        begin = 0;
        AtomicInteger qt = new AtomicInteger();     //题目类型，1=选择，2=填空，3=判断
        question1.forEach(a -> {
            if (a.equals("选择题")) {
                qt.set(1);
                paper.add(a);
            } else if (a.equals("填空题")) {
                qt.set(2);
                paper.add(a);
            } else if (a.equals("判断题")) {
                qt.set(3);
                paper.add(a);
            } else if (qt.get() == 1) {
                paper.add(toObjectiveQuestion1(ob1Mapper.selectById(Integer.valueOf(a))));
            } else if (qt.get() == 2) {
                paper.add(toObjectiveQuestion2(ob2Mapper.selectById(Integer.valueOf(a))));
            } else if (qt.get() == 3) {
                paper.add(toSubjectiveQuestion(sqMapper.selectById(Integer.valueOf(a))));
            }
        });

        return paper;
    }


    public QuestionVo read2(Paper paper1) {
        questiontype = paper1.getQuestiontype();
        question = paper1.getQuestion();

        List<String> type = new ArrayList<>();
        List<String> question1 = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();

        map.put("objective_question1", "选择题");
        map.put("objective_question2", "判断题");
        map.put("subjective_question", "填空题");
        map.put("选择题", "选择题");
        map.put("判断题", "判断题");
        map.put("填空题", "填空题");
        map.put("选择", "选择题");
        map.put("判断", "判断题");
        map.put("填空", "填空题");

        int begin = 0, k = 0;
        for (int i = 0; i < questiontype.length(); i++) {
            char a = questiontype.charAt(i);
            if (a == ',' && i != 0) {
                type.add(questiontype.substring(begin, i));
                begin = i + 1;
            } else if (a == ',') {
                begin = i + 1;
            }
        }
        if (begin != questiontype.length()) {
            type.add(questiontype.substring(begin, questiontype.length()));
        }

        question1.add(map.get(type.get(k)));
        k++;
        begin = 0;
        for (int i = 0; i < question.length(); i++) {
            char a = question.charAt(i);
            if (a == ';') {
                question1.add(question.substring(begin, i));
                if (i != question.length() - 1) {
                    question1.add(map.get(type.get(k++)));
                }
                begin = i + 1;
            } else if (a == ',') {
                question1.add(question.substring(begin, i));
                begin = i + 1;
            }
        }
        if (begin != question.length()) {
            question1.add(question.substring(begin, question.length()));
        }

        begin = 0;
        List<ObjectiveQuestion1> objectiveQuestion1List = new ArrayList<>();
        List<ObjectiveQuestion2> objectiveQuestion2List = new ArrayList<>();
        List<SubjectiveQuestion> subjectiveQuestionList = new ArrayList<>();
        AtomicInteger qt = new AtomicInteger();     //题目类型，1=选择，2=填空，3=判断
        question1.forEach(a -> {
            if (a.equals("选择题")) {
                qt.set(1);
            } else if (a.equals("填空题")) {
                qt.set(2);
            } else if (a.equals("判断题")) {
                qt.set(3);
            } else if (qt.get() == 1) {
                objectiveQuestion1List.add(ob1Mapper.selectById(Integer.valueOf(a)));
            } else if (qt.get() == 2) {
                subjectiveQuestionList.add(sqMapper.selectById(Integer.valueOf(a)));
            } else if (qt.get() == 3) {
                objectiveQuestion2List.add(ob2Mapper.selectById(Integer.valueOf(a)));
            }
        });

        return new QuestionVo(objectiveQuestion1List, objectiveQuestion2List, subjectiveQuestionList);
    }


    public String toObjectiveQuestion1(ObjectiveQuestion1 objectiveQuestion1) {
        String questioninfo = objectiveQuestion1.getQuestioninfo();
        String choice_a = objectiveQuestion1.getChoice_a();
        String choice_b = objectiveQuestion1.getChoice_b();
        String choice_c = objectiveQuestion1.getChoice_c();
        String choice_d = objectiveQuestion1.getChoice_d();
        return questioninfo + "<br/>"
                + "A." + choice_a + "<br/>"
                + "B." + choice_b + "<br/>"
                + "C." + choice_c + "<br/>"
                + "D." + choice_d + "<br/>";
    }

    public String toObjectiveQuestion2(ObjectiveQuestion2 objectiveQuestion2) {
        String questioninfo = objectiveQuestion2.getQuestioninfo();
        String choice1 = objectiveQuestion2.getChoice1();
        String choice2 = objectiveQuestion2.getChoice2();
        return questioninfo + "<br/>"
                + "A." + choice1 + "<br/>"
                + "B." + choice2 + "<br/>";
    }

    public String toSubjectiveQuestion(SubjectiveQuestion subjectiveQuestion) {
        String questioninfo = subjectiveQuestion.getQuestioninfo();
        return questioninfo + "<br/>" + "<br/>";
    }
}
