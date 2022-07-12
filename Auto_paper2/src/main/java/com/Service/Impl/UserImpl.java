package com.Service.Impl;

import com.Dao.UserMapper;
import com.Service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.domain.user;
import org.springframework.stereotype.Service;

@Service
public class UserImpl extends ServiceImpl<UserMapper, user> implements UserService {
}
