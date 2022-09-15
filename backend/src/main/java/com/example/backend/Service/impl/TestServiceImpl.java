package com.example.backend.Service.impl;

import com.example.backend.PO.Test;
import com.example.backend.Service.TestService;
import com.example.backend.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    public List<Test> getAllTest(Map map) {
        return testMapper.selectByMap(map);
    }

    @Override
    public Test getTestDetail(String testid) {
        return testMapper.selectById(testid);
    }

    @Override
    public void updateTest(Test test) {
        testMapper.updateById(test);
    }

    @Override
    public Test createTest(Test test) {
        testMapper.insert(test);
        return test;
    }

    @Override
    public void deleteTest(String testid) {
        testMapper.deleteById(testid);
    }
}
