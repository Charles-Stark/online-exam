package com.example.backend.PO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@EnableConfigurationProperties
@TableName(value = "course")
@Component
public class Course {
    private int id;
    @TableId(value = "courseid")
    private long courseid;
    private String coursename;
    private String specialty;
}
