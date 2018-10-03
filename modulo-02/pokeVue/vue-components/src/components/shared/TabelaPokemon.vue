<template>
    <table class="table table-dark">
      <thead>
        <tr class="row">
           <th class="col">ID</th>
           <th class="col">Nome Pokemon</th>
           <th class="col">Thumb</th>
           <th class="col">Altura</th>
           <th class="col">Peso</th>
        </tr>
      </thead>
      <tbody>
        <PokemonLinha v-for="pokemon in pokemons" v-bind:key="pokemon.id" v-bind:pokemon="pokemon"/>
      </tbody>
    </table>    
</template>

<script>
import PokemonLinha from './PokemonLinha.vue'

export default {
    name: 'TabelaPokemon',
    props: {
        pokemons: Array
    },
    components: {
        PokemonLinha
    }
}
</script>

<style>

</style>


