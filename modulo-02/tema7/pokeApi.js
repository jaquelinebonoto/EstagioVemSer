class PokeApi { //classe para comunicação com o servidor de dados api
      constructor( url ) { //construtor que recebe a url de busca após ser instanciado um objeto
        this.url = url
      }
    
      buscar( idPokemon ) { //poderemos criar uma serie de funções que se comuniquem com a api.
        let urlPokemon = `${ this.url }/${ idPokemon }/` //a url e o idDigitado estão sendo recebidos no main
        return fetch( urlPokemon ) //traz de volta e segura. promise
        //os dados vão ser passados para JSON e depois vão ser tratados no pokemon.js
        //cada uma dessas ações gera um promise que será tratada com .then
      }
    }
