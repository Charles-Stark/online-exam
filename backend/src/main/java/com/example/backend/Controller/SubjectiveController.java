package com.example.backend.Controller;

import com.example.backend.PO.SubjectiveQuestion;
import com.example.backend.Service.SQ;
import com.example.backend.Vo.ResultVo;
import com.example.backend.mapper.SQMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sq")
public class SubjectiveController {

    @Autowired
    SQ sq;
    @Autowired
    SQMapper sqMapper;

    @GetMapping("/all")
    ResultVo<List<SubjectiveQuestion>> showAllSubjectiveQuestion(@RequestParam("coursename") String courseName) {

        try {
            List<SubjectiveQuestion> subjectiveQuestionList = sq.showAllQuestion(courseName);
            return new ResultVo<>(0, "获取主观题成功", subjectiveQuestionList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "获取主观题失败", null);
        }
    }


    @GetMapping("/detail/{questionid}")
    ResultVo<SubjectiveQuestion> getQuestionDetail(@PathVariable String questionid) {

        try {
            SubjectiveQuestion subjectiveQuestion = sqMapper.selectById(questionid);
            return new ResultVo<>(0, "获取主观题详情成功", subjectiveQuestion);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "获取主观题详情失败", null);
        }
    }


    @PostMapping("/update")
    ResultVo updateQuestion(@RequestBody SubjectiveQuestion subjectiveQuestion) {

        try {
            sqMapper.updateById(subjectiveQuestion);
            return new ResultVo<>(0, "修改主观题成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "修改主观题失败", null);
        }
    }


    @PostMapping("/create")
    ResultVo<SubjectiveQuestion> createQuestion(@RequestBody SubjectiveQuestion subjectiveQuestion) {

        try {
            sqMapper.insert(subjectiveQuestion);
            return new ResultVo<>(0, "创建主观题成功", subjectiveQuestion);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "创建主观题失败", null);
        }
    }


    @GetMapping("/delete/{questionid}")
    ResultVo deleteQuestion(@PathVariable String questionid) {

        try {
            sqMapper.deleteById(questionid);
            return new ResultVo<>(0, "删除主观题成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo(-1, "删除主观题失败", null);
        }
    }
}
