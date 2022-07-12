package com.example.backend.PO;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@EnableConfigurationProperties
@TableName(value = "objective_question1")
@Component
public class ObjectiveQuestion1 {
    private int id;
    private Long questionid;
    private String questionname;
    private String questioninfo;
    private String questionanswer;
    private String choice_a;
    private String choice_b;
    private String choice_c;
    private String choice_d;
}
