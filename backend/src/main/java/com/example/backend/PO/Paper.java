package com.example.backend.PO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@EnableConfigurationProperties
@AllArgsConstructor
@TableName(value = "paper")
@Component
public class Paper {
    private int id;
    @TableId(value = "paperid")
    private Long paperid;
    private String testlevel;
    private String testcourse;
    private String questionteacher;
    private String question;
    private String questiontype;
    private String questionanswer;

    public Paper() {
    }
}
