package com.example.backend.controller;

import com.example.backend.Service.USR;
import com.example.backend.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @CrossOrigin
    @PostMapping("/login")
    @ResponseBody
    public void login(@RequestParam Map<String,Object> map, HttpServletResponse response) throws Exception {
        response.setStatus(200);
        response.getWriter().write("server error");
        String userName="",password="",type="";
        userName=(String) map.get("username");
        password=(String) map.get("password");
        type=(String) map.get("type");
        System.out.println("接受数据成功");
        System.out.println(userName);
        System.out.println(password);
        System.out.println(type);

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("student",1);
        map1.put("teacher",2);
        map1.put("admin",3);
        USR usr=new USR();
        User user=usr.loginCheck(userName,password,map1.get(type));
        if(user==null) {
            response.setStatus(204);
            return;
        }
        else  {
            //User user1=new User(user);
            return;
        }
    }
    @PostMapping("/register")
    @ResponseBody
    public void register(@RequestParam Map<String,Object> map,HttpServletResponse response) throws IOException {

        String userid=(String) map.get("id");
        String userName=(String) map.get("username");
        String password=(String) map.get("password");
        String specialty=(String) map.get("specialty");
        String sex=(String) map.get("sex");
        String phone=(String) map.get("phone");
        String faculties=(String) map.get("faculties");
        String uclass=(String) map.get("class");
        String type=(String) map.get("type");

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("student",1);
        map1.put("teacher",2);
        map1.put("admin",3);
        Map<String,String> map2=new HashMap<>();
        map2.put("male","男");
        map2.put("female","女");
        Long userId=Long.valueOf(userid);
        USR usr=new USR();
        User user1=usr.registerCheck(userId);
        if(user1==null){
            User user=new User(null,userId,userName,password,map2.get(sex),phone,specialty,faculties,uclass,map1.get(type));
            usr.insertNewUser(user);
            response.setStatus(200);
            return;
        }
        else {
            response.setStatus(204);
            return;
        }
    }
}
