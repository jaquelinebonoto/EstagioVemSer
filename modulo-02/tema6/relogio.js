function rodarPrograma(){
  //aqui vou fazer um relógio para ficar rodando.
  const meuH1 = document.getElementById('relogio') //batizando o conteúdo de h1 como meuH1
  const relogio = new Date().toLocaleTimeString() //adicionando a hora a variavel relogio
  meuH1.innerText = relogio //colocando o texto da hora no H1. chamamos antes da function pra que não leve um segundo para carregar
  setInterval (function(){ //função da window que faz com que a cada segundo seja buscada a hora
    meuH1.innerText = new Date().toLocaleTimeString()
  }, 1000)

  //aqui vou fazer um relógio para parar quando apertar o botão
  //nesta versão o contador do relógio estará montado um pouco diferente, em virtude de ser necessário 
  //captar o id da sessão iniciada para fazer ela parar.
  const meuH2 = document.getElementById('relogioParar')
  var atualizarH2 = function() { //função criada para colocar a data dentro do h2
    meuH2.innerText = new Date().toLocaleTimeString()
  }
  //setInterval(atualizarH2, 1000) //função da window que está recebendo a atualizar a cada 1s. será usada na linha abaixo.
  const idInterval = setInterval(atualizarH2, 1000) 
  atualizarH2() //chamada solta para evitar que o relógio não esteja disponível no primeiro segundo.

  const btnParar = document.getElementById('btnParar')
  var count = 0
  btnParar.onclick = function(){
    btnReiniciar.disabled = false
    if (count == 0) clearInterval(idInterval)
    if (count >= 1) clearInterval(idRecursivo)
    count++
  }

  //const idRecursivo = setInterval(atualizarH2Recursivo, 1000) 
  const btnReiniciar = document.getElementById('btnReiniciar')
  btnReiniciar.disabled = true
  btnReiniciar.onclick = function(){
    idRecursivo = setInterval(atualizarH2, 1000)
    atualizarH2()
    btnReiniciar.disabled = true
  }
}
rodarPrograma()
