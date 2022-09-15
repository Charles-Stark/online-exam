# 已完成的API接口

# Test类

## GET 获取考试详情

GET /api/v1/exam/detail/{testid}

根据testid获取考试详情

### 请求参数

| 名称     |位置|类型|必选| 说明                |
|--------|---|---|---|-------------------|
| testid |path|integer| 是 | 想获取详情的考试的testid   |

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "获取考试详情成功",
  "data": {
    "id": 1,
    "paperid": 1,
    "course": "语文",
    "madedate": "2022-07-12 11:01:03",
    "limitedtime": 60,
    "teacherid": 12,
    "testid": 1,
    "mader": 12
  }
}
```

> 异常

```json
{
  "code": -1,
  "msg": "获取考试详情失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

test数据表对应的Test类

## GET 获取考试列表

GET /api/v1/exam/all

获取考试详情，若get方法无参数，则返回所有考试；若get方法有参数（筛选条件），则返回符合条件的考试列表

### 请求参数

| 名称          |位置| 类型      | 必选  | 说明                |
|-------------|---|---------|-----|-------------------|
| id          |path| integer | 否   |    |
| paperid     |path| integer | 否   |    |
| course      |path| string  | 否   |    |
| madedate    |path| string  | 否   |    |
| limitedtime |path| integer | 否   |    |
| teacherid   |path| integer | 否   |    |
| testid      |path| integer | 否   |    |
| mader       |path| integer | 否   |    |

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
      "course": "语文",
      "madedate": "2022-07-12 11:01:03",
      "limitedtime": 60,
      "teacherid": 12,
      "testid": 1,
      "mader": 12
    },
    {
      "id": 2,
      "paperid": 3,
      "course": "数学",
      "madedate": "2022-07-13 11:01:03",
      "limitedtime": 60,
      "teacherid": 13,
      "testid": 2,
      "mader": 13
    }
  ]
}
```

> 异常

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

由test数据表对应的Test类实例组成的列表

## GET 删除考试

GET /api/v1/exam/delete/{testid}

根据testid删除考试

### 请求参数

| 名称          |位置| 类型      | 必选  | 说明                |
|-------------|---|---------|-----|-------------------|
| testid      |path| integer | 是  |    |

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "删除考试成功",
  "data": null
}
```

> 异常

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

null

## POST 修改考试

POST /api/v1/exam/update

根据testid修改考试

> Body 请求参数

```yaml
id: int
paperid: int
course: string
madedate: string
limitedtime: int
teacherid: int
testid: int
mader: int

```

### 请求参数

| 名称            |位置|类型| 必选 |说明|
|---------------|---|---|----|---|
| body          |body|object| 否  |none|
| » id          |body|integer| 否  |none|
| » paperid     |body|integer| 否  |none|
| » course      |body|string| 否  |none|
| » madedate    |body|string| 否  |none|
| » limitedtime |body|integer| 否  |none|
| » teacherid   |body|integer| 否  |none|
| » testid      |body|integer| 是  |none|
| » mader       |body|integer| 否  |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "修改考试成功",
  "data": null
}
```

> 异常
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
null

## POST 创建考试

POST /api/v1/exam/create

创建考试

> Body 请求参数

```yaml
paperid: int
course: string
madedate: string
limitedtime: int
teacherid: int
testid: int
mader: int

```

### 请求参数

| 名称            |位置|类型| 必选 |说明|
|---------------|---|---|----|---|
| body          |body|object| 是  |none|
| » paperid     |body|integer| 是  |none|
| » course      |body|string| 是  |none|
| » madedate    |body|string| 是  |none|
| » limitedtime |body|integer| 是  |none|
| » teacherid   |body|integer| 是  |none|
| » testid      |body|integer| 是  |none|
| » mader       |body|integer| 是  |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "创建考试成功",
  "data": {
    "id": 1,
    "paperid": 1,
    "course": "数学",
    "madedate": "2022-07-12 11:01:03",
    "limitedtime": 60,
    "teacherid": 12,
    "testid": 1,
    "mader": 1
  }
}
```

> 异常
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
test数据表对应的Test类