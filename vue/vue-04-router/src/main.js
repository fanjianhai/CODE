import Vue from 'vue'
import App from './App'
import router from './router' // 自动扫描里面的路由配置

Vue.config.productionTip = false


new Vue({
  el: '#app',
  router,   // 配置路由
  components: { App },
  template: '<App/>'
})
