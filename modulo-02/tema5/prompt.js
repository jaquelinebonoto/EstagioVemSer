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


//meuH2.innerText = 'Carregando...'

//localStorage['nome'] = nome
//localStorage.setItem( 'nome', nome )

const button = document.getElementsByTagName("button")
function limpaDados (){
    localStorage.removeItem("nome")
    //localStorage.clear()
    meuH2.innerText = "Nome Vazio"
    alert("Item removido.");
}
