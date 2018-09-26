const meuH2 = document.getElementById( 'tituloPagina' )

function perguntarNome() {
  var nome = prompt( 'Qual seu nome?' )
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

meuH3.innerText = "Numero de Clicks: " + count
//meuH2.innerText = 'Carregando...'

//localStorage['nome'] = nome
//localStorage.setItem( 'nome', nome )

const button = document.getElementsByTagName("button")
const meuH3 = document.getElementById('numeroDeClick')
var count = 0
sessionStorage.setItem(count)

function contaClicks (){
    count +=1
    sessionStorage.setItem(count)
    meuH3.innerText = "Numero de Clicks: " + count
    if (count < 5){
        localStorage.removeItem("nome")
        meuH2.innerText = "Nome Vazio"
        alert("Item removido.");
    }
}
