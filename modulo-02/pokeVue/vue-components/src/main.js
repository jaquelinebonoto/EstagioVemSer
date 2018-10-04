import Vue from 'vue'
import VueRouter from 'vue-router'
import VeeValidate , { Validator } from 'vee-validate'
import App from './App.vue'
import Login from './components/screens/Login.vue'
import Home from './components/screens/Home.vue'
import ptBR from 'vee-validate/dist/locale/pt_BR'


Validator.localize('pt_BR', ptBR);

Vue.config.productionTip = false
Vue.use( VueRouter )
Vue.use(VeeValidate)




const routes = [
  { path: '/', component: Login },
  { name: 'home', path: '/home/:usuario', component: Home }
]

const router = new VueRouter( {
  routes
} )

const regraEmail = {
  getMessage(nome, args) {
      return `${nome}: Este teste está bonito. Valide com seu email DBC.`;
  },
  validate(valor, args) {
  const emailRule = /@dbccompany.com.br/;
     return emailRule.test(valor);
  }
};
VeeValidate.Validator.extend('regraEmail', regraEmail);

new Vue( {
  router,
  render: h => h(App)
} ).$mount('#app')
