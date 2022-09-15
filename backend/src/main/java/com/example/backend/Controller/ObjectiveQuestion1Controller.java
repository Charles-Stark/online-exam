package com.example.backend.Controller;

import com.example.backend.PO.ObjectiveQuestion1;
import com.example.backend.Service.OB1;
import com.example.backend.Vo.ResultVo;
import com.example.backend.mapper.OB1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ob1")
public class ObjectiveQuestion1Controller {

    @Autowired
    OB1 ob1;
    @Autowired
    OB1Mapper ob1Mapper;

    @GetMapping("/all")
    ResultVo<List<ObjectiveQuestion1>> showAllObjectiveQuestion1(@RequestParam("coursename") String courseName) {

        try {
            List<ObjectiveQuestion1> objectiveQuestion1List = ob1.showAllQuestion(courseName);
            return new ResultVo<>(0, "获取选择题成功", objectiveQuestion1List);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "获取选择题失败", null);
        }
    }

    
    @GetMapping("/detail/{questionid}")
    ResultVo<ObjectiveQuestion1> getQuestionDetail(@PathVariable String questionid) {

        try {
            ObjectiveQuestion1 objectiveQuestion1 = ob1Mapper.selectById(questionid);
            return new ResultVo<>(0, "获取选择题详情成功", objectiveQuestion1);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "获取选择题详情失败", null);
        }
    }


    @PostMapping("/update")
    ResultVo updateQuestion(@RequestBody ObjectiveQuestion1 objectiveQuestion1) {

        try {
            ob1Mapper.updateById(objectiveQuestion1);
            return new ResultVo<>(0, "修改选择题成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "修改选择题失败", null);
        }
    }


    @PostMapping("/create")
    ResultVo<ObjectiveQuestion1> createQuestion(@RequestBody ObjectiveQuestion1 objectiveQuestion1) {

        try {
            ob1Mapper.insert(objectiveQuestion1);
            return new ResultVo<>(0, "创建选择题成功", objectiveQuestion1);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "创建选择题失败", null);
        }
    }


    @GetMapping("/delete/{questionid}")
    ResultVo deleteQuestion(@PathVariable String questionid) {

        try {
            ob1Mapper.deleteById(questionid);
            return new ResultVo<>(0, "删除选择题成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo(-1, "删除选择题失败", null);
        }
    }
    
}
