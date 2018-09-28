function rodarPrograma() {
    
      // obtém elementos da tela para trabalhar com eles
      const $dadosPokemon = document.getElementById( 'dadosPokemon' ) //está chamando a div
      const $h1 = $dadosPokemon.querySelector( '#nome' ) //chamando o que está dentro da div, associando a ela
      const $h2 = $dadosPokemon.querySelector( '#altura' )
      const $h2a = $dadosPokemon.querySelector( '#peso' )
      const $h3 = $dadosPokemon.querySelector( '#id' )
      const $img = $dadosPokemon.querySelector( '#thumb' ) //tb dentro da div. está usando id pois pode haver mais de uma imagem
      const $txtIdPokemon = document.getElementById( 'txtNumero' ) //a id do pokemon, que é recebida do usuário, está sendo chamada pelo id
      // instanciando objeto de API que criamos para facilitar a comunicação
      const url = 'https://pokeapi.co/api/v2/pokemon' //declaração da url que contém a api
      const pokeApi = new PokeApi( url ) //instaniando o objeto que lida com a api

    
      // registrar evento de onblur
      //neste caso dentro  do onblur foi colocado a função de busca, para que ela aconteça quando clicar for do input sem usar botão
      $txtIdPokemon.onblur = function() { //onblur para quando vc clica fora da área de digitacao. chamando no input
        const idDigitado = $txtIdPokemon.value //variável recebida sendo colocar em uma const
        if (isNumber(idDigitado) == true){
        pokeApi.buscar( idDigitado ) //função de busca sendo chamada do arquivo que fala com o servidor. sendo passada o parametro de busca que foi digitado
            .then( res => res.json() ) //segura a fetch que está voltando em string e passando para JSON
            .then( dadosJson => { //segura os dados JSON e coloca parâmetros que irao tratar dele
            const pokemon = new Pokemon( dadosJson ) //instanciando objeto do tipo JSON e já alimentando com os dados do objeto filtrado
            renderizarPokemonNaTela( pokemon ) //função que imprime o pokemon criado com JSON
            })
        }
        if (isNumber(idDigitado) == false ) alert ("Digite um id Válido")
        }
     

    function isNumber(idDigitado) {
        return !isNaN(parseFloat(idDigitado)) && isFinite(idDigitado);
    }

 //primeiro eu achei que essa função seria boa de estar na pokemon.js porque lida com os dados em JSON. 
 //trabalha estes dados. mas na verdade ela está aqui porque o objetivo principal dela é colocar estes dados 
 //nos elementos do html para mostrar ao usuário
 function renderizarPokemonNaTela( pokemon ) { 
    $h1.innerText = "Nome: " + pokemon.nome //colocando o nome do poke no h1
    $h2.innerText = "Altura: " + (pokemon.altura)
    $h2a.innerText = "Peso: " + (pokemon.peso)
    $h3.innerText = "ID: " + (pokemon.idPraImprimir)
    $img.src = pokemon.thumbUrl //pokemon.alguma coisa poderia chamar qualquer das variáveis contidas no JSON
  }

}

rodarPrograma()