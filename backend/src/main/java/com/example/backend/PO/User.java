package com.example.backend.PO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@EnableConfigurationProperties
@AllArgsConstructor
@TableName(value = "user")
@Component
public class User {
    private Integer id;
    @TableId(value = "userid")
    private Long userid;
    private String username;
    private String password;
    private String sex;
    private String phone;
    private String specialty;       //专业
    private String faculties;       //院系
    @TableField("class")
    private String UClass;
    private int type;

    public User() {
    }
}
