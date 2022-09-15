package com.example.backend.Vo;


import com.example.backend.PO.ObjectiveQuestion1;
import com.example.backend.PO.ObjectiveQuestion2;
import com.example.backend.PO.SubjectiveQuestion;
import lombok.Data;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Data
public class ScoreVo {

    Long paperid;

    double score;          // 最终得分 100 * scoringRate
    double scoringRate;    // 得分率 rightNum / (rightNum + wrongNum)
    int rightNum;          // 答对题数
    int wrongNum;          // 错误题数

    List<WrongAnswerVo> ob1WrongAnswerList = new ArrayList<>();   // ob1错题列表
    List<WrongAnswerVo> ob2WrongAnswerList = new ArrayList<>();   // ob2错题列表
    List<WrongAnswerVo> sqWrongAnswerList = new ArrayList<>();    // sq错题列表


    public ScoreVo(Long paperid) {
        this.paperid = paperid;
        this.score = 0;
        this.scoringRate = 0;
        this.rightNum = 0;
        this.wrongNum = 0;
    }

    public void add(boolean isRight, Object question, String wrongAns) {

        if (isRight) {
            this.rightNum++;
        } else {
            this.wrongNum++;

            WrongAnswerVo wrongAnswerVo = new WrongAnswerVo();
            if (question instanceof ObjectiveQuestion1) {
                ob1WrongAnswerList.add(((ObjectiveQuestion1) question).generateWAVo(wrongAns));
            } else if (question instanceof ObjectiveQuestion2) {
                ob2WrongAnswerList.add(((ObjectiveQuestion2) question).generateWAVo(wrongAns));
            } else if (question instanceof SubjectiveQuestion) {
                sqWrongAnswerList.add(((SubjectiveQuestion) question).generateWAVo(wrongAns));
            }
        }
    }


    public void stats() {
        DecimalFormat df = new DecimalFormat("#.00");
        this.scoringRate = Double.parseDouble(df.format((double) rightNum / (rightNum + wrongNum)));
        this.score = Double.parseDouble(df.format(100.0 * (double) rightNum / (rightNum + wrongNum)));
    }

}
