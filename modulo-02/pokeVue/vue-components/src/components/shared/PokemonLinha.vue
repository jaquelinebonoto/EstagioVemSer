<template>
         <tr>
          <td>{{ pokemon.id }}</td>
          <td>{{ pokemon.nome }}</td>
          <td><img v-bind:src="pokemon.thumbUrl" v-bind:alt="pokemon.nome"></td>
          <td>{{ pokemon.altura}} cm</td>
          <td>{{ pokemon.peso }} kg</td>
        </tr>   
</template>

<script>


export default {
    name: 'PokemonLinha',
    props: {
        pokemon: Object
    }
}
</script>

