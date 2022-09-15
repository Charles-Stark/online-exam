package com.example.backend.PO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@EnableConfigurationProperties
@AllArgsConstructor
@TableName(value = "test")
@Component
public class Test {
    private int id;
    private long paperid;
    private String course;
    private String madedate;
    private int limitedtime;
    private long teacherid;
    @TableId(value = "testid")
    private long testid;
    private long mader;

    public Test() {
    }

}
