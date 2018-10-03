export default class Pokemon {
    constructor( jsonVindoDaApi ) {
      this.nome = jsonVindoDaApi.name
      this.id = jsonVindoDaApi.id
      this.thumbUrl = jsonVindoDaApi.sprites.front_default
      this._altura = jsonVindoDaApi.height
      this.tipos = jsonVindoDaApi.types.map( t => t.type.name )
    }
  
    // como a altura vem em dezenas de cm, estamos aplicando um cálculo para traduzir para cm
    get altura() {
      return this._altura * 10
    }
  }
  