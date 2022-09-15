package com.example.backend.Service;

import com.example.backend.PO.SubjectiveQuestion;
import com.example.backend.mapper.SQMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SQ {

    @Autowired
    private SQMapper sqMapper;

    private Random random = new Random();

    public List<SubjectiveQuestion> showAllQuestion(String courseName) {
        Map map = new HashMap<>();
        map.put("questionname", courseName);
        return sqMapper.selectByMap(map);
    }

    public int countAllQuestion(String courseName) {
        Map map = new HashMap<>();
        map.put("questionname", courseName);
        return sqMapper.selectByMap(map).toArray().length;
    }

    public List<Long> randomSelect(int num, String courseName) {
        Map map = new HashMap<>();
        map.put("questionname", courseName);
        List<SubjectiveQuestion> subjectiveQuestionList = sqMapper.selectByMap(map);

        int start = random.nextInt(subjectiveQuestionList.toArray().length - num + 1);

        List<Long> res = new ArrayList<>();
        while (num-- > 0) {
            res.add(Long.parseLong(subjectiveQuestionList.get(start++).getQuestionid()));
        }
        return res;
    }

    public List<SubjectiveQuestion> showSelectedQuestion(List<Long> questionId) {
        List<SubjectiveQuestion> list = new ArrayList<>();
        questionId.forEach((id) -> {
            list.add(sqMapper.selectById(id));
        });
        return list;
    }

    public String showSelectedQuestion(String questionId) {
        return sqMapper.selectById(questionId).toString();
    }

    public boolean judgeSq(Long questionid, String submittedAns) {

        return sqMapper.selectById(questionid).getQuestionanswer().equals(submittedAns);
    }
}
