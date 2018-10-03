<template>
  <div class="form-group">
    <label for="exampleInputEmail1">Email</label>
    <input type="email" v-bind:name="nome" v-model="valor" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="usuario@email.com">
    <small id="emailHelp" class="form-text text-muted">Não vamos compartilhar seu email com ninguém.</small>
  </div>
</template>
<script>
export default {
  name: 'EmailInput',
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