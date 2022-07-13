package com.example.backend.Controller;

import com.example.backend.PO.Test;
import com.example.backend.Vo.ResultVo;
import com.example.backend.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/exam")
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @GetMapping("/all")
    ResultVo<List<Test>> getAllTest(@RequestParam(required = false) Map map) {

        try {
            List<Test> testList;
            if (map != null) {
                testList = testMapper.selectByMap(map);
            } else {
                testList = testMapper.selectList(null);
            }

            return new ResultVo<>(0, "获取考试成功", testList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "获取考试失败", null);
        }
    }
}
