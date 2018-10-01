class Pokemon { //classe usada para trabalhar os dados recebidos e ja parseados
      constructor( jsonVindoDaApi ) { //recebe os dados do main (res => res.json()) == parse
        this.nome = jsonVindoDaApi.name //construtor recebe os atributos que podem ser verificados na API
        this.id = jsonVindoDaApi.id 
        this.thumbUrl = jsonVindoDaApi.sprites.front_default
        this._altura = jsonVindoDaApi.height
        this._peso = jsonVindoDaApi.weight
        this.tipos = jsonVindoDaApi.types.map( t => t.type.name )
        this.estatis = jsonVindoDaApi.stats.map (n => n.stat.name)
        this.valorEstatis = jsonVindoDaApi.stats.map (j => j.base_stat)
      }
    

      // como a altura vem em dezenas de cm, estamos aplicando um cálculo para traduzir para cm
      get altura() {
        return this._altura * 10
      }

      get peso(){
          return this._peso / 1000
      }
    }
