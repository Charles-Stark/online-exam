package com.Service.Impl;

import com.Dao.SQMapper;
import com.Service.SQService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.domain.subjective_question;
import org.springframework.stereotype.Service;

@Service
public class SQImpl extends ServiceImpl<SQMapper,subjective_question> implements SQService {
}
