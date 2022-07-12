package com.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@EnableConfigurationProperties
@TableName(value = "subjective_question")
@Component
public class subjective_question {
    private int id;
    private String questionid;
    private String questionname;
    private String questioninfo;
    private String questionanswer;
}
