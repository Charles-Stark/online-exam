<template>
    <div>
        <div style="min-width:1200px">
            <div class="div1">
                <table>
                    <tr>
                        <td><img src="../../assets/icon.png" width="135" left="250"></td>
                        <td style="font-size: 30px;min-width:200px;min-height:100px;">
                            &nbsp;&nbsp;教考分离系统
                        </td>
                        <td style="width:800px;"></td>
                        <td>
                            <div id="clock" style="font-size:20px;min-width:200px;min-height:100px;"></div>
                        </td>
                    </tr>
                </table>
            </div>
            <div position="absolute" style="left:20px;">
                <div id="menu">
                    <ul>
                        <li><router-link to="/classInfo" style="background:rgb(116, 196, 212)">信息管理</router-link></li>
                                <!-- <ul>
                                    <li><a href="PersonalInformation.html">个人信息</a></li>
                                    <li><a href="ClassInformation .html">班级信息</a></li>
                                </ul> -->
                        <li><router-link to="/manager">考试管理</router-link></li>
                        <li><router-link to="" style="background:rgb(116, 196, 212)">监考管理</router-link></li>
                        <li><router-link to="">阅卷管理</router-link></li>
                        <li><router-link to="" style="background:rgb(116, 196, 212)">题库编辑</router-link></li>

                    </ul>

                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    mounted(){
        setInterval(() => {
            var time = new Date();//获得当前时间
            var year = time.getFullYear();//获得年份
            var month = time.getMonth();//获得月份
            month++;
            var date = time.getDate();//获得日期
            var hour = time.getHours();
            var minute = time.getMinutes();
            var second = time.getSeconds();
            if (minute < 10)//如果分钟只有个位，在十位补0
            { minute = "0" + minute };
            if (second < 10) { second = "0" + second };
            document.getElementById('clock').innerHTML = year + "年" + month + "月" + date + "日" + hour + "时" + minute + "分" + second + "秒";
        }, 1000);
    }
}
</script>

<style scoped>
    .div1 {
        height: 90px;
        min-width: 1200px;
        background-repeat: no-repeat;
        background-size: 100%;
    }

    .div5 {
        position: absolute;
        height: 200px;
        left: 110px;
        top: 160px;
    }

    .div1 table h1 {
        min-width: 1200px;
        font-style: italic;
        font-family: YouYuan;
        font-weight: 900;
        font-size: 40px;
        line-height: 5px;
    }

    .div2 {
        height: 130px;
    }

    * {
        margin: 0px;
        padding: 0px;
    }

    #menu {
        background-color: rgb(134, 171, 245);
        font-family: STXingkai;
        font-size: 25px;
        height: 40px;
        margin: 0 auto;
    }

    ul {
        list-style: none;
    }

    ul li {
        line-height: 40px;
        text-align: center;
        position: relative;
        float: right;
    }

    a {
        text-decoration: none;
        color: #000;
        display: block;
        width: 180px;
        background: rgba(222, 211, 211, 0.58);
    }

    a:hover {
        color: #FFF;
        background-color: rgb(180, 133, 194);
    }

    ul li ul li {
        float: none;
        margin-top: 2px;
        background-color: #eee;
    }

    ul li ul {
        width: 90px;
        position: absolute;
        display: none;
    }

    ul li:hover ul {
        display: block;
    }
</style>