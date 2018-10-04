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
      <tfoot>
        <Button v-bind:texto="textoBotao" v-bind:onClick="onNextPage" />
      </tfoot>
    </table>    
</template>

<script>
import PokemonLinha from './PokemonLinha.vue'
import Button from './Button.vue'
import PokeApi from '../../api/pokeApi.js'

export default {
    name: 'TabelaPokemon',
    data: () => {
        return {
            textoBotao: 'Próximo',
        }
    },
    props: {
        pokemons: Array,
        onNextPage: Function,
    },
    components: {
        PokemonLinha,
        Button
    }
}
</script>

<style>
.table-dark {
    width: 100%;
}
tfoot {
    margin: 0 auto;
    justify-content: center;
}
</style>


