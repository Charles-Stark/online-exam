package com.example.backend.Controller;

import com.example.backend.PO.ObjectiveQuestion2;
import com.example.backend.Service.OB2;
import com.example.backend.Vo.ResultVo;
import com.example.backend.mapper.OB2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ob2")
public class ObjectiveQuestion2Controller {

    @Autowired
    OB2 ob2;
    @Autowired
    OB2Mapper ob2Mapper;

    @GetMapping("/all")
    ResultVo<List<ObjectiveQuestion2>> showAllObjectiveQuestion2(@RequestParam("coursename") String courseName) {

        try {
            List<ObjectiveQuestion2> objectiveQuestion2List = ob2.showAllQuestion(courseName);
            return new ResultVo<>(0, "获取判断题成功", objectiveQuestion2List);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "获取判断题失败", null);
        }
    }


    @GetMapping("/detail/{questionid}")
    ResultVo<ObjectiveQuestion2> getQuestionDetail(@PathVariable String questionid) {

        try {
            ObjectiveQuestion2 objectiveQuestion2 = ob2Mapper.selectById(questionid);
            return new ResultVo<>(0, "获取判断题详情成功", objectiveQuestion2);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "获取判断题详情失败", null);
        }
    }


    @PostMapping("/update")
    ResultVo updateQuestion(@RequestBody ObjectiveQuestion2 objectiveQuestion2) {

        try {
            ob2Mapper.updateById(objectiveQuestion2);
            return new ResultVo<>(0, "修改判断题成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "修改判断题失败", null);
        }
    }


    @PostMapping("/create")
    ResultVo<ObjectiveQuestion2> createQuestion(@RequestBody ObjectiveQuestion2 objectiveQuestion2) {

        try {
            ob2Mapper.insert(objectiveQuestion2);
            return new ResultVo<>(0, "创建判断题成功", objectiveQuestion2);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "创建判断题失败", null);
        }
    }


    @GetMapping("/delete/{questionid}")
    ResultVo deleteQuestion(@PathVariable String questionid) {

        try {
            ob2Mapper.deleteById(questionid);
            return new ResultVo<>(0, "删除判断题成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo(-1, "删除判断题失败", null);
        }
    }
}
