package com.example.backend.PO;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@EnableConfigurationProperties
@TableName(value = "user")
@Component
public class User2 {

    private Integer id;
    private Long userid;
    private String username;
    private String password;
    private String sex;
    private String phone;
    private String specialty;       //专业
    private String faculties;       //院 系
    @TableField("class")
    private String UClass;
    private int type;

}
