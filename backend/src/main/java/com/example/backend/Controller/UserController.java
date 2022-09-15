package com.example.backend.Controller;

import com.example.backend.PO.User2;
import com.example.backend.Service.UserService;
import com.example.backend.Vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    //获取全部信息
    @CrossOrigin
    @GetMapping("/getAll")
    @ResponseBody
    public ResultVo<List<User2>> getAll(){
        List<User2> list=userService.getAll();
//        List<User1> list1= new ArrayList<>();
//        list.forEach(a->{
//            User1 user1=new User1(a.getId(),a.getUsername(),a.getUserid(),a.getUClass(),a.getSpecialty());
//            list1.add(user1);
//        });
//        return new ResultVo(1,"成功",list1);
        return new ResultVo(1,"成功",list);
    }


    //添加
    @PostMapping("/add")
    public ResultVo<Boolean> save(@RequestBody User2 user2){
        System.out.println("请求接收成功");
        user2.setPassword("123456789");
        user2.setSex("未知");
        return new ResultVo(1,"",userService.save(user2));
    }


    //更改
    @PutMapping("/update")
    public ResultVo<Boolean> update(@RequestBody User2 user2){
        //user2 user2 =new user2(null,(long)user1.getId(),user1.getName(),"123456789","未知","",user1.getProfession(),"",user1.getUserclass(),1);
        System.out.println("请求接收成功");
        return new ResultVo(1,"",userService.modify(user2));
    }


    //删除
    @DeleteMapping("{id}")
    public ResultVo<Boolean> delete(@PathVariable Integer id){
        System.out.println("请求接收成功");
        return new ResultVo(1,"成功",userService.delete(id));
    }


    @GetMapping("{id}")
    public ResultVo<Boolean> getById(@PathVariable Integer id){
        System.out.println("请求接收成功");
        return new ResultVo(1,"成功",userService.getById(id));
    }

}
