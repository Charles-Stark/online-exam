<template>
    <div>
        <headMenu/>

        <div id="main">
            <div id="restTime">考试剩余时间 {{limitedTime}} 分钟</div>
            <!-- 单选题 -->
            <div v-if="objectiveQuestion1List.length>0">
                <h2>选择题：</h2>
                <div v-for="(obj1,index) in objectiveQuestion1List" :key="obj1.questionid">
                    <p>{{index+1}}.&nbsp;{{obj1.questioninfo}}</p>
                    <el-radio v-model="answers1[index]" label="A">{{obj1.choice_a}}</el-radio>
                    <el-radio v-model="answers1[index]" label="B">{{obj1.choice_b}}</el-radio>
                    <el-radio v-model="answers1[index]" label="C">{{obj1.choice_c}}</el-radio>
                    <el-radio v-model="answers1[index]" label="D">{{obj1.choice_d}}</el-radio>
                </div>
            </div>
            

            <!-- 判断题 -->
            <div v-if="objectiveQuestion2List.length>0">
                <h2>判断题：</h2>
                <div v-for="(obj2,index) in objectiveQuestion2List" :key="obj2.questionid">
                    <p>{{index+1}}.&nbsp;{{obj2.questioninfo}}</p>
                    <el-radio v-model="answers2[index]" label="对">{{obj2.choice1}}</el-radio>
                    <el-radio v-model="answers2[index]" label="错">{{obj2.choice2}}</el-radio>
                </div>
            </div>
            

            <!-- 填空题 -->
            <div v-if="subjectiveQuestionList.length>0">
                <h2>填空题：</h2>
                <div v-for="(sub,index) in subjectiveQuestionList" :key="sub.questionid">
                    <p>{{index+1}}.&nbsp;{{sub.questioninfo}}</p>
                    <el-input v-model="answers3[index]" placeholder="请输入答案"></el-input>
                </div>
            </div>
            
            <button @click="onSubmit" id="submitButton">确认交卷</button>
        </div>
        

    </div>
</template>

<script>
import headMenu from "../header/headMenu";

export default {
    components: { headMenu },
    data() {
        return ({
            limitedTime:"",
            objectiveQuestion1List:[],
            objectiveQuestion2List:[],
            subjectiveQuestionList:[],
            answers1:[],
            answers2:[],
            answers3:[],
            
            score:"",
            paperId:"",
            rightNum:"",
            wrongNum:"",
            ob1WrongAnswerList:[],
            ob2WrongAnswerList:[],
            sqWrongAnswerList:[],

        });
    },
    methods: {
        countDown() {
            if (!this.timer) {
                this.timer = setInterval(() => {
                    if (this.limitedTime > 0) {
                        //限制倒计时区间
                        this.limitedTime--;
                    } else {
                        clearInterval(this.timer); //删除定时器
                        this.timer = null;
                        this.onSubmit();
                        this.$router.push('/scorePage')
                        //跳转的页面写在此处
                    }
                }, 60000);
            }
        },
        onSubmit() {
            if(this.answers1.length+this.answers2.length+this.answers3.length===this.objectiveQuestion1List.length+this.objectiveQuestion2List.length+this.subjectiveQuestionList.length){
                this.$axios({
                    method: "post",
                    url: "/api/v1/judge",
                    data: {
                        paperId:this.paperId,
                        answers1:JSON.stringify(this.answers1),
                        answers2:JSON.stringify(this.answers2),
                        answer3:JSON.stringify(this.answers3),
                    },
                })
                .then((res) => {
                    console.log(res);
                    this.score=res.data.data.score;
                    this.rightNum=res.data.data.rightNum;
                    this.wrongNum=res.data.data.wrongNum;
                    this.ob1WrongAnswerList=res.data.data.ob1WrongAnswerList;
                    this.ob2WrongAnswerList=res.data.data.ob2WrongAnswerList;
                    this.sqWrongAnswerList=res.data.data.sqWrongAnswerList;
                    alert("提交成功！");
                    this.$router.push('/scorePage')
                })
                .catch((err) => {
                    console.log(err);
                    alert("提交失败！");
                });
            }
            else{
                alert("还有题目未完成")
            }
        },
    },
    mounted(){
        this.$bus.$on("getInfo1",(paperId,limitedTime)=>{
            if(paperId!=""){
                this.paperId=paperId;
                this.limitedTime =limitedTime;
                console.log(limitedTime+"  "+paperId)
                this.$axios({
                    method: "GET",
                    url: `/api/v1/paper/question/${paperId}`,
                })
                .then((res) => {
                    console.log(res);
                    this.objectiveQuestion1List=res.data.data.objectiveQuestion1List;
                    this.objectiveQuestion2List=res.data.data.objectiveQuestion2List;
                    this.subjectiveQuestionList=res.data.data.subjectiveQuestionList;
                })
                .catch((err) => {
                    console.log(err);   
                });
            }
        });
        this.$bus.$on("getInfo2",(paperId,limitedTime)=>{
            if(paperId!=""){
                this.paperId=paperId;
                this.limitedTime =limitedTime;
                console.log(limitedTime+"  "+paperId)
                this.$axios({
                    method: "GET",
                    url: `/api/v1/paper/question/${paperId}`,
                })
                .then((res) => {
                    console.log(res);
                    this.objectiveQuestion1List=res.data.data.objectiveQuestion1List;
                    this.objectiveQuestion2List=res.data.data.objectiveQuestion2List;
                    this.subjectiveQuestionList=res.data.data.subjectiveQuestionList;
                })
                .catch((err) => {
                    console.log(err);   
                });
            }
        });
        
            this.countDown();
            document.title='考试'
    },

    beforeDestroy() {
        this.$bus.$off("getInfo");
        this.$nextTick(function (){
            this.$bus.$emit('scoreInfo',this.score,this.rightNum,this.wrongNum,this.ob1WrongAnswerList,this.ob2WrongAnswerList,this.sqWrongAnswerList);
        });
    },

};
</script>

<style scoped>
body {
    background-color: black;
    width: 800px;
    height: 500px;
    border-style: solid;
}
h6 {
    display: inline-block;
}
.btns {
    height: 100px;
    margin-top: 20px;
    margin-left: 40px;
}
.div1 {
    text-align: center;
}
.div2 {
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}
#main{
    width: 700px;
    margin:20px auto;
    font-size: 20px;
    padding: 20px;
}
#restTime{
    position: fixed;
    margin-top: 420px;
    margin-left: -170px;
    border-style: solid;
    width: 85px;
    height: 50px;
    font-size: 17px;
    color: rgb(7, 89, 190);
    padding: 10px;
    border-color: rgba(37, 159, 252, 0.716);
}
#submitButton:hover{
        background-color: #1b66ca;
    }
#submitButton{
    background-color: #2079f0;
    transition: 0.4s;
    transition-timing-function:ease-out;
    border: none;
    border-radius: 8px;
    width: 700px;
    height: 70px;
    color: #fff;
    font-size: 15px;
    margin: 50px auto;
}
</style>