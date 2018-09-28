const urlApi= 'https://pokeapi.co/api/v2/pokemon/'
const pokeApi = new PokeApi( urlApi )

let app = new Vue ({
  el: '#meuPrimeiroApp',
  data: {
    idParaBuscar: '',
    pokemon: {}
  },
  methods: {
    async buscar(){
      this.pokemon = await pokeApi.buscar(this.idParaBuscar)
    }
        
    //buscar(){
      //console.log(this.idParaBuscar)
      // PokeApi.buscar(this.idParaBuscar)
      //   .then( j => j.json())
      //   .then( p => {
      //       this.pokemon = new Pokemon( p )
      //   })
  
}
})

