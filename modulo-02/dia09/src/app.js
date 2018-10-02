const urlApi= 'https://pokeapi.co/api/v2/pokemon/'
const pokeApi = new PokeApi( urlApi )



let app = new Vue ({
  el: '#meuPrimeiroApp',
  data: {
    idParaBuscar:'',
    pokemon: {}
  },
  methods: {
    async buscar(idParaBuscar){
      this.pokemon = await pokeApi.buscar(idParaBuscar)
    },
    
    validaId () {
       if (!isNaN(parseFloat(this.idParaBuscar)) && isFinite(this.idParaBuscar)) this.buscar(this.idParaBuscar)    
       else alert ("Digite um id Válido")
    },

    idAleatorio (){
      let idParaBuscar = Math.floor(Math.random() * (820 - 1 + 1)) 
      this.buscar(idParaBuscar)
    }

}
})
