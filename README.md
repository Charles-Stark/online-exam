# Simple Online Exam

## About

暑期社会实践项目

由Java Spring Boot + Vue开发的超简陋在线考试系统

## Introduction

数据库文件: sql/data.sql

API接口文档: doc/api/

数据库配置: 

1. backend/src/main/resources/mybatis-config.xml
```xml
<dataSource type="POOLED">
    <property name="driver" value="com.mysql.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf8"/>
    <property name="username" value="root"/>
    <property name="password" value="root"/>
</dataSource>
```
2. backend/src/main/resources/application.yml
```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/testsystem?serverTimezone=UTC&characterEncoding=UTF-8
    username: root
    password: root
```