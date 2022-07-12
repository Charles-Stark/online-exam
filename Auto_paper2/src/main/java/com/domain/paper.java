package com.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@EnableConfigurationProperties
@TableName(value = "paper")
@Component
public class paper {
    private int id;
    private Long testid;
    private String testlevel;
    private String testcourse;
    private String questionteacher;
    private String question;
    private String questiontype;
    private String questionanswer;


}
