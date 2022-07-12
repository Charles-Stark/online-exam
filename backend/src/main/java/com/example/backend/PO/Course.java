package com.example.backend.PO;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@EnableConfigurationProperties
@TableName(value = "objective_question1")
@Component
public class Course {
    private int id;
    private long courseid;
    private String coursename;
    private String specialty;
}
