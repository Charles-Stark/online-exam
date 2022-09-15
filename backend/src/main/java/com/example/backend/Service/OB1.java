package com.example.backend.Service;

import com.example.backend.PO.ObjectiveQuestion1;
import com.example.backend.mapper.OB1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OB1 {

    @Autowired
    private OB1Mapper ob1Mapper;

    private Random random = new Random();

    public List<ObjectiveQuestion1> showAllQuestion(String courseName) {
        Map map = new HashMap<>();
        map.put("questionname", courseName);
        return ob1Mapper.selectByMap(map);
    }

    public int countAllQuestion(String courseName) {
        Map map = new HashMap<>();
        map.put("questionname", courseName);
        return ob1Mapper.selectByMap(map).toArray().length;
    }

    public List<Long> randomSelect(int num, String courseName) {
        Map map = new HashMap<>();
        map.put("questionname", courseName);
        List<ObjectiveQuestion1> objectiveQuestion1List = ob1Mapper.selectByMap(map);

        int start = random.nextInt(objectiveQuestion1List.toArray().length - num + 1);

        List<Long> res = new ArrayList<>();
        while (num-- > 0) {
            res.add(objectiveQuestion1List.get(start++).getQuestionid());
        }
        return res;
    }

    public List<ObjectiveQuestion1> showSelectedQuestion(List<Long> questionId) {
        List<ObjectiveQuestion1> list = new ArrayList<>();
        questionId.forEach((id) -> {
            list.add(ob1Mapper.selectById(id));
        });
        return list;
    }

    public String showSelectedQuestion(String questionId) {
        return ob1Mapper.selectById(questionId).toString();
    }

    public boolean judgeOb1(Long questionid, String submittedAns) {

        return ob1Mapper.selectById(questionid).getQuestionanswer().toUpperCase().equals(submittedAns.toUpperCase());
    }
}
