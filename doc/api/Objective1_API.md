# 已完成的API接口

# ObjectiveQuestion1类

## GET 获取选择题详情

GET /api/v1/ob1/detail/{questionid}

根据questionid获取题目详情

### 请求参数

| 名称     |位置|类型|必选| 说明                |
|--------|---|---|---|-------------------|
| questionid |path|integer| 是 | 想获取详情的题目的questionid   |

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "获取选择题详情成功",
  "data": {
    "id": 30,
    "questionid": 1001,
    "questionname": "数学",
    "questioninfo": "1+1=",
    "questionanswer": "B",
    "choice_a": "1",
    "choice_b": "2",
    "choice_c": "3",
    "choice_d": "4"
  }
}
```

> 异常

```json
{
  "code": -1,
  "msg": "获取选择题详情失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

objective_question1数据表对应的ObjectiveQuestion1类

## GET 获取选择题列表

GET /api/v1/ob1/all

按学科名称获取选择题列表

### 请求参数

| 名称          |位置| 类型      | 必选  | 说明                |
|-------------|---|---------|-----|-------------------|
| coursename     |path| integer | 是   |    |


> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "获取选择题成功",
  "data": [
    {
      "id": 1,
      "questionid": 1002,
      "questionname": "数学",
      "questioninfo": "2+2=",
      "questionanswer": "D",
      "choice_a": "1",
      "choice_b": "2",
      "choice_c": "3",
      "choice_d": "4"
    },
    {
      "id": 2,
      "questionid": 1003,
      "questionname": "数学",
      "questioninfo": "1+2=",
      "questionanswer": "C",
      "choice_a": "1",
      "choice_b": "2",
      "choice_c": "3",
      "choice_d": "4"
    },
    {
      "id": 3,
      "questionid": 1004,
      "questionname": "数学",
      "questioninfo": "13-2=",
      "questionanswer": "A",
      "choice_a": "11",
      "choice_b": "8",
      "choice_c": "9",
      "choice_d": "7"
    }
  ]
}
```

> 异常

```json
{
  "code": -1,
  "msg": "获取选择题失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

ObjectiveQuestion1类实例组成的列表

## GET 删除题目

GET /api/v1/ob1/delete/{questionid}

根据questionid删除题目

### 请求参数

| 名称          |位置| 类型      | 必选  | 说明                |
|-------------|---|---------|-----|-------------------|
| questionid      |path| integer | 是  |    |

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "删除题目成功",
  "data": null
}
```

> 异常

```json
{
  "code": -1,
  "msg": "删除题目失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

null

## POST 修改题目

POST /api/v1/ob1/update

根据questionid修改题目

> Body 请求参数

```yaml
id: int
questionid: Long
questionname: String
questioninfo: String
questionanswer: String
choice_a: String
choice_b: String
choice_c: String
choice_d: String
```

### 请求参数

| 名称            |位置|类型| 必选 |说明|
|---------------|---|---|----|---|
| body          |body|object| 否  |none|
| » id          |body|integer| 否  |none|
| » questionid      |body|integer| 是  |none|
| » questionname    |body|string| 否  |none|
| » questioninfo |body|string| 否  |none|
| » questionanswer   |body|string| 否  |none|
| » choice_a   |body|string| 否  |none|
| » choice_b   |body|string| 否  |none|
| » choice_c   |body|string| 否  |none|
| » choice_d   |body|string| 否  |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "修改题目成功",
  "data": null
}
```

> 异常
```json
{
  "code": -1,
  "msg": "修改题目失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构
null

## POST 创建题目

POST /api/v1/ob1/create

创建考试

> Body 请求参数

```yaml
id: int
questionid: Long
questionname: String
questioninfo: String
questionanswer: String
choice_a: String
choice_b: String
choice_c: String
choice_d: String
```

### 请求参数

| 名称            |位置|类型| 必选 |说明|
|---------------|---|---|----|---|
| body          |body|object| 是  |none|
| » id          |body|integer| 是  |none|
| » questionid      |body|integer| 是  |none|
| » questionname    |body|string| 是  |none|
| » questioninfo |body|string| 是  |none|
| » questionanswer   |body|string| 是  |none|
| » choice_a   |body|string| 是  |none|
| » choice_b   |body|string| 是  |none|
| » choice_c   |body|string| 是  |none|
| » choice_d   |body|string| 是  |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "创建题目成功",
  "data": {
    "id": 30,
    "questionid": 1001,
    "questionname": "数学",
    "questioninfo": "1+1=",
    "questionanswer": "B",
    "choice_a": "1",
    "choice_b": "2",
    "choice_c": "3",
    "choice_d": "4"
  }
}
```

> 异常
```json
{
  "code": -1,
  "msg": "创建题目失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构
ObjectiveQuestion1类