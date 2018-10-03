<template>
  <button class="btn btn-primary">{{ texto }}</button>
</template>

<script>
export default {
  name: 'Button',
  props: {
    texto: String
  }
}
</script>

<style>
button{
    background-color: #41B883;
    border: none;
    color: #35495E;
    padding: 15px 32px;
    text-align: center;
    text-decoration: bold;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;

}
</style>