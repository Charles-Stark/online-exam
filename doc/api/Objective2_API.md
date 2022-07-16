# 已完成的API接口

# ObjectiveQuestion2类

## GET 获取判断题详情

GET /api/v1/ob2/detail/{questionid}

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
  "msg": "获取判断题详情成功",
  "data": {
    "id": 2,
    "questionid": 1002,
    "questionname": "语文",
    "questioninfo": "“辉”用部首查字法查“光”部，“光辉”的“辉”与“辉煌”的“辉”意思一样。",
    "questionanswer": "错",
    "choice1": "对",
    "choice2": "错"
  }
}
```

> 异常

```json
{
  "code": -1,
  "msg": "获取判断题详情失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

objective_question2数据表对应的ObjectiveQuestion2类

## GET 获取判断题列表

GET /api/v1/ob2/all

按学科名称获取判断题列表

### 请求参数

| 名称          |位置| 类型      | 必选  | 说明                |
|-------------|---|---------|-----|-------------------|
| coursename     |path| integer | 是   |    |


> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "获取判断题成功",
  "data": [
    {
      "id": 11,
      "questionid": 1011,
      "questionname": "数学",
      "questioninfo": "a9÷a3=a3；",
      "questionanswer": "错",
      "choice1": "对",
      "choice2": "错"
    },
    {
      "id": 12,
      "questionid": 1012,
      "questionname": "数学",
      "questioninfo": "（-b）4÷（-b）2=-b2；",
      "questionanswer": "错",
      "choice1": "对",
      "choice2": "错"
    },
    {
      "id": 13,
      "questionid": 1013,
      "questionname": "数学",
      "questioninfo": "s11÷s11=0",
      "questionanswer": "错",
      "choice1": "对",
      "choice2": "错"
    }
  ]
}
```

> 异常

```json
{
  "code": -1,
  "msg": "获取判断题失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

ObjectiveQuestion2类实例组成的列表

## GET 删除题目

GET /api/v1/ob2/delete/{questionid}

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

POST /api/v1/ob2/update

根据questionid修改题目

> Body 请求参数

```yaml
id: int
questionid: Long
questionname: String
questioninfo: String
questionanswer: String
choice1: String
choice2: String
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
| » choice1   |body|string| 否  |none|
| » choice2   |body|string| 否  |none|

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

POST /api/v1/ob2/create

创建考试

> Body 请求参数

```yaml
id: int
questionid: Long
questionname: String
questioninfo: String
questionanswer: String
choice1: String
choice2: String
```

### 请求参数

| 名称            |位置|类型| 必选 |说明|
|---------------|---|---|----|---|
| body          |body|object| 是  |none|
| » id          |body|integer| 是  |none|
| » questionid      |body|integer| 是  |none|
| » questionname    |body|string| 是  |none|
| » questioninfo |body|string| 是  |none|
| » questionanswer   |body|string| 是 |none|
| » choice1   |body|string| 是  |none|
| » choice2   |body|string| 是  |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "创建题目成功",
  "data": {
    "id": 2,
    "questionid": 1002,
    "questionname": "语文",
    "questioninfo": "“辉”用部首查字法查“光”部，“光辉”的“辉”与“辉煌”的“辉”意思一样。",
    "questionanswer": "错",
    "choice1": "对",
    "choice2": "错"
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
ObjectiveQuestion2类