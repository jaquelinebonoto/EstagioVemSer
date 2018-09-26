const meuH2 = document.getElementById( 'tituloPagina' )

function perguntarNome() {
  const nome = prompt( 'Qual seu nome?' )
  meuH2.innerText = nome
  localStorage.nome = nome
}

function renderizaNomeArmazenadoNaTela() {
  meuH2.innerText = localStorage.nome
}

const nomeArmazenado = localStorage.nome && localStorage.nome.length > 0
if ( nomeArmazenado ) {
  renderizaNomeArmazenadoNaTela()
} else {
  perguntarNome()
}

const meuH3 = document.getElementById('numeroClicks')
const btn = document.getElementById('btn')
var count = 0


btn.onclick = function() {
    count++
    meuH3.innerText = "Numero de Clicks " + count
    if (count<5){
      localStorage.removeItem('nome')
      meuH2.innerText = "Nome Removido"
      alert("Item removido")
    }
}

function apagaMesmo(){
  localStorage.removeItem('nome')
}

//meuH2.innerText = 'Carregando...'

//localStorage['nome'] = nome
//localStorage.setItem( 'nome', nome )
