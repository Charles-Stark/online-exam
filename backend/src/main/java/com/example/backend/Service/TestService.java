package com.example.backend.Service;

import com.example.backend.PO.Test;

import java.util.List;
import java.util.Map;

public interface TestService {

    List<Test> getAllTest(Map map);

    Test getTestDetail(String testid);

    void deleteTest(String testid);
}
