<template>
  <form v-on:submit.prevent="onSubmit">
    <EmailInput nome="usuario" ref="usuarioRef" />
    <PasswordInput nome="senha" ref="senhaRef" />
    <Button v-bind:texto="textoBotao" type="submit" />
  </form>
</template>

<script>
import Button from '../shared/Button.vue'
import EmailInput from '../shared/EmailInput.vue'
import PasswordInput from '../shared/PasswordInput.vue'

export default {
  name: 'Login',
  components: {
    Button, EmailInput, PasswordInput
  },
  data: () => {
    return {
      textoBotao: 'Entrar'
    }
  },
  methods: {
    onSubmit() {
      // acesso ao valor do campo usuario
      console.log( `usuário: ${ this.$refs.usuarioRef.valor }` )
      console.log( `senha: ${ this.$refs.senhaRef.valor }` )
      const usuario = this.$refs.usuarioRef.valor,
        senha = this.$refs.senhaRef.valor
      
      // jamais façam isso na vida real
      // é apenas uma simulação de login
      const podeLogar = usuario === 'admin@dbccompany.com.br' && senha === 'admin'
      if ( podeLogar ) {
        this.textoBotao = 'Aguarde...'
        setTimeout( () => {
          this.$router.push( { name: 'home', params: { usuario } } )
        }, 2000 )
      }
    }
  }
}
</script>