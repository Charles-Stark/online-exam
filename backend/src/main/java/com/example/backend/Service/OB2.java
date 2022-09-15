package com.example.backend.Service;

import com.example.backend.PO.ObjectiveQuestion2;
import com.example.backend.mapper.OB2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OB2 {

    @Autowired
    private OB2Mapper ob2Mapper;

    private Random random = new Random();

    public List<ObjectiveQuestion2> showAllQuestion(String courseName) {
        Map map = new HashMap<>();
        map.put("questionname", courseName);
        return ob2Mapper.selectByMap(map);
    }

    public int countAllQuestion(String courseName) {
        Map map = new HashMap<>();
        map.put("questionname", courseName);
        return ob2Mapper.selectByMap(map).toArray().length;
    }

    public List<Long> randomSelect(int num, String courseName) {
        Map map = new HashMap<>();
        map.put("questionname", courseName);
        List<ObjectiveQuestion2> objectiveQuestion2List = ob2Mapper.selectByMap(map);

        int start = random.nextInt(objectiveQuestion2List.toArray().length - num + 1);

        List<Long> res = new ArrayList<>();
        while (num-- > 0) {
            res.add(objectiveQuestion2List.get(start++).getQuestionid());
        }
        return res;
    }

    public List<ObjectiveQuestion2> showSelectedQuestion(List<Long> questionId) {
        List<ObjectiveQuestion2> list = new ArrayList<>();
        questionId.forEach((id) -> {
            list.add(ob2Mapper.selectById(id));
        });
        return list;
    }

    public String showSelectedQuestion(String questionId) {
        return ob2Mapper.selectById(questionId).toString();
    }

    public boolean judgeOb2(Long questionid, String submittedAns) {

        return ob2Mapper.selectById(questionid).getQuestionanswer().equals(submittedAns);
    }
}
