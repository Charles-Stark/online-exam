<template>
  <!-- 手动组卷 -->
  <div id="manual" style="position: absolute; top: 60px; left: 200px">
    <el-button type="primary" @click="dialogFormVisible = true" class="button1"
      >手动组卷</el-button
    >
    <el-dialog title="手动组卷" :visible.sync="dialogFormVisible">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="试卷名称">
          <el-input v-model="form.name"></el-input>
        </el-form-item>

        <el-form-item label="考试时间">
          <el-col :span="11">
            <el-date-picker
              type="date"
              placeholder="选择日期"
              value-format="yyyy-MM-dd"
              v-model="form.date1"
              style="width: 80%"
            >
            </el-date-picker>
          </el-col>
          <el-col class="line" :span="1">-</el-col>
          <el-col :span="11">
            <el-time-picker
              placeholder="选择时间"
              value-format="HH:mm:ss"
              v-model="form.date2"
              style="width: 80%"
            >
            </el-time-picker>
          </el-col>
        </el-form-item>

        <el-form-item label="考试时长">
          <el-input-number v-model="form.limitedTime" :min="30" :max="180">
          </el-input-number>
        </el-form-item>

        <el-form-item label="科目类型">
          <el-select v-model="form.subject" placeholder="请选择科目类型">
            <el-option label="语文" value="语文"></el-option>
            <el-option label="数学" value="数学"></el-option>
            <el-option label="物理" value="物理"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="题目类型">
          <el-select v-model="form.problem" placeholder="请选择题目类型">
            <el-option label="选择题" value="SingleChoice"></el-option>
            <el-option label="判断题" value="Judgement"></el-option>
            <el-option label="填空题" value="GAPFilling"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="自选题目">
          <el-transfer
            v-model="form.value"
            :data="data"
            :props="{ key: 'questionid', label: 'questioninfo' }"
            :render-content="renderFunc"
          ></el-transfer>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="onSubmit">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      data: [],
      num: 10,
      dialogTableVisible: false,
      dialogFormVisible: false,
      form: {
        name: "",
        date1: "",
        date2: "",
        limitedTime: "",
        subject: "",
        problem: "",
        paperId:"",
        value: [],
      },
      formLabelWidth: "120px",
    };
  },
  methods: {
    onSubmit() {
      console.log("submit!");
      this.$axios({
        method: "post",
        url: "/api/v1/paper/create",
        params: {
          name: this.form.name,
          date1: this.form.date1,
          date2: this.form.date2,
          limitedtime: this.form.limitedTime,
          subject: this.form.subject,
          problem: this.form.problem,
          value: this.form.value.toString(),
        },
      })
        .then((res) => {
          console.log(res);
          this.form.paperId=res.data.data.paperid;
          this.$router.push('/testPage')
        })
        .catch((err) => {
          console.log(err);
          alert("提交失败");
        });
    },
    renderFunc(h, option) {
      return <span title={option.questioninfo}>{option.questioninfo}</span>;
    },
  },

  beforeDestroy(){
    this.$nextTick(function (){
      this.$bus.$emit('getInfo2',this.form.paperId,this.form.limitedTime);
    })
  },

  watch: {
    subject(n, o) {
      console.log(n, o);
      if (this.form.problem != "") {
        //单选题
        if (this.problem === "SingleChoice") {
          this.$axios({
            method: "get",
            url: `/api/v1/ob1/all?coursename=${this.form.subject}`,
          })
            .then((res) => {
              console.log(res);
              this.data = res.data.data;
            })
            .catch((err) => {
              console.log(err);
              alert("获取题目列表失败");
            });
        }
        //判断题
        else if (this.problem === "Judgement") {
          this.$axios({
            method: "get",
            url: `/api/v1/ob2/all?coursename=${this.form.subject}`,
          })
            .then((res) => {
              console.log(res);
              this.data = res.data.data;
            })
            .catch((err) => {
              console.log(err);
              alert("获取题目列表失败");
            });
        }
        //填空题
        else if (this.problem === "GAPFilling") {
          this.$axios({
            method: "get",
            url: `/api/v1/sq/all?coursename=${this.form.subject}`,
          })
            .then((res) => {
              console.log(res);
              this.data = res.data.data;
            })
            .catch((err) => {
              console.log(err);
              alert("获取题目列表失败");
            });
        }
      }
    },
    problem(n, o) {
      console.log(n, o);
      if (this.form.subject != "") {
        //单选题
        if (this.problem === "SingleChoice") {
          this.$axios({
            method: "get",
            url: `/api/v1/ob1/all?coursename=${this.form.subject}`,
          })
            .then((res) => {
              console.log(res);
              this.data = res.data.data;
              console.log(this.data);
            })
            .catch((err) => {
              console.log(err);
              alert("获取题目列表失败");
            });
        }
        //判断题
        else if (this.problem === "Judgement") {
          this.$axios({
            method: "get",
            url: `/api/v1/ob2/all?coursename=${this.form.subject}`,
          })
            .then((res) => {
              console.log(res);
              this.data = res.data.data;
            })
            .catch((err) => {
              console.log(err);
              alert("获取题目列表失败");
            });
        }
        //填空题
        else if (this.problem === "GAPFilling") {
          this.$axios({
            method: "get",
            url: `/api/v1/sq/all?coursename=${this.form.subject}`,
          })
            .then((res) => {
              console.log(res);
              this.data = res.data.data;
            })
            .catch((err) => {
              console.log(err);
              alert("获取题目列表失败");
            });
        }
      }
    },
  },

  computed: {
    subject() {
      return this.form.subject;
    },
    problem() {
      return this.form.problem;
    },
  },
};
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
  color: #fff;
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

/* 组卷板块 */
.group {
  min-width: 1200px;
  position: absolute;
  left: 10%;
  top: 160px;
  width: 80%;
  height: 170px;
  text-align: center;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}

/* 组卷按键 */
.button1 {
  width: 350px;
  height: 80px;
}
</style>