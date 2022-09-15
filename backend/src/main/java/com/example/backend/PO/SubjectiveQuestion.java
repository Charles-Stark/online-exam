package com.example.backend.PO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.backend.Vo.WrongAnswerVo;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@EnableConfigurationProperties
@TableName(value = "subjective_question")
@Component
public class SubjectiveQuestion {
    private int id;
    @TableId(value = "questionid")
    private String questionid;
    private String questionname;
    private String questioninfo;
    private String questionanswer;


    public WrongAnswerVo generateWAVo(String wa) {

        return new WrongAnswerVo(Long.valueOf(questionid), questioninfo, questionanswer, wa);
    }

}
