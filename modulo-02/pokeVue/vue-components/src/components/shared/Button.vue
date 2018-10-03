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