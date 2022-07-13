# 教考分离

> v1.0.0

# 考试 v1/Test

## GET 组卷

GET /api/v1/exam/generate

组卷

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|objective_question1|query|array| 是 |选择题id数组，若无则为空数组|
|objective_question2|query|array| 是 |判断题id数组，若无则为空数组|
|subjective_question|query|array| 是 |主观题id数组，若无则为空数组|
|questionteacher|query|string| 是 |出卷老师|
|testcourse|query|string| 是 |试卷科目|

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "组卷成功",
  "data": {
    "id": 1,
    "paperid": 1,
    "testlevel": "",
    "testcourse": "语文",
    "questiontescher": "12",
    "question": "1001,1002,1020;2001,1004,2301,3032;1205,1206",
    "questiontype": "选择题,判断题,填空题",
    "questionanswer": ""
  }
}
```

```json
{
  "code": -1,
  "msg": "组卷失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取所有考试

GET /api/v1/exam/all

获取所有考试,若get方法无参数，则返回所有考试；若get方法有参数，则按参数返回符合的考试

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|integer| 否 |none|
|paperid|query|integer| 否 |none|
|course|query|string| 否 |none|
|madedate|query|string| 否 |none|
|limitedtime|query|integer| 否 |none|
|teacherid|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "获取考试成功",
  "data": [
    {
      "id": 1,
      "paperid": 1,
      "course": "面向对象程序设计",
      "madedate": "2022-07-12 11:01:03",
      "limitedtime": 60,
      "teacherid": 12
    },
    {
      "id": 2,
      "paperid": 2,
      "course": "计算机导论",
      "madedate": "2022-07-13 12:01:03",
      "limitedtime": 30,
      "teacherid": 10
    }
  ]
}
```

```json
{
  "code": -1,
  "msg": "获取考试失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 修改考试

POST /api/v1/exam/update

根据id修改考试

> Body 请求参数

```yaml
id: 0
paperid: 0
course: string
madedate: string
limitedtime: 0
teacherid: 0

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» id|body|integer| 是 |none|
|» paperid|body|integer| 否 |none|
|» course|body|string| 否 |none|
|» madedate|body|string| 否 |none|
|» limitedtime|body|integer| 否 |none|
|» teacherid|body|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "修改考试成功",
  "data": null
}
```

```json
{
  "code": -1,
  "msg": "修改考试失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取考试详情

GET /api/v1/exam/detail/{id}

获取考试详情

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|integer| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "获取考试详情成功",
  "data": {
    "id": 1,
    "paperid": 1,
    "course": "面向对象程序设计",
    "madedate": "2022-07-12 11:01:03",
    "limitedtime": 60,
    "teacherid": 12
  }
}
```

```json
{
  "code": 0,
  "msg": "获取考试详情失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 创建考试

POST /api/v1/exam/create

创建考试

> Body 请求参数

```yaml
paperid: 0
course: string
madedate: string
limitedtime: 0
teacherid: 0

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» paperid|body|integer| 是 |none|
|» course|body|string| 是 |none|
|» madedate|body|string| 是 |none|
|» limitedtime|body|integer| 是 |none|
|» teacherid|body|integer| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "创建考试成功",
  "data": {
    "id": 1,
    "paperid": 1,
    "course": "面向对象程序设计",
    "madedate": "2022-07-12 11:01:03",
    "limitedtime": 60,
    "teacherid": 12
  }
}
```

```json
{
  "code": -1,
  "msg": "创建考试失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 删除考试

GET /api/v1/exam/delete/{id}

删除考试

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|integer| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "删除考试成功",
  "data": null
}
```

```json
{
  "code": -1,
  "msg": "删除考试失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构


