<template>
    <div>
        <headMenu/>

        <div class="main">
            <div id="app">
                <h1 style="text-align:center">&nbsp;</h1>
                <div class="head">
                    <el-row :gutter="20">
                        <el-col :span="6">
                            <el-input v-model="userInfo.username" placeholder="请输入学生姓名"></el-input>
                        </el-col>
                        <el-col :span="6">
                            <el-input v-model="userInfo.userid" placeholder="请输入学生学号"></el-input>
                        </el-col>
                        <el-col :span="6">
                            <el-input v-model="userInfo.uclass" placeholder="请输入学生班级"></el-input>
                        </el-col>
                        <el-col :span="6">
                            <el-input v-model="userInfo.specialty" placeholder="请输入学生专业"></el-input>
                        </el-col>
                    </el-row>
                    <el-button type="primary" @click="addUser" class="add-btn" plain>添加信息</el-button>
                </div>
                <!-- 主体内容 -->
                <div class="body">
                    <template>
                        <el-table :data="tableData" style="width: 100%">
                            <el-table-column label="序号" width="180"><template slot-scope="scope"> {{scope.$index + 1 }}
                                </template></el-table-column>
                            <el-table-column prop="username" label="姓名" width="180"></el-table-column>
                            <el-table-column prop="userid" label="学号"></el-table-column>
                            <el-table-column prop="uclass" label="班级"></el-table-column>
                            <el-table-column prop="specialty" label="专业"></el-table-column>
                            <el-table-column prop="birthday" label="操作">
                                <template slot-scope="scope">
                                    <el-button type="primary" icon="el-icon-edit" @click="editUser(scope.row)">
                                    </el-button>
                                    <el-button type="danger" icon="el-icon-delete" @click="delUser(scope.row)">
                                    </el-button>
                                </template>
                            </el-table-column>
                        </el-table>
                    </template>
                </div>
                <!-- 编辑框 -->
                <el-dialog title="编辑用户信息" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
                    <div>
                        <el-form ref="form" :model="editObj" label-width="80px">
                            <el-form-item label="姓名">
                                <el-input v-model="editObj.username"></el-input>
                            </el-form-item>
                            <el-form-item label="学号">
                                <el-input v-model="editObj.userid"></el-input>
                            </el-form-item>
                            <el-form-item label="班级">
                                <el-input v-model="editObj.uclass"></el-input>
                            </el-form-item>
                            <el-form-item label="专业">
                                <el-input v-model="editObj.specialty"></el-input>
                            </el-form-item>
                        </el-form>
                    </div>
                    <span slot="footer" class="dialog-footer">
                        <el-button @click="dialogVisible = false">取 消</el-button>
                        <el-button type="primary" @click="confirm">确 定</el-button>
                    </span>
                </el-dialog>
            </div>
        </div>

    </div>
</template>
<script src="js/axios.js"></script>
<script>
import headMenu from '../header/headMenu.vue'
import QueryString from 'qs'
export default {
    components:{headMenu},
        data: function () {
                    return {
                        userInfo: {
                            username:'',
                            userid:'',
                            uclass:'',
                            specialty:''
                        },
                        tableData: [],
                        dialogVisible: false,
                        editObj: {
                            username:'',
                            userid:'',
                            uclass:'',
                            specialty:''
                        },
                        userIndex: 0,
                    }
                },
        methods: {
            // 向后台传输更新后的学生列表
            update(){
                this.$axios({
                    method:'POST',
                    url:'/test/users/update',
                    /*params: {
                        tableData:this.tableData
                        /*userusername:this.userInfo.username,
                        userid:this.userInfo.userid,
                        uclass:this.userInfo.uclass,
                        specialty:this.userInfo.specialty*/

                    data:QueryString.stringify({
                        tableData:this.tableData
                    })
                })
                .then((res)=>{
                    console.log(res.data.data)
                    if(res.data.code===1){
                        alert('更新成功')
                        this.$router.go(0)
                    }
                    console.log(res.data.data)
                    if(res.data.code===0){
                        console.log(res.data.data)
                        alert('更新失败')
                    }
                }).catch(err =>{
                    alert('更新失败')
                    console.log(err)
                })
            },
            //添加
            addUser() {
                this.$axios.post('/test/users/add',this.userInfo).then((res)=>{
                            this.created;
                        });

                if (!this.userInfo.username) {
                    this.$message({
                        message: '请输入学生姓名！',
                    });
                    return;
                }
                if (!this.userInfo.userid) {
                    this.$message({
                        message: '请输入学生学号！',
                        type: 'warning'
                    });
                    return;
                }
                if (!this.userInfo.uclass) {
                    this.$message({
                        message: '请输入学生班级！',
                        type: 'warning'
                    });
                    return;
                }
                if (!this.userInfo.specialty) {
                    this.$message({
                        message: '请输入学生专业！',
                        type: 'warning'
                    });
                    return;
                }
                this.tableData.push(this.userInfo);
                this.update
                this.userInfo = {
                    username: '',
                    userid: '',
                    uclass: '',
                    specialty: '',

                    update(){
                this.$axios({
                    method:'POST',
                    url:'/test/users',
                    params: {
                        tableData:this.tableData
                        /*userusername:this.userInfo.username,
                        userid:this.userInfo.userid,
                        uclass:this.userInfo.uclass,
                        specialty:this.userInfo.specialty*/
                    }
                })
                .then((res)=>{
                    console.log(res.data.data)
                    if(res.data.code===1){
                        alert('更新成功')
                        this.$router.go(0)
                    }
                    console.log(res.data.data)
                    if(res.data.code===0){
                        console.log(res.data.data)
                        alert('更新失败')
                    }
                }).catch(err =>{
                    alert('更新失败')
                    console.log(err)
                })
            },
                };

            },

            //删除
            delUser(row) {
                this.$confirm('确认删除此用户信息？')
                this.$axios.delete('/test/users/'+row.id).then((res)=>{
                            this.created;
                });

                /*
                this.$axios.post('/test/users',this.userInfo).then((res)=>{
                            this.created;
                        });*/ 
                /*axios.delete("http://localhost:8081/users/"+row.id).then((res)=>{
                            //this.$confirm('确认删除此用户信息？')
                            this.getAll();
                        });*/ 


                /*this.$confirm('确认删除此用户信息？')
                    .then(_ => {
                        console.log(row);
                        this.tableData.splice(idx, 1);
                        this.update
                    })
                    .catch(_ => { });*/
            },
            //编辑
            editUser(row) {
                /*  this.userIndex = idx;
                this.editObj = {
                    userusername: item.username,
                    userid: item.userid,
                    uclass: item.uclass,
                    specialty: item.specialty,
                };
                this.dialogVisible = true;*/
                this.dialogVisible = true;
                    this.$axios.get("/test/users/"+row.id).then((res)=>{
                        this.editObj=res.data.data;
                    })
            },

            handleClose() {
                this.dialogVisible = false;
            },

            confirm() {
                /*console.log(this)
                this.dialogVisible = false;
                Vue.set(this.tableData, this.userIndex, this.editObj);*/

                this.$axios.put("/test/users/update",this.editObj).then((res)=>{
                            if(res.data.code=1){
                                alert("修改成功");
                                this.dialogVisible=false;
                                this.getAll()
                            }else{
                                alert("修改失败");

                            }
                        })
            }
        },

        mounted(){
            document.title='信息管理'
        },

        created(){
            this.$axios.get('/test/users/getAll')
            //then获取成功；response成功后的返回值（对象）
            .then(res=>{
                if(res.data.code===1){
                    this.tableData=res.data.data
                    console.log(this)
                }
                console.log(res);
                console.log(res.msg);
            })
            //获取失败
            .catch(error=>{
                console.log(error);
                alert('网络错误');
            })
        },

}
</script>

<style scoped>
    .main{
        margin: 0% 10%;
    }
    .add-btn{
        width: 100%;
        margin-top: 10px;
    }
</style>