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
    `testid`          BIGINT(20)  NOT NULL,
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



INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1002', '数学', '2+2=', 'D', '1', '2', '3', '4');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1003', '数学', '1+2=', 'C', '1', '2', '3', '4');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1004', '数学', '13-2=', 'A', '11', '8', '9', '7');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1005', '数学', '65-53', 'D', '54', '45', '21', '12');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1006', '数学', '5+9', 'B', '15', '14', '10', '11');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1007', '数学', '5*8', 'D', '15', '20', '30', '40');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1008', '数学', '9+4-5', 'A', '8', '4', '18', '11');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1009', '数学', '9+2', 'B', '9', '11', '7', '10');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1010', '数学', '5+8', 'C', '10', '20', '13', '17');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1011', '语文', '“大珠小珠落玉盘”所形容的是什么乐器的弹奏声？', 'A', '琵琶 ', '古筝', '扬琴', '钝角');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1012', '语文', '《孔雀东南飞》里，刘兰芝\"十三能织素，十四学裁衣，十五弹箜篌，十六诵诗书”，请问，“箜篌”是什么乐器：',
        'A', '拨弦乐器', '击弦乐器', '钝角', '钝角');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1013', '语文', '\"有板有眼\"的\"板\"是我国传统音乐节奏中的', 'A', '强拍 ', '弱拍 ', '钝角', '钝角');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1014', '语文', '下列文学常识和名著内容的表述，有误的一项是(　　 )', 'C',
        '《木兰诗》选自宋代郭茂倩编的《乐府诗集》，是南北朝时北方的一首乐府民歌。',
        '《卖油翁》作者是欧阳修，号醉翁，北宋文学家，“唐宋八大家”之一。',
        '《资治通鉴》是北宋司马光编撰的一部纪传体通史，《孙权劝学》就选自其中。',
        '岑参，唐代边塞诗人，长于七言歌行，代表作是《白雪歌送武判官归京》，与高适并称“高岑”。');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1015', '语文', '下列词语中没有错别字的一项是(　　 )', 'C', '嘹亮　　　 云霄　　　 博览会　　　 翻来复去　　　 各得其所',
        '禁锢　　　 帐蓬　　　 芙蓉鸟　　　 大相径庭　　　 浑为一谈', '气概　　　 分歧　　　 主旋律　　　 神采奕奕　　　 不知所措',
        '怂恿　　　 余晖　　　 彩棱镜　　　 随声附合　　　 杞人忧天');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1016', '语文', '下列词语中没有错别字的一项是(　　 )', 'A', '气概　　　 分歧　　　 主旋律　　　 神采奕奕　　　 不知所措',
        '嘹亮　　　 云霄　　　 博览会　　　 翻来复去　　　 各得其所', '禁锢　　　 帐蓬　　　 芙蓉鸟　　　 大相径庭　　　 浑为一谈',
        '怂恿　　　 余晖　　　 彩棱镜　　　 随声附合　　　 杞人忧天');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1017', '语文', '下列词语中没有错别字的一项是（　　）', 'C', '嘹亮　　 决别　　 不亦乐乎', '分歧　　 徘徊　　 翻来复去',
        '倜傥　　 云霄　　 择善而从', '烂漫　　 娇媚　　 浑为一谈');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1018', '语文', '下列句子没有语病的一项是（　　 ）', 'C',
        '孟非是近年来深受观众喜爱的电视节目主持人，他常常妙语连珠，拥有广泛的支持者，有很高的收视率。',
        '为了提高同学们的语文素养，我校团委积极开展“读经典作品， 建书香校园”。',
        '土地是我的母亲，我的每一寸皮肤，都有着土粒；我的手掌，一接近土地，心就变得平静。',
        '在激烈的市场竞争中，我们所缺乏的，一是勇气不足，二是谋略不当。');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1019', '语文', '下列句子没有语病的一项是（　　 ）', 'C',
        '《中国诗词大会》节目致力于弘扬中国传统文化，自开播以来深受观众喜爱的原因是因为其内容新颖和形式多样。',
        '我们只要与自然和谐相处，才能保护好我们赖以生存的家园。',
        '青年人应当把自己的梦想与民族的梦想紧密相连，刻苦学习，在追逐梦想的过程中为中国梦的实现而贡献力量。',
        '在旅游旺季到来之际，我市推广并通过了“美丽乡村游”的休闲旅游政策。');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1020', '语文', '下列句子没有语病的一项是（　　 ）', 'C',
        '《中华文明之美》开播以来，深受观众喜爱的原因是其新颖的内容和多样的形式造成的。',
        '2017年12月13日上午，中共中央在南京举行隆重南京大屠杀死难者国家公祭仪式。',
        '“中国特色社会主义进入了新的时代”是习近平同志在党的十九大报告中的新论断。',
        '再过四年，盐城人出脚就可乘上“复兴号”列车，大约1小时左右就能到达大上海。');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1021', '物理',
        '甲、乙两辆汽车在平直公路上运动，甲车内一同学看见乙车没有运动，而乙车内一同学看见路旁的木向西移动。如果以地面为参考系，那么（　　 ）',
        'D', '甲车不动，乙车向东运动', '乙车不动，甲车向东运动', '甲车向西运动，乙车向东运动',
        '甲、乙两车以相同的速度一起向东运动');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1022', '物理', '汽车刹车后做匀减速直线运动，经3s后停止运动，那么，在这连续的3个1s内汽车通过的位移之比为(      )',
        'B', '1：3：5  ', '5：3：1    ', '1：2：3', '3：2：1');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1023', '物理',
        '汽车刹车后做匀减速直线运动，经3s后停止运动，那么，汽车在这连续的三个1s初的速度之比和这连续的三个1s内汽车通过的位移之比分别为（ ）',
        'A', ' v1:v2:v3＝3:2:1', 'v1:v2:v3＝::', 'x1:x2:x3＝3:2:1', 'x1:x2:x3＝5:3:1');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1024', '物理',
        '在匀变速直线运动的位移公式和速度公式中除时间t外，共有四个矢量，若取初速度方向为正，那么（        ）', 'C',
        '匀加速直线运动中a为正值', '匀加速直线运动中a为负值', '匀减速直线运动中a为负值',
        '匀加速和匀减速直线运动中a均为正值');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1025', '物理', '物体做匀变速直线运动时，其加速度可用公式计算，关于公式中的物理量，下列说法正确的是　 （　　 ）', 'B',
        'a是矢量', 'v是矢量', 't是矢量', 'a的方向由v的方向决定');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1026', '物理', '下列关于物理学史和物理研究方法的叙述中正确的是　　', 'C',
        '根据速度定义式，当非常非常小时，就可以表示物体在t时刻的瞬时速度，该定义运用了极值的思想方法',
        '在推导匀变速直线运动位移公式时，把整个运动过程划分成很多小段，每一小段近似看作匀速直线运动，然后把各小段的位移相加，这里采用的是微元法',
        '伽利略借助实验研究和逻辑推理得出了自由落体运动规律',
        '在不需要考虑物体本身的大小和形状时，用质点来代替物体的方法叫假设法');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1027', '物理',
        '质量为0.3kg的物体在水平面上做直线运动，水平方向物体只受摩擦力作用时和水平方向受到摩擦力、水平力F两个力共同作用时的速度一时间图像，则下列说法中正确',
        'C', '水平力F可能等于0.3N', '物体的摩擦力一定等于0.1N', '水平力F一定等于0.1N', '物体的摩擦力可能等于0.3N');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1028', '物理', '某质点做直线运动的位移随时间变化的关系是，与的单位分别为和，则质点的初速度与加速度分别为（　　 ）',
        'C', '4m/s与2m/s2', '.0与4m/s2', '4m/s与4m/s2', '4m/s与0');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1029', '物理', '一物体从H高处自由下落，经时间t落地，则当它下落t/2时，离地的高度为（　　 ）', 'C', 'H/2', 'H/4',
        '3H/4', '3H/2');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1030', '物理',
        '在物理学的发展历程中，下面的哪位科学家首先首先采用了实验检验猜想和假设的科学方法，把实验和逻辑推理和谐地结合起来 (    )',
        'B', '亚里士多德', '伽利略', '牛顿  ', '爱因斯坦');
INSERT INTO `testsystem`.`objective_question1` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice_a`, `choice_b`, `choice_c`, `choice_d`)
VALUES ('1001', '数学', '1+1=', 'B', '1', '2', '3', '4');



ALTER TABLE `testsystem`.`objective_question2`
    CHANGE COLUMN `questioninfo` `questioninfo` VARCHAR(90) NOT NULL,
    CHANGE COLUMN `questionanswer` `questionanswer` VARCHAR(20) NOT NULL,
    CHANGE COLUMN `choice1` `choice1` VARCHAR(20) NOT NULL,
    CHANGE COLUMN `choice2` `choice2` VARCHAR(20) NOT NULL;
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1001', '语文', '模糊(mó)　似乎(sì)　转身(zhuǎn)　分量(fèng)这些多音字的读音没有一个错的。', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1002', '语文', '“辉”用部首查字法查“光”部，“光辉”的“辉”与“辉煌”的“辉”意思一样。', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1003', '语文', '焕然一新、守株待兔、卧薪尝胆、胸有成竹”这一组词感情色彩相同，都是褒义词。', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1004', '语文', '“春天的杭州是一年四季中最美的季节。”与“两个新旧社会，真是鲜明的对比啊!”都犯了语序颠倒的错误。',
        '对', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1005', '语文',
        '“海燕出版社出版的《世界文学名著漫画本》解决了少年朋友在阅读世界文学名著中所遇到的难题。”这句话若缩句，应该是“出版社解决了难题”。',
        '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1006', '语文',
        '蔺相如对手下的人说：“秦王我都不怕，我会怕廉将军吗?”改成间接转述应该是，蔺相如对手下的人说：“秦王他都不怕，他更不会怕廉将军。”',
        '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1007', '语文', '孙慎是我国著名的革命音乐家，镇海人。', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1008', '语文', '李伟用自己的脚挡住了对方踢来的球。缩句：脚挡住了球。', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1009', '语文', '“古往今来，人们虽然提到庐山，总是把它和云雾连在一起。”这句话', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1010', '语文', '在“电视机、洗衣机、发电机、录音机”中，不属于同一类的词语是', '对', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1011', '数学', 'a9÷a3=a3；', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1012', '数学', '（-b）4÷（-b）2=-b2；', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1013', '数学', 's11÷s11=0', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1014', '数学', '（-m）6÷（-m）3=-m3', '对', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1015', '数学', 'x8÷x4÷x2=x2', '对', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1016', '数学', 'n8÷（n4×n2）=n2', '对', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1017', '数学', '在平面内，过直线外一点有且只有一条直线与已知直线垂直  （    ）', '对', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1018', '数学', '过直线上一点不存在直线与已知直线垂直.                  （    ）', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1019', '数学', '过直线外一点A作的垂线，垂线的长度叫做点A到直线的距离.（    ）', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1020', '数学', '一条线段有无数条垂线.                                   （    ）', '对', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1021', '判断题', '物体温度升高，它的内能一定增加', '对', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1022', '判断题', '物体内能增加，它的温度一定升高', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1023', '判断题', '物体温度变化，它一定吸收或放出热量', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1024', '判断题', '物体吸收或放出热量，它的温度一定变化', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1025', '判断题', '当同种物体的质量相等时，吸收相同的热量，它的比热容与升高的温度成正比', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1026', '判断题', '物体的内能越大，它的温度一定越高。', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1027', '判断题', '物体吸收的热量越多，它温度一定变化越大。', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1028', '判断题', '水在0℃时一定结冰（）', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1029', '判断题', '用质量相等的0℃的冰和0℃的水冷却物体的效果是相同的（）', '错', '对', '错');
INSERT INTO `testsystem`.`objective_question2` (`questionid`, `questionname`, `questioninfo`, `questionanswer`,
                                                `choice1`, `choice2`)
VALUES ('1030', '判断题', '液体不放热有时也可以凝固（）', '错', '对', '错');



ALTER TABLE `testsystem`.`subjective_question`
    CHANGE COLUMN `questioninfo` `questioninfo` VARCHAR(100) NOT NULL,
    CHANGE COLUMN `questionanswer` `questionanswer` VARCHAR(150) NOT NULL;
DELETE
FROM `testsystem`.`subjective_question`
WHERE (`id` = '1')
  and (`questionid` = '1');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1001', '语文', 'huò (  )达乐观', '豁');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1002', '语文', 'bì（     ）益', '裨');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1003', '语文', '驰chěng（     ）', '骋');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1004', '语文', 'xī（     ）来攘往', '熙');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1005', '语文', '沈括是北宋时期著名的科学家、政治家，著有________。', '《梦溪笔谈》');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1006', '语文',
        '《皇帝的新装》作者是丹麦作家________，他一生创作了160余篇童话，代表作有《海的女儿》、《卖火柴的小女孩》等。', '安徒生');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1007', '语文',
        '《繁星》一文的作者是　　　　　　　 ，他是我国现代著名作家，著有长篇小说《家》《春》《秋》（合称“激流三部曲”）等著名作品。',
        '巴金');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1008', '语文', '《水调歌头》，作者　　　　　　 ， 宋 代文学家，唐宋八大家之一。', '苏轼');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1009', '语文', '《社戏》一文的体裁是　　　　　　　　 。', '小说');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1010', '语文', '《汤姆·索亚历险记》的作者　　　　　 ', '马克·吐温');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1011', '数学', '甲、乙两人各走一段路，他们的速度比是3:4，路程比是7:3，那么他们所需的时间比是（ ）', '28:9');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1012', '数学', '用四舍五入法将0.5395精确到千分位是（ ）。', '0.540');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1013', '数学', '一个长方体棱长和为120厘米，且长宽高的比为2：2：1，那么这个长方体最多有（ ）个面大小相等。', '4');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1014', '数学', '三数之和是l20，甲数是乙数的2倍，丙数比乙数多20，丙数是（ ', '45');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1015', '数学', 'a的倒数大于b的倒数，那么a（ ）b。（填>,<或=）', '<');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1016', '数学',
        '一辆快车和一辆慢车同时分别从甲、乙两地相对开出，经l2小时后相遇，快车又行驶了8小时到达乙地，那么相遇后慢车还要行驶（ ）小时才能到达甲地。',
        '18');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1017', '数学', '一个长方形长宽之比是4：3，面积是432平方厘米，它的周长是（ ）厘米。', '84');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1018', '数学', '修一段长80米的公路，修了的是剩下的3/5，修了（ ）米。', '30');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1019', '数学',
        '紧靠一道围墙边，用18米长的竹篱笆围出一块长方形（边长为整数）的菜地，这块菜地的面积最大是（ ）平方米。 (本题分数：2分)',
        '40');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1020', '数学', '甲数的2/3与乙数的和是60，甲数的4/9正好等于乙数。甲、乙两数的和是（ ）。 (本题分数：2分)', '78');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1021', '物理',
        '高山滑雪是冬奥会的重要竞赛项目之一，如图所示是滑雪运动员从山顶加速下滑训练的情境。在下滑过程中运动员的动能_____（均选填“减小”、“增大”或“不变”）。',
        '增大');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1022', '物理',
        '若将A、B串联接入某电源两端，则闭合开关后，它们两端的电压U1、U2之比是_____：若将A、B并联接入电源两端，闭合开关后，测得干路电流为0.6A，则电源电压是2V。',
        '1:2');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1023', '物理', '如图所示，水壶的壶嘴和壶身构成一个简单的________。', '连通器');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1024', '物理',
        '爆炒肉片时，厨师们往往预先将肉片拌入适量的淀粉，在放入锅中炒，这样肉片里的水分难以______（填写物态变化名称），能保持肉片的鲜嫩味美，厨房内的肉香味能传的很远',
        '蒸发');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1025', '物理',
        '如图所示，在“探究光的反射规律”实验中，小明将硬纸板竖直地立在平面镜上，盘硬纸板上的直线ON垂直于镜面，右侧纸板可绕ON向后转动，如图甲所示，若增大入射角，则反射角________',
        '增大');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1026', '物理', '港珠澳大桥海底隧道长6.7km，小明乘车通过海底隧道，在进、出隧道口时花了5分钟均速度为_____km/h',
        '80.4');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1027', '物理',
        '电源电压为3V．闭合开关后，小灯泡L1、L2都不亮．小鹭同学用电压表检测后，得出L1断路的结论．其测量结果应该是：Uab=____V，Ubc=0V，Uac=3V．',
        '3');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1028', '物理', '如图所示为一种新型的“风光互补”景观照明灯，白天工作时，太阳能电池板将______.（填能的转化）',
        '太阳能转化为电能');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1029', '物理', '某电热暖手宝的主要参数。选用水作为吸热或放热物质，是因为水的_____较大。', '比热容');
INSERT INTO `testsystem`.`subjective_question` (`questionid`, `questionname`, `questioninfo`, `questionanswer`)
VALUES ('1030', '物理', '高速气流通过吸管上方时，流速越大的地方压强越小，______会把液体压入气压小的地方从而被气流吹放。',
        '大气压');



INSERT INTO `testsystem`.`course` (`courseid`, `coursename`, `specialty`)
VALUES ('10101', '语文', '语文');
INSERT INTO `testsystem`.`course` (`courseid`, `coursename`, `specialty`)
VALUES ('10102', '数学', '数学');
INSERT INTO `testsystem`.`course` (`courseid`, `coursename`, `specialty`)
VALUES ('10103', '物理', '物理');



INSERT INTO `testsystem`.`user` (`userid`, `username`, `password`, `sex`, `phone`, `class`, `type`)
VALUES ('2022071201', '小明', '123456789', '男', '1234567890', '201', '1');
INSERT INTO `testsystem`.`user` (`userid`, `username`, `password`, `sex`, `phone`, `class`, `type`)
VALUES ('2022071202', '小红', '123456789', '女', '1234567890', '201', '1');
INSERT INTO `testsystem`.`user` (`userid`, `username`, `password`, `sex`, `phone`, `class`, `type`)
VALUES ('2022071203', '小强', '123456789', '男', '1234567890', '201', '1');
INSERT INTO `testsystem`.`user` (`userid`, `username`, `password`, `sex`, `phone`, `specialty`, `faculties`, `class`,
                                 `type`)
VALUES ('2022071204', '王老师', '123456789', '男', '1234567890', '语文', '语文学院', '201', '2');
INSERT INTO `testsystem`.`user` (`userid`, `username`, `password`, `sex`, `phone`, `specialty`, `faculties`, `class`,
                                 `type`)
VALUES ('2022071205', '张老师', '123456789', '女', '1234567890', '数学', '数学学院', '202', '2');
INSERT INTO `testsystem`.`user` (`userid`, `username`, `password`, `sex`, `phone`, `specialty`, `faculties`, `class`,
                                 `type`)
VALUES ('2022071206', '高老师', '123456789', '男', '1234567890', '物理', '物理学院', '203', '2');
INSERT INTO `testsystem`.`user` (`userid`, `username`, `password`, `sex`, `phone`, `type`)
VALUES ('101', 'admin', '123456', '男', '1234567890', '3');
INSERT INTO `testsystem`.`user` (`userid`, `username`, `password`, `sex`, `phone`, `class`, `type`)
VALUES ('2022071207', '小李', '123456789', '男', '1234567890', '202', '1');
INSERT INTO `testsystem`.`user` (`userid`, `username`, `password`, `sex`, `phone`, `class`, `type`)
VALUES ('2022071208', '小丽', '123456789', '女', '1234567890', '202', '1');
INSERT INTO `testsystem`.`user` (`userid`, `username`, `password`, `sex`, `phone`, `class`, `type`)
VALUES ('2022071209', '小王', '123456789', '男', '1234567890', '202', '1');


# Test表增加mader字段和testid字段
ALTER TABLE `testsystem`.`test`
    ADD COLUMN `mader` BIGINT NOT NULL AFTER `teacherid`;
ALTER TABLE `testsystem`.`test`
    ADD COLUMN `testid` BIGINT NOT NULL AFTER `teacherid`;

# Paper表修改testid为paperid
ALTER TABLE `testsystem`.`paper`
    CHANGE COLUMN `testid` `paperid` BIGINT NOT NULL;

# Paper表修改question字段和questiontype字段为TEXT类型
ALTER TABLE `paper` MODIFY question TEXT;
ALTER TABLE `paper` MODIFY questiontype TEXT;
