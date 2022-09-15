package com.example.backend.Controller;


import com.example.backend.PO.ObjectiveQuestion1;
import com.example.backend.PO.ObjectiveQuestion2;
import com.example.backend.PO.SubjectiveQuestion;
import com.example.backend.Service.*;
import com.example.backend.Vo.QuestionVo;
import com.example.backend.Vo.ResultVo;
import com.example.backend.Vo.ScoreVo;
import com.example.backend.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class JudgeController {

    @Autowired
    private OB1 ob1;
    @Autowired
    private OB2 ob2;
    @Autowired
    private SQ sq;
    @Autowired
    PaperReader paperReader;
    @Autowired
    PaperMapper paperMapper;


    @PostMapping("/judge")
    ResultVo<ScoreVo> judgePaper(@RequestBody Map map) {

        try {
            System.out.println("judge: " + map);

            Long paperid = Long.valueOf(map.get("paperId").toString());

            List<String> ob1List = new ArrayList<>();
            List<String> ob2List = new ArrayList<>();
            List<String> sqList = new ArrayList<>();
            String ob1Str = map.get("answers1").toString().replace("[", "").replace("]", "").replace("\"", "");
            String ob2Str = map.get("answers2").toString().replace("[", "").replace("]", "").replace("\"", "");
            String sqStr = map.get("answer3").toString().replace("[", "").replace("]", "").replace("\"", "");

            if (ob1Str.contains(",")) {
                ob1List = Arrays.asList(ob1Str.split(","));
            } else {
                ob1List.add(ob1Str);
            }
            if (ob2Str.contains(",")) {
                ob2List = Arrays.asList(ob2Str.split(","));
            } else {
                ob2List.add(ob2Str);
            }
            if (sqStr.contains(",")) {
                sqList = Arrays.asList(sqStr.split(","));
            } else {
                sqList.add(sqStr);
            }

//            An Example:
//            Long paperid = 1052L;
//            List<String> ob1List = new ArrayList<>();
//            ob1List.add("A");
//            List<String> ob2List = new ArrayList<>();
//            ob2List.add("对");
//            ob2List.add("错");
//            List<String> sqList = new ArrayList<>();
//            sqList.add("增大");
//            sqList.add("2:1");


            QuestionVo questionVo = paperReader.read2(paperMapper.selectById(paperid));
            ScoreVo scoreVo = new ScoreVo(paperid);

            int i = 0;
            for (ObjectiveQuestion1 objectiveQuestion1 : questionVo.getObjectiveQuestion1List()) {
                Long questionid = objectiveQuestion1.getQuestionid();
                scoreVo.add(ob1.judgeOb1(questionid, ob1List.get(i)), objectiveQuestion1, ob1List.get(i));
                i++;
            }

            i = 0;
            for (ObjectiveQuestion2 objectiveQuestion2 : questionVo.getObjectiveQuestion2List()) {
                Long questionid = objectiveQuestion2.getQuestionid();
                scoreVo.add(ob2.judgeOb2(questionid, ob2List.get(i)), objectiveQuestion2, ob2List.get(i));
                i++;
            }

            i = 0;
            for (SubjectiveQuestion subjectiveQuestion : questionVo.getSubjectiveQuestionList()) {
                Long questionid = Long.valueOf(subjectiveQuestion.getQuestionid());
                scoreVo.add(sq.judgeSq(questionid, sqList.get(i)), subjectiveQuestion, sqList.get(i));
                i++;
            }

            scoreVo.stats();

            return new ResultVo<>(0, "评卷成功", scoreVo);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "评卷失败", null);
        }

    }

}
