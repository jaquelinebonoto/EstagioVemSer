import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App.vue'
import Login from './components/screens/Login.vue'

import Home from './components/screens/Home.vue'

Vue.config.productionTip = false
Vue.use( VueRouter )

const routes = [
  { path: '/', component: Login },
  { name: 'home', path: '/home/:usuario', component: Home }
]

const router = new VueRouter( {
  routes
} )

new Vue( {
  router,
  render: h => h(App)
} ).$mount('#app')
