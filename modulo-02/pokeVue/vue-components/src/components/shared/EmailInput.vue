<template>
  <div class="form-group">
    <label for="exampleInputEmail1"></label>
    <input type="text" v-validate=" 'required|regraEmail' " v-bind:name="nome" v-model="valor" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="usuario@email.com"><br>
    <span>{{errors.first( this.nome )}}</span>
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

<style>
input, select {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
</style>