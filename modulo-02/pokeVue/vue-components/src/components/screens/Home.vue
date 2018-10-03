<template>
  <section>
    <h1>{{ usuario }}, seja bem vindx!</h1>
    <select v-model="opcaoSelecionada" v-on:change="onChange">
      <option v-for="opcao in opcoes" v-bind:key="opcao.id" v-bind:value="opcao">
        {{ opcao.texto }}
      </option>
    </select><br>
    <select v-model="resultadosPorPag" v-on:change="onChangePag">
      <option v-for="page in pokePorPag" v-bind:key="page.id" v-bind:value="page">
        {{ page.texto }}
      </option>
    </select>
    <h3 v-show="opcaoSelecionada.texto">Selecionado: {{ opcaoSelecionada.texto }}</h3>
    <TabelaPokemon :pokemons="result"/>
  </section>
</template>

<script>
import PokeApi from '../../api/pokeApi.js'
import PokemonLinha from '../shared/PokemonLinha.vue'
import TabelaPokemon from '../shared/TabelaPokemon.vue'

export default {
  name: 'Home',
  components: {
    PokemonLinha, TabelaPokemon
  },
  data: () => {
    return {
      usuario: '',
      opcoes: [
        { id: 1, texto: 'flying' },
        { id: 2, texto: 'bug' },
        { id: 3, texto: 'electric' },
      ],
      opcaoSelecionada: {},
      pokePorPag: [
        {qt: 5, texto: '5'},
        {qt: 10, texto: '10'},
        {qt: 15, texto: '15'},
      ],
      resultadosPorPag: {},
      result: []
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
      this.result = await pokeApi.listarPorTipo( this.opcaoSelecionada.id , this.resultadosPorPag.qt)
      console.log(this.result)
    },
    onChangePag(){
        console.log( `${ this.resultadosPorPag.qt } - ${ this.resultadosPorPag.texto }` ) 
        return this.resultadosPorPag.qt
    }
  },

  created() {
    this.usuario = this.$route.params.usuario
  }
}
</script>