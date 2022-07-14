package com.example.backend.Service;

import com.example.backend.mapper.User1mapper;
import com.example.backend.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class USR {
    public User loginCheck(String userName,String password,int type) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        User1mapper user1mapper = sqlSession.getMapper(User1mapper.class);
        User user= user1mapper.selectByuserNameAndPassword(userName,password,type);
        return user;
    }
    public User registerCheck(Long userId)throws IOException{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        User1mapper user1mapper = sqlSession.getMapper(User1mapper.class);
        User user= user1mapper.selectByUserId(userId);
        return user;
    }
    public void insertNewUser(User user) throws IOException{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        User1mapper user1mapper = sqlSession.getMapper(User1mapper.class);
        user1mapper.insertUser(null,user.getUserid(),user.getUsername(),user.getPassword(),user.getSex(),user.getPhone(),user.getSpecialty(),user.getFaculties(),user.getUClass(),user.getType());
    }
}
