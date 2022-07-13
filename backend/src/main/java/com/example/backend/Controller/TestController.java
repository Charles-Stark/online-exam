package com.example.backend.Controller;

import com.example.backend.PO.Test;
import com.example.backend.Vo.ResultVo;
import com.example.backend.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exam")
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @GetMapping("/all")
    ResultVo<List<Test>> getAllTest(@RequestBody Test test) {
        try {
            List<Test> testList = testMapper.selectList(test);


        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "获取考试失败", null);
        }
    }
}
