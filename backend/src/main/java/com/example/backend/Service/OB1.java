package com.example.backend.Service;

import com.example.backend.mapper.OB11mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;
import com.example.backend.domain.Objective_question1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@MapperScan(value = "com.dao")
public class OB1{

    public List<Objective_question1> showAllQuestion(String courseName) throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        OB11mapper ob11Mapper = sqlSession.getMapper(OB11mapper.class);
        List<Objective_question1> list= ob11Mapper.selectQuestionByCourseName(courseName);
        return list;
    }
    public List<Objective_question1> showSelectedQuestion(List<Long> questionId) throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        OB11mapper ob11Mapper = sqlSession.getMapper(OB11mapper.class);

        List<Objective_question1> list =new ArrayList<>();
        questionId.forEach((id)->{
            Objective_question1 objective_question1 = ob11Mapper.selectQuestionbyQuestionid(id);
            list.add(objective_question1);
        });
        return list;
    }
    public String showSelectedQuestion(String questionId) throws IOException {
        long id=Long.valueOf(questionId);

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        OB11mapper ob11Mapper = sqlSession.getMapper(OB11mapper.class);

        Objective_question1 obq= ob11Mapper.selectQuestionbyQuestionid(id);
        return obq.toQuestion();
    }
}
