# 已完成的API接口

# Paper类

## GET 获取试卷详情

GET /api/v1/paper/detail/{paperid}

根据paperid获取试卷详情

### 请求参数

| 名称     |位置|类型|必选| 说明                |
|--------|---|---|---|-------------------|
| paperid |path|integer| 是 | 想获取详情的试卷的paperid   |

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "获取试卷详情成功",
  "data": {
    "id": 21,
    "paperid": 1002,
    "testlevel": "中等",
    "testcourse": "语文",
    "questionteacher": "2022071206",
    "question": "1016,1017;1009,1010;1003,1004;",
    "questiontype": "objective_question1,objective_question2,subjective_question",
    "questionanswer": null
  }
}
```

> 异常

```json
{
  "code": -1,
  "msg": "获取试卷详情失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

paper数据表对应的Paper类

## GET 获取试卷列表

GET /api/v1/paper/all

获取试卷详情，若get方法无参数，则返回所有试卷；若get方法有参数（筛选条件），则返回符合条件的试卷列表

### 请求参数

| 名称          |位置| 类型      | 必选  | 说明                |
|-------------|---|---------|-----|-------------------|
| id          |path| integer | 否   |    |
| paperid     |path| integer | 否   |    |
| testlevel      |path| string  | 否   |    |
| testcourse    |path| string  | 否   |    |
| questionteacher |path| string | 否   |    |
| question   |path| string | 否   |    |
| questiontype      |path| string | 否   |    |
| questionanswer       |path| string | 否   |    |

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "获取试卷成功",
  "data": [
    {
      "id": 20,
      "paperid": 1001,
      "testlevel": "中等",
      "testcourse": "语文",
      "questionteacher": "2022071206",
      "question": "1011,1012;1002,1003;1002,1003;",
      "questiontype": "objective_question1,objective_question2,subjective_question",
      "questionanswer": null
    },
    {
      "id": 21,
      "paperid": 1002,
      "testlevel": "中等",
      "testcourse": "语文",
      "questionteacher": "2022071206",
      "question": "1016,1017;1009,1010;1003,1004;",
      "questiontype": "objective_question1,objective_question2,subjective_question",
      "questionanswer": null
    },
    {
      "id": 43,
      "paperid": 1005,
      "testlevel": "简单",
      "testcourse": "数学",
      "questionteacher": "2022071206",
      "question": "1007,1008;1012,1013;1018,1019,1020;",
      "questiontype": "objective_question1,objective_question2,subjective_question",
      "questionanswer": null
    }
  ]
}
```

> 异常

```json
{
  "code": -1,
  "msg": "获取试卷失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

由paper数据表对应的Paper类实例组成的列表

## GET 删除试卷

GET /api/v1/paper/delete/{paperid}

根据paperid删除试卷

### 请求参数

| 名称          |位置| 类型      | 必选  | 说明                |
|-------------|---|---------|-----|-------------------|
| paperid      |path| integer | 是  |    |

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "删除试卷成功",
  "data": null
}
```

> 异常

```json
{
  "code": -1,
  "msg": "删除试卷失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

null

## POST 修改试卷

POST /api/v1/paper/update

根据paperid修改试卷

> Body 请求参数

```yaml
id: Integer
paperid: Integer
testlevel: String
testcourse: String
questionteacher: String
question: String
questiontype: String
questionanswer: String

```

### 请求参数

| 名称            |位置|类型| 必选 |说明|
|---------------|---|---|----|---|
| body          |body|object| 否  |none|
| » id          |body|integer| 是  |none|
| » paperid     |body|integer| 否  |none|
| » testlevel      |body|string| 否  |none|
| » testcourse    |body|string| 否  |none|
| » questionteacher |body|string| 否  |none|
| » question   |body|string| 否  |none|
| » questiontype      |body|string| 否  |none|
| » questionanswer       |body|string| 否  |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "修改试卷成功",
  "data": null
}
```

> 异常
```json
{
  "code": -1,
  "msg": "修改试卷失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构
null



## GET 获取试卷中的问题

GET /api/v1/paper/question/{paperid}

根据paperid获取试卷中的问题

### 请求参数

| 名称          |位置| 类型      | 必选  | 说明                |
|-------------|---|---------|-----|-------------------|
| paperid      |path| integer | 是  |    |

> 返回示例

> 成功

```json
{
  "code": 0,
  "msg": "获取问题列表成功",
  "data": {
    "objectiveQuestion1List": [
      {
        "id": 15,
        "questionid": 1016,
        "questionname": "语文",
        "questioninfo": "下列词语中没有错别字的一项是(　　 )",
        "questionanswer": "A",
        "choice_a": "气概　　　 分歧　　　 主旋律　　　 神采奕奕　　　 不知所措",
        "choice_b": "嘹亮　　　 云霄　　　 博览会　　　 翻来复去　　　 各得其所",
        "choice_c": "禁锢　　　 帐蓬　　　 芙蓉鸟　　　 大相径庭　　　 浑为一谈",
        "choice_d": "怂恿　　　 余晖　　　 彩棱镜　　　 随声附合　　　 杞人忧天"
      },
      {
        "id": 16,
        "questionid": 1017,
        "questionname": "语文",
        "questioninfo": "下列词语中没有错别字的一项是（　　）",
        "questionanswer": "C",
        "choice_a": "嘹亮　　 决别　　 不亦乐乎",
        "choice_b": "分歧　　 徘徊　　 翻来复去",
        "choice_c": "倜傥　　 云霄　　 择善而从",
        "choice_d": "烂漫　　 娇媚　　 浑为一谈"
      }
    ],
    "objectiveQuestion2List": [
      {
        "id": 3,
        "questionid": 1003,
        "questionname": "语文",
        "questioninfo": "焕然一新、守株待兔、卧薪尝胆、胸有成竹”这一组词感情色彩相同，都是褒义词。",
        "questionanswer": "错",
        "choice1": "对",
        "choice2": "错"
      },
      {
        "id": 4,
        "questionid": 1004,
        "questionname": "语文",
        "questioninfo": "“春天的杭州是一年四季中最美的季节。”与“两个新旧社会，真是鲜明的对比啊!”都犯了语序颠倒的错误。",
        "questionanswer": "对",
        "choice1": "对",
        "choice2": "错"
      }
    ],
    "subjectiveQuestionList": [
      {
        "id": 9,
        "questionid": "1009",
        "questionname": "语文",
        "questioninfo": "《社戏》一文的体裁是　　　　　　　　 。",
        "questionanswer": "小说"
      },
      {
        "id": 10,
        "questionid": "1010",
        "questionname": "语文",
        "questioninfo": "《汤姆·索亚历险记》的作者　　　　　 ",
        "questionanswer": "马克·吐温"
      }
    ]
  }
}
```

> 异常

```json
{
  "code": -1,
  "msg": "获取问题列表失败",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

各类问题列表