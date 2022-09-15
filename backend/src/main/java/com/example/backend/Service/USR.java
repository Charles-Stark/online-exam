package com.example.backend.Service;

import com.example.backend.PO.User;
import com.example.backend.mapper.User1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class USR {

    @Autowired
    User1Mapper user1Mapper;

    public User loginCheck(Long userId,String password,int type) {
        Map map = new HashMap<>();
        map.put("userid", userId);
        map.put("password", password);
        map.put("type", type);

        List<User> userList = user1Mapper.selectByMap(map);
        if (!userList.isEmpty()) {
            System.out.println("In USR: " + userList.get(0).toString());
            return userList.get(0);
        } else {
            return null;
        }
    }


    public User registerCheck(Long userId) {
        return user1Mapper.selectById(userId);
    }


    public void insertNewUser(User user) {
        user1Mapper.insert(user);
    }
}
