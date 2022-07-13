package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backend.PO.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapperPlus extends BaseMapper<User> {

}
