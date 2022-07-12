package com.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@EnableConfigurationProperties
@TableName(value = "objective_question2")
@Component
public class objective_question2 {
    private int id;
    private Long questionid;
    private String questionname;
    private String questioninfo;
    private String questionanswer;
    private String choice1;
    private String choice2;
}
