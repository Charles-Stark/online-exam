package com.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.domain.objective_question1;
import com.domain.paper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaperMapper extends BaseMapper<paper> {
    paper update(objective_question1 getQuestion);

}
