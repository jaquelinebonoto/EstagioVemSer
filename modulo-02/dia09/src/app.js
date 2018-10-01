const urlApi= 'https://pokeapi.co/api/v2/pokemon/'
const pokeApi = new PokeApi( urlApi )



let app = new Vue ({
  el: '#meuPrimeiroApp',
  data: {
    idParaBuscar:'',
    pokemon: {}
  },
  methods: {
    async buscar(){
      if (!isNaN(parseFloat(this.idParaBuscar)) && isFinite(this.idParaBuscar)) this.pokemon = await pokeApi.buscar(this.idParaBuscar)
      else alert ("Digite um id Válido")   
    }

}
})
