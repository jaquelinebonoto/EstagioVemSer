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

function formatarElfos (objetos){
    //for (var i=0; i<=objetos.length-1; i++){
    objetos.forEach (nome => porNoCaps(objetos))
    return objetos
}


    /*for (var i=0; i<=objetos.length-1; i++){
        function nomeMaiusculo(objetos){
            objetos[i].nome = objetos.nome.toUpperCase()
        }
        /*function experience(experiencia){
            if (objetos.experiencia<=0)
                temExperiencia = false
            else temExperiencia= true
            return experiencia=temExperiencia
        }*/
       // function descricao()
    //}


