package com.example.backend.mapper;


import com.example.backend.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface User1mapper {
    public User selectByuserNameAndPassword(String userName,String password,int type);
    public User selectByUserId(Long userId);
    public void insertUser(Integer id,Long userid,String username,String password,String sex,String phone,String specialty,String faculties,String uclass,int type);
}
