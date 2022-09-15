package com.example.backend.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.PO.User2;
import com.example.backend.Service.UserService;
import com.example.backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl extends ServiceImpl<UserMapper, User2> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean saveUser(User2 user2) {
        return userMapper.insert(user2) > 0 ;
    }

    @Override
    public boolean modify(User2 user2) {
        return userMapper.updateById(user2) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return userMapper.deleteById(id) > 0;
    }

    @Override
    public boolean save(User2 user2) {
        return userMapper.insert(user2) > 0;
    }

    @Override
    public boolean getById() {
        return false;
    }

    @Override
    public User2 getById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User2> getAll() {
        return userMapper.selectList(null);
    }

}
