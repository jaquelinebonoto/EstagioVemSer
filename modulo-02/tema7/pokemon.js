class Pokemon { //classe usada para trabalhar os dados recebidos e ja parseados
      constructor( jsonVindoDaApi ) { //recebe os dados do main (res => res.json()) == parse
        this.nome = jsonVindoDaApi.name //construtor recebe os atributos que podem ser verificados na API
        this.id = jsonVindoDaApi.id 
        this.thumbUrl = jsonVindoDaApi.sprites.front_default
        this._altura = jsonVindoDaApi.height
        this._peso = jsonVindoDaApi.weight
        // A função map faz o MAPEAMENTO / transformação de um array de objetos em uma determinada estrutura para outra
        // exemplo: traduzir campos, adicionar campos, remover campos (poderia ter sido usado no exemplo do formatarElfos)
        // no exemplo abaixo, estamos pegando um objeto complexo e projetando um objeto mais simples de saída
        // para cada elemento no array, transforma:
        // entrada: {slot: 2, type: {name: "steel", url: "https://pokeapi.co/api/v2/type/9/"}}
        // saída: "steel"
        // ou seja, neste caso teremos um array de strings (ex: [ "steel", "fire" ])
        // https://developer.mozilla.org/pt-BR/docs/Web/JavaScript/Reference/Global_Objects/Array/map
        this.tipos = jsonVindoDaApi.types.map( t => t.type.name )
        // TODO: pegar outros campos do JSON
      }
    

      // como a altura vem em dezenas de cm, estamos aplicando um cálculo para traduzir para cm
      get altura() {
        return this._altura * 10
      }

      get peso(){
          return this._peso / 1000
      }
      get idPraImprimir(){
        return this.id
      }
    }