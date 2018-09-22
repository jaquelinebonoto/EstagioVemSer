/*Crie uma função "calcularCirculo" que receba um objeto com os seguintes parâmetros:{
    		raio, // raio da circunferência
    		tipoCalculo // se for "A" cálcula a área, se for "C" calcula a circunferência }*/
    
const objeto = {
    raio: 4,
    tipoCalculo: "A",
    calcularCirculo
}    
const objeto2 = {
    raio: 2,
    tipoCalculo: "B",
    calcularCirculo
}   
const objeto3 = { //teste para valor negativo (não deve pasasr para função inválida)
    raio: -1,
    tipoCalculo: 3,
    calcularCirculo
}
const objeto4 = { //teste para função invalida
    raio: 0,
    tipoCalculo: 3,
    calcularCirculo
}
function calcularCirculo (circulo) {
    if (this.raio<0) return console.log("Informe um valor positivo para raio.");
    if (this.tipoCalculo==="A"){
        return (Math.PI * Math.pow(this.raio, 2))
    }
    if (this.tipoCalculo==="B"){
        circunferencia = 2*Math.PI*this.raio;
        return(circunferencia);
    }
    else (console.log("Função informada inválida"));
}
console.log(objeto.calcularCirculo(objeto));
console.log(objeto2.calcularCirculo(objeto2));
console.log(objeto3.calcularCirculo(objeto3));
console.log(objeto4.calcularCirculo(objeto4));

console.log("------------------------------------------------------------------");
/*Crie uma função naoBissexto que recebe um ano (número) e verifica se ele não é bissexto. Exemplo:
	bissexto(2016) // false
    bissexto(2017) // true */
    
    var ano2016 = {
        dias: 366,
        naoBissexto
    }

    var ano2018 = {
        dias: 365,
        naoBissexto
    }
    function naoBissexto (ano){
        if (this.dias === 366) return true;
        return false;
    }
    console.log("Ano 2016 é bissexto?   " + ano2016.naoBissexto(ano2016));
    console.log("Ano 2018 é bissexto?   " + ano2018.naoBissexto(ano2018));
    
    console.log("------------------------------------------------------------------");
    
    /*Crie uma função concatenarSemUndefined que recebe duas variáveis. Caso qualquer uma delas seja undefined (cuide a melhor forma de verificar isso, foi visto em aula), considere “” no lugar. Exemplo:

	concatenarSemUndefined( undefined, “Soja” ) // “Soja”
	concatenarSemUndefined( “Soja”, “ é bom” ) // “Soja é bom”
    concatenarSemUndefined( “Soja é” ) // “Soja é”*/
    
    
