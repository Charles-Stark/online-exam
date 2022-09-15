package com.example.backend.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend.PO.User2;

import java.util.List;

public interface UserService extends IService<User2> {

    //添加
    boolean saveUser(User2 user2);
    //更改
    boolean modify(User2 user2);


    //删除
    boolean delete(Integer id);
    boolean save(User2 user2);

    boolean getById();

    User2 getById(Integer id);

    List<User2> getAll();

}
