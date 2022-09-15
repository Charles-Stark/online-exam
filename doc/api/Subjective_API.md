# 已完成的API接口

# SubjectiveQuestion类

## GET 获取主观题详情

GET /api/v1/sq/detail/{questionid}

根据questionid获取题目详情

### 请求参数

| 名称     |位置|类型|必选| 说明                |
|--------|---|---|---|-------------------|
| questionid |path|string| 是 | 想获取详情的题目的questionid   |

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "获取主观题详情成功",
  "data": {
    "id": 1,
    "questionid": "1001",
    "questionname": "语文",
    "questioninfo": "huò (  )达乐观",
    "questionanswer": "豁"
  }
}
```

> 异常

```json
{
  "code": -1,
  "msg": "获取主观题详情失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

subjective_question数据表对应的SubjectiveQuestion类

## GET 获取主观题列表

GET /api/v1/sq/all

按学科名称获取主观题列表

### 请求参数

| 名称          |位置| 类型      | 必选  | 说明                |
|-------------|---|---------|-----|-------------------|
| coursename     |path| string | 是   |    |


> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "获取主观题成功",
  "data": [
    {
      "id": 11,
      "questionid": "1011",
      "questionname": "数学",
      "questioninfo": "甲、乙两人各走一段路，他们的速度比是3:4，路程比是7:3，那么他们所需的时间比是（ ）",
      "questionanswer": "28:9"
    },
    {
      "id": 12,
      "questionid": "1012",
      "questionname": "数学",
      "questioninfo": "用四舍五入法将0.5395精确到千分位是（ ）。",
      "questionanswer": "0.540"
    },
    {
      "id": 13,
      "questionid": "1013",
      "questionname": "数学",
      "questioninfo": "一个长方体棱长和为120厘米，且长宽高的比为2：2：1，那么这个长方体最多有（ ）个面大小相等。",
      "questionanswer": "4"
    }
  ]
}
```

> 异常

```json
{
  "code": -1,
  "msg": "获取主观题失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

SubjectiveQuestion类实例组成的列表

## GET 删除题目

GET /api/v1/sq/delete/{questionid}

根据questionid删除题目

### 请求参数

| 名称          |位置| 类型      | 必选  | 说明                |
|-------------|---|---------|-----|-------------------|
| questionid      |path| string | 是  |    |

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

POST /api/v1/sq/update

根据questionid修改题目

> Body 请求参数

```yaml
id: int
questionid: string
questionname: string
questioninfo: int
questionanswer: int
```

### 请求参数

| 名称            |位置|类型| 必选 |说明|
|---------------|---|---|----|---|
| body          |body|object| 否  |none|
| » id          |body|integer| 否  |none|
| » questionid      |body|string| 是  |none|
| » questionname    |body|string| 否  |none|
| » questioninfo |body|integer| 否  |none|
| » questionanswer   |body|integer| 否  |none|

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

POST /api/v1/sq/create

创建考试

> Body 请求参数

```yaml
id: int
questionid: string
questionname: string
questioninfo: int
questionanswer: int

```

### 请求参数

| 名称            |位置|类型| 必选 |说明|
|---------------|---|---|----|---|
| body          |body|object| 否  |none|
| » id          |body|integer| 是  |none|
| » questionid      |body|string| 是  |none|
| » questionname    |body|string| 是  |none|
| » questioninfo |body|integer| 是  |none|
| » questionanswer   |body|integer| 是  |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "创建题目成功",
  "data": {
    "id": 1,
    "questionid": "1001",
    "questionname": "语文",
    "questioninfo": "huò (  )达乐观",
    "questionanswer": "豁"
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
SubjectiveQuestion类