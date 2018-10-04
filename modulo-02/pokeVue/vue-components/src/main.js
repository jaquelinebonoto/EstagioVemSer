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
      return `The ${nome} must be either a valid phone number or e-mail`;
  },
  validate(valor, args) {
    var validator = require('validator');
    validator.isEmail('foo@dbccompany.com.br'); //=> true
    const emailRule = @dbccompany.com.br;
    return emailRule.test(valor);
  }
};

const phoneOrEmailRule = {
  getMessage(field, args) {
    return `The ${field} must be either a valid phone number or e-mail`;
  },
  validate(value, args) {

    // Custom regex for a phone number 
    const MOBILEREG = /^((1[3578][0-9])+\d{8})$/;

    // Check for either of these to return true
    return VeeValidate.Rules.email(value) || MOBILEREG.test(value);
  }
};

new Vue( {
  router,
  render: h => h(App)
} ).$mount('#app')
