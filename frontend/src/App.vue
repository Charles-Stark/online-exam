<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
import mainPage from "./components/login_register/mainPage.vue";
import classInfo from "./components/classinfo/classInfo.vue";
import manager from "./components/TestPaper/manager.vue";
import testPage from "./components/TestPaper/testPage.vue"
import scorePage from "./components/TestPaper/scorePage.vue"

export default {
  name: "App",
  components: {
    mainPage,
    classInfo,
    manager,
    testPage,
    scorePage
  },
};
</script>

<style>
</style>
