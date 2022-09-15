<template>
    <div>
        <div id="top">
            <headMenu/>
            <br>
            <h1>您的成绩为:</h1>
            <h1 id="score">{{score}}分</h1>

            <br>
            <h3>答对 {{rightNum}} 道题，答错 {{wrongNum}} 道题。</h3>
            <br>
            <button @click="back">返回首页</button>

        </div>
            <hr>
            <div id="body" v-if="score<100">
            <h2>错题详情：</h2>

            <div v-for="ob1 in ob1WrongAnswerList" :key="ob1.questionid" class="questionBlocks">
                <p>{{ob1.questioninfo}}</p>
                <span>正确答案是: {{ob1.rightAnswer}} <br> </span>
                <span>您的答案是: {{ob1.wrongAnswer}} <br> </span>
            </div>

            <div v-for="ob2 in ob2WrongAnswerList" :key="ob2.questionid" class="questionBlocks">
                <p>{{ob2.questioninfo}}</p>
                <span>正确答案是: {{ob2.rightAnswer}} <br> </span>
                <span>您的答案是: {{ob2.wrongAnswer}} <br> </span>
            </div>

            <div v-for="sq in sqWrongAnswerList" :key="sq.questionid" class="questionBlocks">
                <p>{{sq.questioninfo}}</p>
                <span>正确答案是: {{sq.rightAnswer}} <br> </span>
                <span>您的答案是: {{sq.wrongAnswer}} <br> </span>
            </div>

        </div>
    </div>
    
</template>

<script>
import headMenu from "../header/headMenu";
export default {
    components:{headMenu},
    data() {
        return {
            score:"",
            rightNum:"",
            wrongNum:"",
            ob1WrongAnswerList:[],
            ob2WrongAnswerList:[],
            sqWrongAnswerList:[],
        }
    },
    methods:{
        back(){
            this.$router.push('/manager')
        }
    },
    mounted(){
        this.$bus.$on("scoreInfo",(score,rightNum,wrongNum,ob1,ob2,sq)=>{
            this.score=score;
            this.rightNum=rightNum;
            this.wrongNum=wrongNum;
            this.ob1WrongAnswerList=ob1;
            this.ob2WrongAnswerList=ob2;
            this.sqWrongAnswerList=sq;
        });
        document.title='考试'
    },

    beforeDestroy(){
        this.$bus.$off("scoreInfo");
    }

}
</script>

<style scoped>
    #top{
        text-align: center;
    }
    #body{
        margin: 0px auto;
        padding: 10px 50px;
        width: 700px;
    }
    #score{
        font-size: 50px;
    }
    .questionBlocks{
        border-style: solid;
        border-color: rgb(153, 153, 153);
        border-radius: 10px;
        padding: 5px 20px 20px;
        margin-top: 15px;
    }
    #top button:hover{
        background-color: #1b66ca;
    }
    #top button{
        background-color: #2079f0;
        transition: 0.4s;
        transition-timing-function:ease-out;
        border: none;
        border-radius: 8px;
        width: 250px;
        height: 50px;
        color: #fff;
        font-size: 15px;
        margin: 10px auto;
    }
</style>