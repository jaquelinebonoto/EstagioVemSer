import Pokemon from '../models/pokemon.js'

export default class PokeApi {
  constructor( url ) {
    this.url = url
  }

  async listarPorTipo( idTipo ) {
    const urlTipo = `https://pokeapi.co/api/v2/type/${ idTipo }/`
    fetch( urlTipo )
      .then( j => j.json() )
      .then( t => {
        const pokemons = t.pokemon.slice( 0, 5 )
        const promisesPkm = pokemons.map( p => this.buscarPorUrl( p.pokemon.url ) )
        Promise.all( promisesPkm ).then( resultadoFinal => {
          console.log( `resultadoFinal: ${ JSON.stringify( resultadoFinal ) }` )
        } )
      } )
  }

  async buscarPorUrl( urlPokemon ) {
    return new Promise( resolve => {
      fetch( urlPokemon )
        .then( j => j.json() )
        .then( p => {
          const pokemon = new Pokemon( p )
          // return "assícrono",
          // vai jogar o valor de pokemon para quem chamou utilizá-lo de forma assíncrona
          resolve( pokemon )
        } )
    } )
  }

  async buscar( idPokemon ) {
    let urlPokemon = `${ this.url }/${ idPokemon }/`
    return this.buscarPorUrl( urlPokemon )
  }
}