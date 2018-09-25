/*Crie uma função somarPosiçãoPares que recebe um array de números 
(não precisa fazer validação) e soma todos números nas posições pares do array, exemplo:
somarPares( [ 1, 56, 4.34, 6, -2 ] ) // 3.34 */

const numeros = {
    vetor: [1, 56, 4.34, 6, -2],
    somarPosicaoPares,
    somarPosicao
} 

function somarPosicao (vetor){
    var soma=0
    for (var i=0; i<=numeros.vetor.length-1; i++){
        soma = soma + numeros.vetor[i]
    }
    return soma
}

function somarPosicaoPares (vetor){
    var soma=0
    for (var i=0; i<=numeros.vetor.length-1; i++){
        if (i%2==0) {soma = soma + numeros.vetor[i]}
    }
    return soma
}

/*Crie uma função formatarElfos que recebe um array de objetos e retorna o mesmo array com as 
seguintes transformações de campos:

	const elfo1 = { nome: “Legolas”, experiencia: 0, qtdFlechas: 6 }
	const elfo2 = { nome: “Galadriel”, experiencia: 1, qtdFlechas: 1 }
	const arrayElfos = [ elfo1, elfo2 ]
	formatarElfos( [ elfo1, elfo 2 ] ) // retorna o seguinte array:

	[
		{
			nome: “LEGOLAS”,
			temExperiencia: false,
			qtdFlechas: 6,
			descricao: “LEGOLAS sem experiência e com 6 flechas”
		},
		{
			nome: “GALADRIEL”,
			temExperiencia: true,
			qtdFlechas: 1,
			descricao: “GALADRIEL com experiência e 1 flecha”
		}
]*/

const elfo1 = { nome: "Legolas", experiencia: 0, qtdFlechas: 6 }
const elfo2 = { nome: "Galadriel", experiencia: 1, qtdFlechas: 1 }
const arrayElfos = [ elfo1, elfo2]

function repassar (objetos){
   return objetos
}


function porNoCaps (nome){
    nome = nome.toUpperCase()
    return nome
}

function verificaExperienica (experiencia){
    if (experiencia<=0) return false
    return true
}

function verificaExperienciaRetornaString (experiencia){
    if (experiencia<=0) return "sem" 
    return "com"
}

function formatarElfosSoNome (objetos){
    function porNoCaps (objetos){
        objetos.nome = objetos.nome.toUpperCase()
        return objetos
    }
    objetos.forEach (objetos => porNoCaps(objetos))
    return objetos
}

function formatarElfosNomeExperiencia (objetos){
  var elfo1 = {nome:" ", temExperiencia: true}
  var elfo2 = {nome:" ", temExperiencia: true}
  var novoArray = [elfo1, elfo2]
  
  var i=0
  function porNoCaps (objetos){
      novoArray[i].nome = objetos.nome.toUpperCase()
      i++
      return novoArray
  }
  objetos.forEach (objetos => porNoCaps(objetos))

  var j=0
  function verificaExperiencia (objetos){
    if (objetos.experiencia<=0) novoArray[j].temExperiencia = false
    j++
    return novoArray
  }
  objetos.forEach (objetos => verificaExperiencia(objetos))
  return novoArray
}




function formatarElfos (objetos){
  function porNoCaps (objeto){
      objeto.nome = objeto.nome.toUpperCase()
  }
  objetos.forEach (objeto => porNoCaps(objeto))

  function verificaExperiencia (objeto){
    if (objeto.experiencia<=0) objeto.temExperiencia = false
  }
  objetos.forEach (objeto => verificaExperiencia(objeto))
   
  const textoExperiencia = objetos.temExperiencia  ? 'com' : 'sem'
  const textoFlechas = objetos.qtdFlechas !== 1 ?  's' : ''
  elfo.descricao = `${ objeto.nome } ${textoExperiencia} experiencia e com ${qtdFlechas} flecha ${textoFlechas}`
  objetos.forEach (objeto => descricao(objeto))
  objetos.forEach (objeto => textoExperiencia(objeto))
  objetos.forEach (objeto => textoFlechas(objeto))

  delete objetos.experiencia
  return objetos
}
