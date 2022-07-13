package com.example.backend.Controller;

import com.example.backend.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/paper")
public class PaperController {

    @Autowired
    private PaperMapper paperMapper;
}
