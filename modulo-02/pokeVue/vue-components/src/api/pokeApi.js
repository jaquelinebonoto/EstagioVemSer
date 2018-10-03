import Pokemon from '../models/pokemon.js'

export default class PokeApi {
  constructor( url ) {
    this.url = url
  }

async listarPorTipo( idTipo, resultadosPorPagina ) {
    const urlTipo = `https://pokeapi.co/api/v2/type/${ idTipo }/`
    return new Promise( resolve => {
      fetch( urlTipo )
      .then( j => j.json() )
      .then( t => {
        const pokemons = t.pokemon.slice( 0, resultadosPorPagina )
        const promisesPkm = pokemons.map( p => this.buscarPorUrl( p.pokemon.url ) )
        Promise.all( promisesPkm ).then( resultadoFinal => {
          resolve( resultadoFinal )
        } )
      } )
    } )
  }

  listItems(resultadoFinal, pageActual, resultadosPorPagina){
    const result = []
    const totalPage = Math.ceil( resultadoFinal.length / resultadosPorPagina )
    let count = ( pageActual * resultadosPorPagina ) - resultadosPorPagina
    const delimiter = count + resultadosPorPagina
    
    if(pageActual <= totalPage){
        for(let i=count; i<delimiter; i++){
            if(resultadoFinal[i] != null){
                result.push(resultadoFinal[i])
            }
            count++
        }
    }
    return result
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