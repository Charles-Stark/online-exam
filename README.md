# online-exam
# 说明
## 数据库
数据库相关的请存入sql文件夹，新建一个.sql格式的文件。

其中all.sql文件经整理可成功运行。
## 后端backend
后端Spring Boot项目为backend文件夹。

大家的代码测试通过后尽量写到这里来，以免最后各写各的好多个项目统一不起来。

开发时需要依赖等自行修改pom.xml文件。mybatis的配置文件为resources文件夹中的mybatis-config.xml.

Controller文件夹中的内容用于接收前端发送的请求（GET/POST），接收请求后可调用Service文件夹中的服务层以获取需要的数据并返回。

PO文件夹中存放与数据库中数据表对应的Java类（如User、Test等）。Util文件夹用于存放自己编写的工具类。

数据库操作采用mybatis。resources文件夹中的mapper文件夹用于存放mybatis的映射文件（xml），src中的mapper文件夹用于存放mybatis的Java接口。

前后端分离开发，前端向后端发送get或post请求，后端controller接收并且处理后统一返回Json格式的数据。

返回数据格式如下：

```json
{
  "code": 0,
  "msg": "获取题目详情成功",
  "data": {
    
  }
}
```
若获取数据成功，则code为0；失败则为-1。前端接收到数据之后先进行判断。

msg为简单的描述。

data部分：若code为-1，则为null；若code为1，则为相应的数据。