package com.Service.Impl;

import com.Dao.OB1Mapper;
import com.Dao.PaperMapper;
import com.Service.OB1Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.domain.objective_question1;
import com.domain.paper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@MapperScan(value = "com.Dao")
public class OB1Impl extends ServiceImpl<OB1Mapper, objective_question1> implements OB1Service {
    //@Autowired题目数据层接口
    @Autowired
    private OB1Mapper ob1Mapper;


    @Override
    //2：查询题目数据库共有多少条数据
    public int selectdata_number(){
        List<objective_question1> number = ob1Mapper.selectList(null);
        int num_long = number.toArray().length;
        return num_long;
    }

    @Override
    //3：定义一个随机数列
    public int Getrandom() {
        Random random = new Random();
        int random_num = 0;
            for (int a = 0; a < 10; a++) {
                random_num = random.nextInt(selectdata_number());
        }
            return random_num;
    }

    @Autowired
    PaperMapper paperMapper;
    //5:把提取出来的题目添加到新数据库表中
    @Override
    public paper paper_question() {
        return paperMapper.insert(GetQuestion())
    }

    @Override
    //4：把符合要求的题目提取出来
    public objective_question1 GetQuestion(){
        return ob1Mapper.selectById(Getrandom());
    }





}
