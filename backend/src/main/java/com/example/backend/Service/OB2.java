package com.example.backend.Service;

import com.example.backend.domain.Objective_question2;
import com.example.backend.mapper.OB22mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@MapperScan(value = "com.dao")
public class OB2 {

    public List<Objective_question2> showAllQuestion(String courseName) throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        OB22mapper ob22Mapper =sqlSession.getMapper(OB22mapper.class);
        List<Objective_question2> list= ob22Mapper.selectQuestionByCourseName(courseName);
        return list;
    }
    public List<Objective_question2> showSelectedQuestion(List<Long> questionId) throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        OB22mapper ob22Mapper = sqlSession.getMapper(OB22mapper.class);

        List<Objective_question2> list =new ArrayList<>();
        questionId.forEach((id)->{
            Objective_question2 objective_question2 = ob22Mapper.selectQuestionbyQuestionid(id);
            list.add(objective_question2);
        });
        return list;
    }
    public String showSelectedQuestion(String questionId) throws IOException {
        long id=Long.valueOf(questionId);

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        OB22mapper ob22Mapper = sqlSession.getMapper(OB22mapper.class);

        Objective_question2 obq= ob22Mapper.selectQuestionbyQuestionid(id);
        return obq.toQuestion();
    }
}
