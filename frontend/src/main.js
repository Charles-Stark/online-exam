import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import router from './router'
import axios from 'axios'
import qs from 'qs';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.prototype.$qs = qs
Vue.prototype.$axios = axios



Vue.config.productionTip = false
Vue.use(VueRouter)
Vue.use(ElementUI);

new Vue({
  render: h => h(App),
  router:router,
  beforeCreate() {
    Vue.prototype.$bus=this//安装全局事件总线
  },
}).$mount('#app')

router.beforeEach((to, from, next) => {
  /* 路由发生变化修改页面title */
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
})