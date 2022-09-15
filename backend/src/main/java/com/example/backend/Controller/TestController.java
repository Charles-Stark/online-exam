package com.example.backend.Controller;

import com.example.backend.PO.Test;
import com.example.backend.Service.impl.TestServiceImpl;
import com.example.backend.Vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/exam")
public class TestController {

    @Autowired
    private TestServiceImpl testService;

    @GetMapping("/all")
    ResultVo<List<Test>> getAllTest(@RequestParam(required = false) Map map) {

        try {
            List testList;
            if (map != null) {
                testList = testService.getAllTest(map);
            } else {
                testList = testService.getAllTest(null);
            }

            return new ResultVo<>(0, "获取考试成功", testList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "获取考试失败", null);
        }
    }


    @GetMapping("/detail/{testid}")
    ResultVo<Test> getTestDetail(@PathVariable String testid) {

        try {
            Test test = testService.getTestDetail(testid);
            return new ResultVo<>(0, "获取考试详情成功", test);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "获取考试详情失败", null);
        }
    }


    @PostMapping("/update")
    ResultVo updateTest(@RequestBody Test test) {

        try {
            testService.updateTest(test);
            return new ResultVo<>(0, "修改考试成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "修改考试失败", null);
        }
    }


    @PostMapping("/create")
    ResultVo<Test> createTest(@RequestBody Test test) {

        try {
            testService.createTest(test);
            return new ResultVo<>(0, "创建考试成功", test);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "创建考试失败", null);
        }
    }


    @GetMapping("/delete/{testid}")
    ResultVo deleteTest(@PathVariable String testid) {

        try {
            testService.deleteTest(testid);
            return new ResultVo<>(0, "删除考试成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo(-1, "删除考试失败", null);
        }
    }
}
