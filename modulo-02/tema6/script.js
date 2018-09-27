const meuH1 = document.getElementById('relogio')
const btnParar = document.getElementById('btnParar')
const btnReiniciar = document.getElementById('btnReiniciar')

function rodarPrograma(){
  const meuRelogio = new Relogio()
  meuRelogio.iniciar()
  const idInterval = setInterval(meuRelogio.iniciar, 1000)
  btnParar.onclick = meuRelogio.parar
  btnReiniciar.onclick = meuRelogio.iniciar
}
rodarPrograma()
