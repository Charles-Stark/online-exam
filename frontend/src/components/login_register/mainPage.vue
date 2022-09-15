<template>
    <div class="background">
        
        <transition :name="transitionName">
            <router-view class="main"></router-view>
        </transition>

        <div class="type1" v-if="showPic1">   
            <h1>Online Exam</h1>
            <h3>在线考试系统</h3>
            <div class="imgBox">
                <!-- alt：图片路径失败时替换显示内容 -->
                <img class="img-slide img" src="../../assets/img1.png" alt="img1"  id="img1">
            </div>
        </div>

        <div class="type2" v-if="showPic2">   
            <h1>Online Exam</h1>
            <h3>在线考试系统</h3>
            <div class="imgBox">
                <!-- alt：图片路径失败时替换显示内容 -->
                <img class="img-slide img" src="../../assets/img2.png" alt="img2"  id="img2">
            </div>
        </div>


        
        
    </div>
</template>

<script>
import loginBoxVue from './loginBox.vue'
import registerBoxVue from './registerBox.vue'
export default {
    data(){
        return{
            transitionName:'',       
            showPic1:'',
            showPic2:''
        }
    },
    components:{loginBoxVue,registerBoxVue},
    watch: {
        //使用watch 监听$router的变化
        $route(to, from) {
        //如果to索引大于from索引,判断为前进状态,反之则为后退状态
            console.log(to, "to");
            console.log(from, "from");
            if (to.path=='/mainPage/login') {
                //设置动画名称
                this.transitionName = "slide-right";
                setTimeout(() => {
                    this.showPic1=true
                }, 500);
                this.showPic2=false
            } else {
                this.transitionName = "slide-left";
                setTimeout(() => {
                    this.showPic2=true
                }, 500);
                this.showPic1=false
            }
        },
    },
    mounted(){
        if(this.$route.path=='/mainPage/login') this.showPic1=true;
        else this.showPic2=true
        
        }
    

}
</script>

<style scoped>
    .background{
        margin: 1.5% 4%;
        height: 650px;
        border-style: solid;
        border-color: rgba(8, 8, 8, 0);
        box-shadow: 0px 0px 30px rgba(0,0,0,0.2);
        min-width:800px;
        border-radius: 8px;
        background-color: white;
    }
    .loginbox{
        float:right;
        margin-right: 60px;
        width: 440px;
        margin-top: 60px;
    }
    .registerbox{
        margin-left: 60px;
        margin-top: 60px;
        width: 700px;
    }

    .slide-left-enter, .slide-right-leave {  
        opacity: 0;  
        -webkit-transform: translate(30px, 0);  
        transform: translate(300px, 0);  
    }  
    .slide-left-leave, .slide-right-enter {  
        opacity: 0;  
        -webkit-transform: translate(-30px, 0);  
        transform: translate(-300px, 0);  
    }  

    .main{
        transition: all .5s cubic-bezier(.55,0,.1,1);  
    }

    .type1{
        width: 500px;
        float: left;
        margin-left: 140px;
        margin-top: 40px;
    }
    .type2{
        width: 600px;
        float:right;
        margin-right: 0px;
        margin-top: 70px;
    }
    .type1 h1,.type2 h1{
        text-align: center;
        color: black;
    }
    .type1 h3,.type2 h3{
        color: rgba(0, 0, 0, 0.423);
        text-align: center;
    }

    .type2 img{
        width: 600px;
    }
    
</style>