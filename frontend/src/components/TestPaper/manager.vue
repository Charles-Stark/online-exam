<template>
  <div>
    <headMenu/>
    <div class="group">
      <div>
        <h1>组卷功能</h1>
      </div>
        <automatic class="btns"/>
        <manual class="btns"/>
      </div>
  </div>
</template>

<script>
import automatic from "./automatic";
import manual from "./manual";
import headMenu from "../header/headMenu";

export default {
  components: {automatic, manual, headMenu},
  mounted(){
    document.title='考试管理'
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
.group {
  min-width: 1200px;
  position: absolute;
  left: 10%;
  top: 160px;
  width: 80%;
  height: 170px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}

.btns{
  height: 100px;
  margin-top: 20px;
  margin-left: 40px;
}
h1{
  text-align: center;
}
</style>