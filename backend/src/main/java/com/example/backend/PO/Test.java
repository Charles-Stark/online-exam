package com.example.backend.PO;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@EnableConfigurationProperties
@TableName(value = "test")
@Component
public class Test {
    private int id;
    private long paperid;
    private String course;
    private String madedate;
    private int limitedtime;
    private long teacherid;
    private long testid;
    private long mader;
}
