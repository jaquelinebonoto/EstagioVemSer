class PokeApi { //classe para comunicação com o servidor de dados api
      constructor( url ) { //construtor que recebe a url de busca após ser instanciado um objeto
        this.url = url
      }
    
      async buscar( idPokemon ) { 
        let urlPokemon = `${ this.url }/${ idPokemon }/` 
        return new Promise( resolve => {
          fetch(urlPokemon)
          .then(j => j.json())
          .then(p => {
          const pokemon = new Pokemon( p )
          //return assíncrono
          resolve(pokemon)
          })
      })
    }
  }
