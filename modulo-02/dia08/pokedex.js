

function rodarPrograma(){

  const $dadosPokemon = document.getElementById('dadosPokemon')
  const $h1 = $dadosPokemon.querySelector('h1')
  const $img = $dadosPokemon.querySelector('#thumb')
  const campo = $dadosPokemon.querySelector('#numeropokemon')

  let url = `https://pokeapi.co/api/v2/pokemon/${campo.value}/` //recurso a ser consumido
  var requisicao = fetch(url) //disparou a requisição e seguiu com a execução do programa
  
  requisicao
    .then (res=> res.json() //res será uma string, faremos o parse para JSON
    .then (dadosJson =>{
      console.log (dadosJson)
      $h1.innerText = dadosJson.name
      $img.src = dadosJson.sprites.front_default
    } )
  )
}
rodarPrograma()
