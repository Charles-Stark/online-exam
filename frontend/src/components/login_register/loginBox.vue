<template>
    <div class="wrapper">
        <span class="title"> <b>用户登录</b></span>
        <br><br><br><br><br>
        <form @submit.prevent="onSubmit">
            <div class="input-data">
                <input type="text" v-model="id" required>
                <div class="underline"></div>
                <label>学号</label>
            </div>
            <br><br>
            <div class="input-data">
                <input type="password" v-model="password" required>
                <div class="underline"></div>
                <label>密码</label>
            </div>
            <div class="choice">
                <label> 学生 <input type="radio" value="student" name="chooseid" v-model="type" required></label>
                <label> 教师 <input type="radio" value="teacher" v-model="type" name="chooseid"></label>
                <label> 管理员 <input type="radio" value="admin" v-model="type" name="chooseid"></label>
            </div>
            <button>登录</button>
        </form>
        <div class="others">
            <a href="">忘记密码</a>
            <label> | </label>
            <router-link href="" id="register" to="/mainPage/register" >注册账号</router-link>
        </div>


        
    </div>
</template>

<script>
export default {
    data(){
        return{
            id:'',
            password:'',
            type:'教师',
        }
    },
    methods:{
        onSubmit(){
            this.$axios({
            method:'POST',
            url:'/test/user/login',
            // data:JSON.stringify({
            //     username:this.username,
            //     password:this.password,
            //     type:this.type
            // })
            params: {
                id: this.id,
                password: this.password,  // 将输入的账号密码一并上传
                type: this.type
            }

            })
            .then((res)=>{
                if(res.status===200){
                    alert('登录成功')
                    this.$router.push('/classInfo')
                }
                if(res.status===204){
                    alert('账号或密码错误')
                }
            }).catch(err =>{
                alert('登录失败')
                this.$router.go(0)
                console.log(err)
            })
    },
    },
    created(){
        document.title='登录'
    }

    }

</script>

<style scoped>
    *{
        padding: 0;
        outline: none;
        /* 这个属性是告诉浏览器：你想要设置的边框和内边距的值是包含在总宽高内的 */
        box-sizing: border-box;
    }
    body{
        /* 弹性布局 水平垂直居中 */
        display: flex;
        justify-content: center;
        align-items: center;
        /* 设置body最小高度为100%窗口高度 */
        min-height: 100vh;

    }
    .wrapper{
        width: 440px;
        height: 500px;
        background-color: #fff;
        /* 内边距（上下左右） */
        padding: 40px;
        /* 盒子阴影 */
        box-shadow: 0px 0px 20px rgba(0,0,0,0.2);
        /* 圆角 */
        border-radius: 8px;

        float:right;
        margin-right: 60px;
        width: 440px;
        margin-top: 60px;


    }
    .wrapper .input-data{
        /* 相对定位 */
        position:relative;
        width: 90%;
        height: 40px;
    }
    .wrapper .input-data input{
        width: 100%;
        height: 100%;
        border:none;
        font-size: 17px;
        border-bottom: 2px solid #c0c0c0;
    }
    /* 输入框获得焦点时 */
    .wrapper .input-data input:focus ~ label,
    /* 输入框的值为合法时 */
    .wrapper .input-data input:valid ~ label{
        /* label上移，同时改变字号、字体颜色 */
        transform: translateY(-25px);
        font-size: 15px;
        color: #2c6fdb;
    }
    .wrapper .input-data label{
        /* 绝对定位 */
        position: absolute;
        bottom: 10px;
        left: 0px;
        color: #808080;
        /* 这个属性可以使点击label穿透到输入框 */
        pointer-events: none;
        /* 现在动画有点生硬，在这里需要给动画加个过渡 */
        transition: all 0.3s ease;
    }
    .wrapper .input-data .underline{
        position: absolute;
        bottom: 0px;
        height: 2px;
        width: 100%;
        background-color: #2c6fdb;
        /* 沿X轴缩小 */
        transform: scaleX(0);
        /* 这里同样给动画加个过渡 */
        transition: all 0.3s ease;
    }
    .wrapper .input-data input:focus ~ .underline,
    .wrapper .input-data input:valid ~ .underline{
        /* 沿X轴放大 */
        transform: scaleX(1);
    }
    .title{
        font-size: 40px;
        text-align: center;
    }
    .choice{
        margin-left: 0px;
        margin-top: 25px;
        color: rgba(0, 0, 0, 0.789);
        text-align: left;
    }
    button:hover{
        background-color: #1b66ca;
    }
    button{
        background-color: #2079f0;
        transition: 0.4s;
        transition-timing-function:ease-out;
        border: none;
        border-radius: 8px;
        width: 300px;
        height: 50px;
        color: #fff;
        font-size: 15px;
        margin-top: 40px;
        margin-left: 30px;
    }
    .others a{
        text-decoration: none;
        color: #4e4e4e85;
        font-size: 10px;
    }
    .others a:hover{
        color: #1b66ca;
        transition: 0.4s;
        transition-timing-function:ease-out;
    }
    .others{
        margin-top: 50px;
        text-align: center;
    }
    .others label{
        color: #4e4e4e85;
    }
    form{
        margin-top: -20px;
    }

</style>