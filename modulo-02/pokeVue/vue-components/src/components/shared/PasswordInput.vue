<template>
  <div class="form-group">
    <label v-bind:for="nome"></label>
    <input type="password" v-bind:name="nome" v-model="valor" class="form-control" v-bind:id="nome" placeholder="Senha">
  </div>
</template>

<script>
export default {
  name: 'PasswordInput',
  props: {
    nome: String
  },
  data: () => {
    return {
      valor: ''
    }
  }
}
</script>