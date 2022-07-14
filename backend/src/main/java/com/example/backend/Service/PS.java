package com.example.backend.Service;

import com.example.backend.domain.ObjectiveQuestion1;
import com.example.backend.domain.ObjectiveQuestion2;
import com.example.backend.domain.Paper;
import com.example.backend.domain.SubjectiveQuestion;
import com.example.backend.mapper.Paper1mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@MapperScan(value = "com.dao")
public class PS {

    @Autowired
    private Paper paper;
    private String paperQuestion;
    private StringBuilder stringBuilder1,stringBuilder2;
    @Autowired
    private List<ObjectiveQuestion1> ob1List;
    @Autowired
    private List<ObjectiveQuestion2> ob2List;
    @Autowired
    private List<SubjectiveQuestion> sbList;
    private String questionType;
    /*
    * 显示所以符合要求的题目
    * */
    public List<ObjectiveQuestion1> showObjectiveQuestion1(String courseName) throws IOException {
        OB1 ob1 = new OB1();
        List<ObjectiveQuestion1> list = ob1.showAllQuestion(courseName);
        return list;

    }
    public List<ObjectiveQuestion2> showObjectiveQuestion2(String courseName) throws IOException {
        OB2 ob2 = new OB2();
        List<ObjectiveQuestion2> list = ob2.showAllQuestion(courseName);
        return list;
    }
    public List<SubjectiveQuestion> showSubjectiveQuestion(String courseName) throws IOException {
        SQ sq = new SQ();
        List<SubjectiveQuestion> list = sq.showAllQuestion(courseName);
        return list;
    }
    /*
    * 显示已选择的题目
    * */
    public List<ObjectiveQuestion1> showSelectedObjectiveQuestion1(List<Long> questionId) throws IOException {
        OB1 ob1=new OB1();
        List<ObjectiveQuestion1> list = ob1.showSelectedQuestion(questionId);
        ob1List=list;
        return list;
    }
    public List<ObjectiveQuestion2> showSelectedObjectiveQuestion2(List<Long> questionId) throws IOException {
        OB2 ob2=new OB2();
        List<ObjectiveQuestion2> list = ob2.showSelectedQuestion(questionId);
        ob2List=list;
        return list;
    }
    public List<SubjectiveQuestion> showSelectedSubjectiveQuestion(List<Long> questionId) throws IOException {
        SQ sq = new SQ();
        List<SubjectiveQuestion> list = sq.showSelectedQuestion(questionId);
        sbList=list;
        return list;
    }

    /*
    * 生成试卷
    * */
    public Paper toPaper(Long paperid, String testlevel, String testcourse, Long questionteacher){
        for(int i=0;i<ob1List.toArray().length;i++){
            stringBuilder1.append(ob1List.get(i));
            if(i!=ob1List.toArray().length-1) stringBuilder1.append(",");
            else {
                stringBuilder1.append(";");
                stringBuilder2.append("objective_question1");
            }
        }
        for(int i=0;i<ob2List.toArray().length;i++){
            stringBuilder1.append(ob2List.get(i));
            if(i!=ob2List.toArray().length-1) stringBuilder1.append(",");
            else {
                stringBuilder1.append(";");
                stringBuilder2.append(",objective_question2");
            }
        }
        for(int i=0;i<sbList.toArray().length;i++){
            stringBuilder1.append(sbList.get(i));
            if(i!=sbList.toArray().length-1) stringBuilder1.append(",");
            else {
                stringBuilder1.append(";");
                stringBuilder2.append(",subjective_question");
            }
        }
        paperQuestion= stringBuilder1.toString();
        questionType=stringBuilder2.toString();
        //paper.getPaper(paperid,testlevel,testcourse,questionteacher,paperQuestion,questionType);
        paper=new Paper(null,paperid,testlevel,testcourse,questionteacher,paperQuestion,questionType,null);
        return paper;
    }
    public Paper toPaper(Integer paperId, String testlevel, String testcourse, Long questionteacher){
        Long paperid =(long) paperId;
        for(int i=0;i<ob1List.toArray().length;i++){
            stringBuilder1.append(ob1List.get(i));
            if(i!=ob1List.toArray().length-1) stringBuilder1.append(",");
            else {
                stringBuilder1.append(";");
                stringBuilder2.append("objective_question1");
            }
        }
        for(int i=0;i<ob2List.toArray().length;i++){
            stringBuilder1.append(ob2List.get(i));
            if(i!=ob2List.toArray().length-1) stringBuilder1.append(",");
            else {
                stringBuilder1.append(";");
                stringBuilder2.append(",objective_question2");
            }
        }
        for(int i=0;i<sbList.toArray().length;i++){
            stringBuilder1.append(sbList.get(i));
            if(i!=sbList.toArray().length-1) stringBuilder1.append(",");
            else {
                stringBuilder1.append(";");
                stringBuilder2.append(",subjective_question");
            }
        }
        paperQuestion= stringBuilder1.toString();
        questionType=stringBuilder2.toString();
        //paper.getPaper(paperid,testlevel,testcourse,questionteacher,paperQuestion,questionType);
        paper=new Paper(null,paperid,testlevel,testcourse,questionteacher,paperQuestion,questionType,null);
        return paper;
    }
    /*
    * 存储试卷
    * */
    public boolean savePaper(Paper paper) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        Paper paper1=findPaper(paper.getPaperid());
        if(paper1==null) {
            Paper1mapper paper1mapper = sqlSession.getMapper(Paper1mapper.class);
            paper1mapper.insertPaper(null,paper.getPaperid(),paper.getTestlevel(),paper.getTestcourse(),paper.getQuestionteacher(),paper.getQuestion(),paper.getQuestiontype(),paper.getQuestionanswer());
            return true;
        }
        else return false;
        //Integer id,Long paperid,String testlevel,String testcourse,Long questionteacher,String question,String questiontype,String questionanswer
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
    public List<String> showPaper(Integer paperid) throws IOException {
        Long paperId=paperid.longValue();
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        Paper1mapper paper1mapper = sqlSession.getMapper(Paper1mapper.class);
        Paper paper1 = paper1mapper.selectPaperByPaperId(paperId);
        PaperReader paperReader=new PaperReader();
        return paperReader.read(paper1);
    }
    public List<String> showPaper(Long paperId) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        Paper1mapper paper1mapper = sqlSession.getMapper(Paper1mapper.class);
        Paper paper1 = paper1mapper.selectPaperByPaperId(paperId);
        PaperReader paperReader=new PaperReader();
        return paperReader.read(paper1);
    }
    public Paper findPaper(Integer paperid) throws IOException {
        Long paperId=(long) paperid;
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        Paper1mapper paper1mapper = sqlSession.getMapper(Paper1mapper.class);
        Paper paper = paper1mapper.selectPaperByPaperId(paperId);
        return paper;
    }
    public Paper findPaper(Long paperid) throws IOException {
        Long paperId=paperid;
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        Paper1mapper paper1mapper = sqlSession.getMapper(Paper1mapper.class);
        Paper paper = paper1mapper.selectPaperByPaperId(paperId);
        return paper;
    }
}
