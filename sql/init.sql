/*
 用户数据表User
 说明：type表示用户类型，1=学生，2=老师，3=管理员。学生可以不添加学科和学院（specialty和faculties）老师可以不添加任教班级（class）管理员可以三者都不添加
 */
CREATE TABLE `testsystem`.`user`
(
    `id`        INT         NOT NULL AUTO_INCREMENT,
    `userid`    BIGINT(20)  NOT NULL,
    `username`  VARCHAR(20) NOT NULL,
    `password`  VARCHAR(20) NOT NULL,
    `sex`       VARCHAR(2)  NOT NULL,
    `phone`     VARCHAR(20) NULL,
    `specialty` VARCHAR(15) NULL,
    `faculties` VARCHAR(15) NULL,
    `class`     VARCHAR(15) NULL,
    `type`      INT         NOT NULL,
    PRIMARY KEY (`id`, `userid`)
);


/*
科目信息表Course
*/
CREATE TABLE `testsystem`.`course`
(
    `id`         INT         NOT NULL AUTO_INCREMENT,
    `courseid`   BIGINT(20)  NOT NULL,
    `coursename` VARCHAR(20) NOT NULL,
    `specialty`  VARCHAR(20) NOT NULL,
    PRIMARY KEY (`id`, `courseid`)
);


/*
试卷题型表paper
testlevel=试卷难度, questionteacher=出卷老师, testcourse=考试科目, question=题目, 记录题目id, questiontype=题目类型,
Questionanswer=题目答案（不确定要不要，可以为空）

题目记录规则为
数据库存储规则（思路，可改）：
题目id：各题id之间用“逗号”分隔，不同题目类型用分号分隔，如：
选择题A，选择题B；判断题A，判断题B；主观题A，主观题B；
题目类型：各题目类型之间用“逗号”分隔
 */
CREATE TABLE `testsystem`.`paper`
(
    `id`              INT         NOT NULL AUTO_INCREMENT,
    `paperid`         BIGINT(20)  NOT NULL,
    `testlevel`       VARCHAR(10) NOT NULL,
    `testcourse`      VARCHAR(20) NOT NULL,
    `questionteacher` VARCHAR(20) NOT NULL,
    `question`        VARCHAR(45) NOT NULL,
    `questiontype`    VARCHAR(45) NOT NULL,
    `questionanswer`  VARCHAR(45),
    PRIMARY KEY (`id`, `testid`)
);


/*
主观题表subjective_question
（填空，解答）
*/
CREATE TABLE `testsystem`.`subjective_question`
(
    `id`             INT          NOT NULL AUTO_INCREMENT,
    `questionid`     BIGINT       NOT NULL,
    `questionname`   VARCHAR(45)  NOT NULL,
    `questioninfo`   VARCHAR(100) NOT NULL,
    `questionanswer` VARCHAR(150) NOT NULL,
    PRIMARY KEY (`id`, `questionid`)
);


/*
客观题表选择题objective_question1
*/
CREATE TABLE `testsystem`.`objective_question1`
(
    `id`             INT         NOT NULL AUTO_INCREMENT,
    `questionid`     BIGINT      NOT NULL,
    `questionname`   VARCHAR(45) NOT NULL,
    `questioninfo`   VARCHAR(90) NOT NULL,
    `questionanswer` VARCHAR(45) NOT NULL,
    `choice_a`       VARCHAR(90) NULL,
    `choice_b`       VARCHAR(90) NULL,
    `choice_c`       VARCHAR(90) NULL,
    `choice_d`       VARCHAR(90) NULL,
    PRIMARY KEY (`id`, `questionid`)
);


/*
客观题表判断题objective_question2
*/
CREATE TABLE `testsystem`.`objective_question2`
(
    `id`             INT         NOT NULL AUTO_INCREMENT,
    `questionid`     BIGINT      NOT NULL,
    `questionname`   VARCHAR(45) NOT NULL,
    `questioninfo`   VARCHAR(90) NOT NULL,
    `questionanswer` VARCHAR(20) NOT NULL,
    `choice1`        VARCHAR(20) NOT NULL,
    `choice2`        VARCHAR(20) NOT NULL,
    PRIMARY KEY (`id`, `questionid`)
);


/*
试卷信息表test
（course表示考试科目，madedate表示考试开始时间，limitedtime表示考试时限teacherid表示监考老师，mader表示设置考试的人）（有些内容已修改）
*/
CREATE TABLE `testsystem`.`test`
(
    `id`          INT         NOT NULL AUTO_INCREMENT,
    `paperid`     BIGINT      NOT NULL,
    `course`      VARCHAR(45) NOT NULL,
    `madedate`    DATETIME    NOT NULL,
    `limitedtime` INT         NOT NULL,
    `teacherid`   BIGINT      NOT NULL,
    `testid`      BIGINT      NOT NULL,
    `mader`       BIGINT      NOT NULL,
    PRIMARY KEY (`id`, `paperid`)
);
