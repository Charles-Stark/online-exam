package com.example.backend.Service;

import com.example.backend.PO.ObjectiveQuestion1;
import com.example.backend.PO.ObjectiveQuestion2;
import com.example.backend.PO.Paper;
import com.example.backend.PO.SubjectiveQuestion;
import com.example.backend.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PS {

    @Autowired
    PaperMapper paperMapper;

    @Autowired
    OB1 ob1;
    @Autowired
    OB2 ob2;
    @Autowired
    SQ sq;
    @Autowired
    PaperReader paperReader;

    @Autowired
    private Paper paper;
    private String paperQuestion;
    private StringBuilder stringBuilder1 = new StringBuilder(), stringBuilder2 = new StringBuilder();
    @Autowired
    private List<ObjectiveQuestion1> ob1List = new ArrayList<>();
    @Autowired
    private List<ObjectiveQuestion2> ob2List = new ArrayList<>();
    @Autowired
    private List<SubjectiveQuestion> sbList = new ArrayList<>();
    private String questionType;


    public void clearListAndStringBuilder() {
        ob1List.clear();
        ob2List.clear();
        sbList.clear();
        stringBuilder1.delete(0, stringBuilder1.length());
        stringBuilder2.delete(0, stringBuilder2.length());
    }

    /*
     * 显示所以符合要求的题目
     * */
    public List<ObjectiveQuestion1> showObjectiveQuestion1(String courseName) {
        return ob1.showAllQuestion(courseName);
    }

    public List<ObjectiveQuestion2> showObjectiveQuestion2(String courseName) {
        return ob2.showAllQuestion(courseName);
    }

    public List<SubjectiveQuestion> showSubjectiveQuestion(String courseName) {
        return sq.showAllQuestion(courseName);
    }


    /*
     * 显示已选择的题目
     * */
    public List<ObjectiveQuestion1> showSelectedObjectiveQuestion1(List<Long> questionId) {
        ob1List = ob1.showSelectedQuestion(questionId);
        return ob1List;
    }

    public List<ObjectiveQuestion2> showSelectedObjectiveQuestion2(List<Long> questionId) {
        ob2List = ob2.showSelectedQuestion(questionId);
        return ob2List;
    }

    public List<SubjectiveQuestion> showSelectedSubjectiveQuestion(List<Long> questionId) {
        sbList = sq.showSelectedQuestion(questionId);
        return sbList;
    }


    /*
     * 生成试卷
     * */
    public Paper toPaper(Long paperId, String testlevel, String testcourse, Long questionteacher) {

        for (int i = 0; i < ob1List.toArray().length; i++) {
//            stringBuilder1.append(ob1List.get(i));
            stringBuilder1.append(ob1List.get(i).getQuestionid());
            if (i != ob1List.toArray().length - 1) stringBuilder1.append(",");
            else {
                stringBuilder1.append(";");
                stringBuilder2.append("objective_question1");
            }
        }

        for (int i = 0; i < ob2List.toArray().length; i++) {
//            stringBuilder1.append(ob2List.get(i));
            stringBuilder1.append(ob2List.get(i).getQuestionid());
            if (i != ob2List.toArray().length - 1) stringBuilder1.append(",");
            else {
                stringBuilder1.append(";");
                stringBuilder2.append(",objective_question2");
            }
        }

        for (int i = 0; i < sbList.toArray().length; i++) {
//            stringBuilder1.append(sbList.get(i));
            stringBuilder1.append(sbList.get(i).getQuestionid());
            if (i != sbList.toArray().length - 1) stringBuilder1.append(",");
            else {
                stringBuilder1.append(";");
                stringBuilder2.append(",subjective_question");
            }
        }


        paperQuestion = stringBuilder1.toString();
        questionType = stringBuilder2.toString();
        //paper.getPaper(paperid,testlevel,testcourse,questionteacher,paperQuestion,questionType);
        paper = new Paper(0, paperId, testlevel, testcourse, questionteacher.toString(), paperQuestion, questionType, null);
        return paper;
    }


    /*
     * 存储试卷
     * */
    public boolean savePaper(Paper paper) {
        Paper paper1 = findPaper(paper.getPaperid());
        if (paper1 == null) {
            paperMapper.insert(paper);
            return true;
        } else {
            return false;
        }
    }


    /*
     * 用list<String>集合返回试卷的试题信息如
     * 选择题                                                                                               list[0]
     * 1+1=<br/>A.1<br/>B.2<br/>C.3<br/>D.4<br/>                                                           list[1]
     * 2+2=<br/>A.1<br/>B.2<br/>C.3<br/>D.4<br/>                                                           list[2]
     * 判断题                                                                                               list[3]
     * 焕然一新、守株待兔、卧薪尝胆、胸有成竹”这一组词感情色彩相同，都是褒义词。<br/>A.对<br/>B.错<br/>                    list[4]
     * “春天的杭州是一年四季中最美的季节。”与“两个新旧社会，真是鲜明的对比啊!”都犯了语序颠倒的错误。<br/>A.对<br/>B.错<br/>    list[5]
     * */
    public List<String> showPaper(Long paperid) {

        Paper paper1 = paperMapper.selectById(paperid);
        return paperReader.read(paper1);
    }

    public List<String> showPaper(Integer paperid) {

        Paper paper1 = paperMapper.selectById((long) paperid);
        return paperReader.read(paper1);
    }


    public Paper findPaper(Long paperid) {
        return paperMapper.selectById(paperid);
    }

    public Paper findPaper(Integer paperid) {
        return paperMapper.selectById((long) paperid);
    }
}
