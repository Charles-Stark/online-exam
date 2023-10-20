# Simple Online Exam

## About

暑期社会实践项目

由Java Spring Boot + Vue开发的~~超简陋~~在线考试系统

## Introduction

数据库文件: <a href="https://github.com/Charles-Stark/online-exam/blob/master/sql/data.sql">sql/data.sql</a>

API接口文档: <a href="https://github.com/Charles-Stark/online-exam/tree/master/doc/api">doc/api/</a>

数据库配置: 

1. <a href="https://github.com/Charles-Stark/online-exam/blob/master/backend/src/main/resources/mybatis-config.xml">backend/src/main/resources/mybatis-config.xml</a>
```xml
<dataSource type="POOLED">
    <property name="driver" value="com.mysql.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf8"/>
    <property name="username" value="root"/>  <!-- Your own username -->
    <property name="password" value="root"/>  <!-- Your own password -->
</dataSource>
```
2. <a href="https://github.com/Charles-Stark/online-exam/blob/master/backend/src/main/resources/application.yml">backend/src/main/resources/application.yml</a>
```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/testsystem?serverTimezone=UTC&characterEncoding=UTF-8
    username: root  # <--Your own username
    password: root  # <--Your own password
```
