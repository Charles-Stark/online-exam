package com.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.domain.objective_question1;
import com.domain.paper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OB1Service extends IService<objective_question1> {



    //查询题目数据库共有多少条数据
    public int selectdata_number();

    //生成随机数
    public int Getrandom();

    // 5:把提取出来的题目添加到新数据库表中
    public paper paper_question();

    //把符合要求的题目提取出来
    public  objective_question1 GetQuestion();};

    //5:把提取出来的题目添加到新数据库表中

