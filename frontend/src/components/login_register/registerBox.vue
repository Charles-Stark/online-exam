<template>
    <div class="wrapper">
        <span class="title"> <b>注册账号</b></span>
        <router-link id="back" to="/mainPage/login"><b>现有账号登录</b></router-link>
        <br><br>
        
        <form id="formStudent" @submit.prevent="onSubmit" v-if="showFormStudent">
            <div class="input-data" id="phonenumber">
                <input type="text" v-model="phone" id="pnum" required>
                <div class="underline"></div>
                <label>手机号</label>
            </div>
            <div class="input-data">
                <input type="text" v-model="username" id="username" required>
                <div class="underline"></div>
                <label>用户名</label>
            </div>
            <div class="input-data">
                <input type="password" v-model="password" id="psw" required>
                <div class="underline"></div>
                <label>设置一个密码</label>
            </div>
            <div class="input-data">
                <input type="password" v-model="rpassword" id="rpsw" required>
                <div class="underline"></div>
                <label>再一次输入密码</label>
            </div>

            <p>您的性别：</p>
            <div class="radio-sex">
                <input type="radio" id="sex1" name="sex" v-model="sex" value="male" required>
                <label for="sex1"></label>
                <span>男</span>
            </div>
            <div class="radio-sex">
                <input type="radio" id="sex2" name="sex" v-model="sex" value="female" >
                <label for="sex2"></label>女
            </div>


            <div class="choice">
                <label> 学生 <input type="radio" value="student" name="chooseid" v-model="type" required></label>
                <label> 教师 <input type="radio" value="teacher" v-model="type" name="chooseid"></label>
                <label> 管理员 <input type="radio" value="admin" v-model="type" name="chooseid"></label>
            </div>
            

            <div class="input-data" id="school">
                <input type="text"  name="school" list="schoollist" v-model="school" required>
                <div class="underline"></div>
                <label>选择学校</label>
                <datalist id="schoollist">
                    <option value="中国计量大学">中国计量大学</option>
                    <option value="浙江财经大学">浙江财经大学</option>
                    <option value="浙江理工大学">浙江理工大学</option>
                    <option value="杭州电子科技大学">杭州电子科技大学</option>
                </datalist>
            </div>

            <div class="input-data" id="faculties">
                <input type="text" v-model="faculties"  required>
                <div class="underline"></div>
                <label>院系</label>
            </div>

            <div class="input-data" id="specialty">
                <input type="text" v-model="specialty"  required>
                <div class="underline"></div>
                <label>专业</label>
            </div>

            <div class="input-data"  id="class">
                <input type="text" v-model="Class" required>
                <div class="underline"></div>
                <label>班级</label>
            </div>

            <div class="input-data" id="id">
                <input type="text" v-model="id" required>
                <div class="underline"></div>
                <label>学号</label>
            </div>
            <div class="birth">
                <label>出生日期:</label>
                <div class="input-data" id="birthyear">
                    <input type="text" v-model="birthyear" required
                    oninput="this.value = this.value.replace(/[^0-9]/g,'')"> <!-- 确保输入的数在0-9范围内 -->
                    <div class="underline"></div>
                    <label>年</label>
                </div>
                <div class="input-data" id="birthmonth">
                    <input type="text" v-model="birthmonth" required
                    oninput="this.value = this.value.replace(/[^0-9]/g,'')"
                    list="month">
                    <div class="underline"></div>
                    <label>月</label>
                    <datalist id="month">
                        <option value="1"></option>
                        <option value="2"></option>
                        <option value="3"></option>
                        <option value="4"></option>
                        <option value="5"></option>
                        <option value="6"></option>
                        <option value="7"></option>
                        <option value="8"></option>
                        <option value="9"></option>
                        <option value="10"></option>
                        <option value="11"></option>
                        <option value="12"></option>
                    </datalist>
                </div>
                <div class="input-data" id="birthday">
                    <input type="text" v-model="birthday" required
                    oninput="this.value = this.value.replace(/[^0-9]/g,'')">
                    <div class="underline"></div>   
                    <label>日</label>
                </div>
            </div>
            <div class="input-data" id="checkBox">
                <input type="text" id="inputCode" required>
                <div class="underline"></div>
                <label>输入图中验证码</label>
            </div>
            <div id="checkCode" class="code"  @click="createCode(4)" ></div>
            <button id="submit">提交</button>
        </form>
        <form id="formTeacher" @submit.prevent="onSubmit" v-if="showFormTeacher">
            <div class="input-data" id="phonenumber">
                <input type="text" v-model="phone" id="pnum" required>
                <div class="underline"></div>
                <label>手机号</label>
            </div>
            <div class="input-data">
                <input type="text" v-model="username" id="username" required>
                <div class="underline"></div>
                <label>用户名</label>
            </div>
            <div class="input-data">
                <input type="password" v-model="password" id="psw" required>
                <div class="underline"></div>
                <label>设置一个密码</label>
            </div>
            <div class="input-data">
                <input type="password" v-model="rpassword" id="rpsw" required>
                <div class="underline"></div>
                <label>再一次输入密码</label>
            </div>

            <p>您的性别：</p>
            <div class="radio-sex">
                <input type="radio" id="sex1" name="sex" v-model="sex" value="male" required>
                <label for="sex1"></label>
                <span>男</span>
            </div>
            <div class="radio-sex">
                <input type="radio" id="sex2" name="sex" v-model="sex" value="female" >
                <label for="sex2"></label>女
            </div>


            <div class="choice">
                <label> 学生 <input type="radio" value="student" name="chooseid" v-model="type" required></label>
                <label> 教师 <input type="radio" value="teacher" v-model="type" name="chooseid"></label>
                <label> 管理员 <input type="radio" value="admin" v-model="type" name="chooseid"></label>
            </div>
            

            <div class="input-data" id="school">
                <input type="text"  name="school" list="schoollist" v-model="school" required>
                <div class="underline"></div>
                <label>选择学校</label>
                <datalist id="schoollist">
                    <option value="中国计量大学">中国计量大学</option>
                    <option value="浙江财经大学">浙江财经大学</option>
                    <option value="浙江理工大学">浙江理工大学</option>
                    <option value="杭州电子科技大学">杭州电子科技大学</option>
                </datalist>
            </div>

            <div class="input-data" id="faculties">
                <input type="text" v-model="faculties"  required>
                <div class="underline"></div>
                <label>院系</label>
            </div>

            <div class="input-data" id="specialty">
                <input type="text" v-model="specialty"  required>
                <div class="underline"></div>
                <label>专业</label>
            </div>

            <div class="input-data"  id="class">
                <input type="text" v-model="Class" required>
                <div class="underline"></div>
                <label>班级</label>
            </div>

            <div class="input-data" id="id">
                <input type="text" v-model="id" required>
                <div class="underline"></div>
                <label>工号</label>
            </div>
            <div class="birth">
                <label>出生日期:</label>
                <div class="input-data" id="birthyear">
                    <input type="text" v-model="birthyear" required
                    oninput="this.value = this.value.replace(/[^0-9]/g,'')"> <!-- 确保输入的数在0-9范围内 -->
                    <div class="underline"></div>
                    <label>年</label>
                </div>
                <div class="input-data" id="birthmonth">
                    <input type="text" v-model="birthmonth" required
                    oninput="this.value = this.value.replace(/[^0-9]/g,'')"
                    list="month">
                    <div class="underline"></div>
                    <label>月</label>
                    <datalist id="month">
                        <option value="1"></option>
                        <option value="2"></option>
                        <option value="3"></option>
                        <option value="4"></option>
                        <option value="5"></option>
                        <option value="6"></option>
                        <option value="7"></option>
                        <option value="8"></option>
                        <option value="9"></option>
                        <option value="10"></option>
                        <option value="11"></option>
                        <option value="12"></option>
                    </datalist>
                </div>
                <div class="input-data" id="birthday">
                    <input type="text" v-model="birthday" required
                    oninput="this.value = this.value.replace(/[^0-9]/g,'')">
                    <div class="underline"></div>   
                    <label>日</label>
                </div>
            </div>
            <div class="input-data" id="checkBox">
                <input type="text" id="inputCode" required>
                <div class="underline"></div>
                <label>输入图中验证码</label>
            </div>
            <div id="checkCode" class="code"  @click="createCode(4)" ></div>
            <button id="submit">提交</button>
        </form>
        <form id="formAdmin" @submit.prevent="onSubmit" v-if="showFormAdmin">
            <div class="input-data" id="phonenumber">
                <input type="text" v-model="phone" id="pnum" required>
                <div class="underline"></div>
                <label>手机号</label>
            </div>
            <div class="input-data">
                <input type="text" v-model="username" id="username" required>
                <div class="underline"></div>
                <label>用户名</label>
            </div>
            <div class="input-data">
                <input type="password" v-model="password" id="psw" required>
                <div class="underline"></div>
                <label>设置一个密码</label>
            </div>
            <div class="input-data">
                <input type="password" v-model="rpassword" id="rpsw" required>
                <div class="underline"></div>
                <label>再一次输入密码</label>
            </div>

            <p>您的性别：</p>
            <div class="radio-sex">
                <input type="radio" id="sex1" name="sex" v-model="sex" value="male" required>
                <label for="sex1"></label>
                <span>男</span>
            </div>
            <div class="radio-sex">
                <input type="radio" id="sex2" name="sex" v-model="sex" value="female" >
                <label for="sex2"></label>女
            </div>


            <div class="choice">
                <label> 学生 <input type="radio" value="student" name="chooseid" v-model="type" required></label>
                <label> 教师 <input type="radio" value="teacher" v-model="type" name="chooseid"></label>
                <label> 管理员 <input type="radio" value="admin" v-model="type" name="chooseid"></label>
            </div>
            

            <div class="input-data" id="school">
                <input type="text"  name="school" list="schoollist" v-model="school" required>
                <div class="underline"></div>
                <label>选择学校</label>
                <datalist id="schoollist">
                    <option value="中国计量大学">中国计量大学</option>
                    <option value="浙江财经大学">浙江财经大学</option>
                    <option value="浙江理工大学">浙江理工大学</option>
                    <option value="杭州电子科技大学">杭州电子科技大学</option>
                </datalist>
            </div>

            <div class="input-data" id="faculties">
                <input type="text" v-model="faculties"  required>
                <div class="underline"></div>
                <label>院系</label>
            </div>


            <div class="input-data"  id="class">
                <input type="text" v-model="Class" required>
                <div class="underline"></div>
                <label>班级</label>
            </div>

            <div class="input-data" id="id">
                <input type="text" v-model="id" required>
                <div class="underline"></div>
                <label>工号</label>
            </div>
            <div class="input-data" id="checkBox">
                <input type="text" id="inputCode" required>
                <div class="underline"></div>
                <label>输入图中验证码</label>
            </div>
            <div id="checkCode" class="code"  @click="createCode(4)" ></div>
            <button id="submit">提交</button>
        </form>


        
    </div>
</template>


<script>

export default {
    data(){
        return{
            username:'',
            sex:'',
            password:'',
            type:'student',
            school:'',
            phone:'',
            rpassword:'',
            id:'',
            birthyear:'',
            birthmonth:'',
            birthday:'',
            specialty:'',
            faculties:'',
            Class:'',


        }
    },
    computed:{
        class(){
            return this.Class
        },
        showFormStudent(){
            return this.type==='student'
        },
        showFormTeacher(){
            return this.type==='teacher'
        },
        showFormAdmin(){
            return this.type==='admin'
        }
    },
    
    methods: {
        onSubmit(){
            var flag=true;
            var checkCode = document.getElementById("checkCode").innerHTML;
            //获取输入的验证码
            var inputCode = document.getElementById("inputCode").value;
            console.log(checkCode);
            console.log(inputCode);
            if(this.phone.length!=11){
                alert("手机号格式错误！")
                document.getElementById("pnum").value="";
                flag=false;
            }
            else if(this.password!=this.rpassword){
                alert("两次输入的密码不一致！");
                document.getElementById("psw").value="";
                document.getElementById("rpsw").value="";
                flag=false;
            }
            //获取显示区生成的验证码
            else if (inputCode.toUpperCase() != checkCode.toUpperCase()){
                alert("验证码输入有误！");
                document.getElementById("inputCode").value="";
                this.createCode(4);
                flag=false;
            }
            if(flag){
                this.$axios({
                method:'POST',
                url:'/test/user/register',
                // data:JSON.stringify({
                //     username:this.username,
                //     password:this.password,
                //     type:this.type
                // })
                params: {
                    username:this.username,
                    sex:this.sex,
                    password:this.password,
                    type:this.type,
                    school:this.school,
                    phone:this.phone,
                    rpassword:this.rpassword,
                    id:this.id,
                    birthyear:this.birthyear,
                    birthmonth:this.birthmonth,
                    birthday:this.birthday,
                    specialty:this.specialty,
                    faculties:this.faculties,
                    class:this.Class
                }

                })
                .then((res)=>{
                    if(res.status===200){
                        alert('注册成功')
                        this.$router.push('/mainPage/login')
                    }
                    else if(res.status===204){
                        alert('学号已存在')
                    }
                    console.log(res)
                }).catch(err =>{
                    alert('注册失败')
                    this.$router.go(0)
                    console.log(err)
                })
            }
        },
        createCode(length) {
            var code = "";
            var codeLength = parseInt(length); //验证码的长度
            var checkCode = document.getElementById("checkCode");
            ////所有候选组成验证码的字符，当然也可以用中文的
            var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); 
            //循环组成验证码的字符串
            for (var i = 0; i < codeLength; i++)
            {
                //获取随机验证码下标
                var charNum = Math.floor(Math.random() * 62);
                //组合成指定字符验证码
                code += codeChars[charNum];
            }
            if (checkCode)
            {
                //为验证码区域添加样式名
                checkCode.className = "code";
                //将生成验证码赋值到显示区
                checkCode.innerHTML = code;
            }
        }    
    },
        mounted: function () {//生成初始验证码
            this.createCode(4)
            document.title='注册'
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
        width: 700px;
        height: 600px;
        background-color: #fff;
        /* 内边距（上下左右） */
        padding: 40px;
        /* 盒子阴影 */
        box-shadow: 0px 0px 20px rgba(0,0,0,0.2);
        /* 圆角 */
        border-radius: 8px;

        margin-left: 60px;
        margin-top: 40px;
        width: 700px;
        float: left;

    }
    .wrapper .input-data{
        /* 相对定位 */
        position:relative;
        width: 40%;
        height: 40px;
        margin-top: 30px;
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
        margin-top: 30px;
        width: 210px;
        color: rgba(0, 0, 0, 0.789);
        text-align: left;
    }
    #submit:hover{
        background-color: #1b66ca;
    }
    #submit{
        background-color: #2079f0;
        transition: 0.4s;
        transition-timing-function:ease-out;
        border: none;
        border-radius: 8px;
        width: 240px;
        height: 50px;
        color: #fff;
        font-size: 15px;
        margin-top: 30px;
        margin-right: 80px;
        float: right;
    }
    form{
        margin-top: -30px;
    }
    #school{
        margin-left: 300px;
        margin-top: -391px;
    }
    #id{
        margin-left: 430px;
        margin-top: -40px;
        width: 20%;
    }
    #birthyear{
        margin-left: 0px;
        margin-top: 13px;
    }
    #birthmonth{
        margin-top: -40px;
        margin-left: 85px
    }
    #birthday{
        margin-top: -40px;
        margin-left: 170px
    }
    .birth .input-data{
        width: 24%;
    }
    .birth{
        width: 300px;
        margin-left: 300px;
        margin-top: 10px;
    }
    .birth label{
        color: #999a9b;
    }
    #back{
        margin-top: -40px;
        margin-left: 400px;
        background: none;
        text-decoration: none;
        color: #3f9df6;
        width: 150px;
        height: 45px;
        border-radius: 8px;
        transition: all 0.5s ease 0s;
        font-size: 20px;
        border-style: none;
        display: block;
        text-align: center;
        line-height: 45px;
    }
    #back:hover{
        background: #85858534;
        color: #1b66ca
    }
    #back:active{
        background: #3a3a3a34;
    }

    .code{
        font-family:Arial;
        font-style:italic;
        color:blue;
        font-size:30px;
        border:0;
        padding:2px 3px;
        letter-spacing:3px;
        font-weight:bolder;            
        float:left;           
        cursor:pointer;
        width:120px;
        height:50px;
        line-height:50px;
        text-align:center;
        background-color:#D8B7E3;
        margin-left: 435px;
        margin-top: -50px;
    }

    #check{
        border-style: solid;
        height: 90px;
    }
    #checkBox{
        margin-left: 300px;
        width: 21%;
    }

    #specialty{
        width: 20%;
        margin-left: 430px;
        margin-top: -40px;
    }
    #faculties{
        width: 20%;
        margin-left: 300px;
    }

    .radio-sex {
        position: relative;
        display: inline-block;
        margin-right: 12px;
    }
    .radio-sex input {
        vertical-align: middle;
        /* 前面三行代码是为了让radio单选按钮与文字对齐 */
        width: 20px;
        height: 20px;
        appearance: none; /*清楚默认样式*/
        -webkit-appearance: none;
        opacity: 0;
        outline: none;
        /* 注意不能设置为display:none*/
    }
    .radio-sex label {
        position: absolute;
        left: 0;
        top: 0;
        z-index: 1;
        /*注意层级关系，如果不把label层级设为最低，会遮挡住input而不能单选*/
        width: 20px;
        height: 20px;
        border: 1px solid #3582e9;
        border-radius: 100%;
    }
    .radio-sex input[type="radio"]:checked + label {
        background: #3582e9;
    }
    .radio-sex input[type="radio"]:checked + label::after {
        content: "";
        position: absolute;
        left: 7px;
        top: 2px;
        width: 5px;
        height: 12px;
        border-right: 1px solid #fff;
        border-bottom: 1px solid #fff;
        transform: rotate(45deg);
    }
    .radio-sex span{
        vertical-align: middle;
    }
    p{
        margin-top: 30px;
    }

    #class{
        width: 20%;
        margin-left: 300px;
    }

    #formAdmin #class{
        width: 40%;
    }
    #formAdmin #id{
        width: 40%;
        margin-top: 30px;
        margin-left: 300px;
    }
    #formAdmin #faculties{
        width: 40%;
    }

</style>