package com.Service.Impl;

import com.Dao.PaperMapper;
import com.Service.PaperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.domain.paper;
import org.springframework.stereotype.Service;

@Service
public class PaperImpl extends ServiceImpl<PaperMapper, paper> implements PaperService {
}
