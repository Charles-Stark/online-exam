package com.example.backend.PO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.backend.Vo.WrongAnswerVo;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@EnableConfigurationProperties
@TableName(value = "objective_question1")
@Component
public class ObjectiveQuestion1 {
    private int id;
    @TableId(value = "questionid")
    private Long questionid;
    private String questionname;
    private String questioninfo;
    private String questionanswer;
    private String choice_a;
    private String choice_b;
    private String choice_c;
    private String choice_d;


    public WrongAnswerVo generateWAVo(String wa) {

        String rightAnswer, wrongAnswer;

        questionanswer = questionanswer.toUpperCase();
        rightAnswer = questionanswer + ". " + switch (questionanswer) {
            case "A" -> choice_a;
            case "B" -> choice_b;
            case "C" -> choice_c;
            case "D" -> choice_d;
            default -> "";
        };

        wa = wa.toUpperCase();
        wrongAnswer = wa + ". " + switch (wa) {
            case "A" -> choice_a;
            case "B" -> choice_b;
            case "C" -> choice_c;
            case "D" -> choice_d;
            default -> "";
        };

        return new WrongAnswerVo(questionid, questioninfo, rightAnswer, wrongAnswer);
    }

}
