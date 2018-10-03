<template>
  <section>
    <h1>{{ usuario }}, seja bem vindx!</h1>
    
    
    
    <select v-model="opcaoSelecionada" v-on:change="onChange">
      <option v-for="opcao in opcoes" v-bind:key="opcao.id" v-bind:value="opcao">
        {{ opcao.texto }}
      </option>
    </select>
    <h3 v-show="opcaoSelecionada.texto">Selecionado: {{ opcaoSelecionada.texto }}</h3>
  </section>
</template>

<script>
import PokeApi from '../../api/pokeApi.js'

export default {
  name: 'Home',
  data: () => {
    return {
      usuario: '',
      opcoes: [
        { id: 1, texto: 'Normal' },
        { id: 2, texto: 'Lutador' },
        { id: 3, texto: 'Voador' },
      ],
      opcaoSelecionada: {}
    }
  },
  methods: {
    async onChange() {
      console.log( `${ this.opcaoSelecionada.id } - ${ this.opcaoSelecionada.texto }` ) 
      const pokeApi = new PokeApi( 'https://pokeapi.co/api/v2/pokemon' )
      const pokemon = await pokeApi.buscar( 151 )
      const pokemon2 = await pokeApi.buscarPorUrl( 'https://pokeapi.co/api/v2/pokemon/118/' )
      console.log( `pokemon: ${ pokemon.id } - ${ pokemon.nome }` )
      console.log( `pokemon: ${ pokemon2.id } - ${ pokemon2.nome }` )
      await pokeApi.listarPorTipo( 1 )
    }
  },
  created() {
    this.usuario = this.$route.params.usuario
  }
}
</script>