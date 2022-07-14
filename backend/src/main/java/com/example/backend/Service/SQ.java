package com.example.backend.Service;

import com.example.backend.mapper.SQ1mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;
import com.example.backend.domain.Subjective_question;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@MapperScan(value = "com.dao")
public class SQ {

    public List<Subjective_question> showAllQuestion(String courseName) throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        SQ1mapper SQ1mapper = sqlSession.getMapper(SQ1mapper.class);
        List<Subjective_question> list= SQ1mapper.selectQuestionByCourseName(courseName);
        return list;
    }
    public List<Subjective_question> showSelectedQuestion(List<Long> questionId) throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        SQ1mapper SQ1mapper = sqlSession.getMapper(SQ1mapper.class);

        List<Subjective_question> list =new ArrayList<>();
        questionId.forEach((id)->{
            Subjective_question subjective_question = SQ1mapper.selectQuestionbyQuestionid(id);
            list.add(subjective_question);
        });
        return list;
    }
    public String showSelectedQuestion(String questionId) throws IOException {
        long id=Long.valueOf(questionId);

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        SQ1mapper SQ1mapper = sqlSession.getMapper(SQ1mapper.class);

        Subjective_question obq= SQ1mapper.selectQuestionbyQuestionid(id);
        return obq.toQuestion();
    }
}
