package com.example.backend.Vo;


import lombok.Data;

@Data
public class WrongAnswerVo {

    Long questionid;
    String questioninfo;
    String rightAnswer;
    String wrongAnswer;


    public WrongAnswerVo(Long questionid, String questioninfo, String rightAnswer, String wrongAnswer) {
        this.questionid = questionid;
        this.questioninfo = questioninfo;
        this.rightAnswer = rightAnswer;
        this.wrongAnswer = wrongAnswer;
    }


    public WrongAnswerVo() {
    }
}
