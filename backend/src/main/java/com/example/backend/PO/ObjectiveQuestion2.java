package com.example.backend.PO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.backend.Vo.WrongAnswerVo;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@EnableConfigurationProperties
@TableName(value = "objective_question2")
@Component
public class ObjectiveQuestion2 {
    private int id;
    @TableId(value = "questionid")
    private Long questionid;
    private String questionname;
    private String questioninfo;
    private String questionanswer;
    private String choice1;
    private String choice2;


    public WrongAnswerVo generateWAVo(String wa) {

        return new WrongAnswerVo(questionid, questioninfo, questionanswer, wa);
    }

}
