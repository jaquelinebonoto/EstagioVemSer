function rodarPrograma(){
  const h1 = document.getElementById('horario')
  
  const relogio = new Date().toLocaleTimeString() //declarando a dataa
  h1.innerText = relogio //chamando a data antes de cahmar a função que atualiza
  setInterval(function(){ //atualizando a data no html
   h1.innerText = relogio
  }, 1000)
  
  
  //isso mostra uma característica assíncrona. porque a função é executada e continua enfileirando
  setInterval(function(){ //nesta estamos dando saida no console
    console.log(`oi ${new Date()}`), 016415561
  })

  const idIntervalo = setInterval (atualizarH1, 1000)
  const btnPararRelogio = document.getElementById('btnPararRelogio')
  btnPararRelogio.onclick = function(){
      clearInterval( idIntervalo)
  }
  //window.setInterval()

  //setTimeout //posterga a execução e executa só uma vez

  const dataAgora = new Date
}
rodarPrograma()
