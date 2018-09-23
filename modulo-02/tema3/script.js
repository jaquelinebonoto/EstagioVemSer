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
    
    /*Crie uma função concatenarSemUndefined que recebe duas variáveis. 
    Caso qualquer uma delas seja undefined 
    (cuide a melhor forma de verificar isso, foi visto em aula), 
    considere “” no lugar. Exemplo:

	concatenarSemUndefined( undefined, “Soja” ) // “Soja”
	concatenarSemUndefined( “Soja”, “ é bom” ) // “Soja é bom”
    concatenarSemUndefined( “Soja é” ) // “Soja é”*/
    
    var coiso = {
        name: "coisa",
        concatenarSemUndefined
    }
    var coisaSeria = {
        name: " cousaSeria",
        concatenarSemUndefined
    }  
    var doida = {
        name: " doida",
        concatenarSemUndefined
    }
    
    function concatenarSemUndefined (nome, outroNome){
        if (nome === undefined){
            console.log(""+outroNome);
        } else if (outroNome === undefined){
            console.log(nome+""); 
        } else console.log(nome + outroNome);
    }

    function testePraDarErrado (circulo) {
        if (this.tipoCalculo==="A"){
            return (Math.PI * Math.pow(this.raio, 2))
        }
    }

    coiso.concatenarSemUndefined(coiso.name, coisaSeria.name);
    coiso.concatenarSemUndefined(coiso.name, doida.name);
    coiso.concatenarSemUndefined(coiso.name, testePraDarErrado(doida));
    coiso.concatenarSemUndefined(testePraDarErrado(doida), doida.name);

    console.log("------------------------------------------------------------------");

    /*Crie uma função concatenarSemNull que recebe duas variáveis. Caso qualquer uma delas seja null (cuide a melhor forma de verificar isso, foi visto em aula), considere “” no lugar. Exemplo:

	concatenarSemNull( null, “Soja” ) // “Soja”
	concatenarSemNull( “Soja”, “ é bom” ) // “Soja é bom”
    concatenarSemNull( “Soja é” ) // “Soja éundefined”*/
    
    var coiso = {
        name: "coisa",
        concatenarSemNull
    }
    var coisaSeria = {
        name: " cousaSeria",
        concatenarSemNull
    }  
    var doida = {
        name: " doida",
        concatenarSemNull
    }

    function concatenarSemNull (nome, outroNome){
        if (nome === null){
            console.log(""+outroNome);
        } else if (outroNome === null){
            console.log(nome+""); 
        } else console.log(nome + outroNome);
    }

    function concatenarSemUndefined (nome, outroNome){
        if (nome === undefined){
            console.log(""+outroNome);
        } else if (outroNome === undefined){
            console.log(nome+""); 
        } else console.log(nome + outroNome);
    }

    function testePraDarErrado (circulo) {
        if (this.tipoCalculo==="A"){
            return (Math.PI * Math.pow(this.raio, 2))
        }
    }
    var foo = null;
    coiso.concatenarSemNull(coiso.name, coisaSeria.name);
    coiso.concatenarSemNull(coiso.name, doida.name);
    coiso.concatenarSemNull(coiso.name, foo);
    coiso.concatenarSemNull(foo, doida.name);
    coiso.concatenarSemNull(testePraDarErrado(doida), doida.name);
    

    console.log("------------------------------------------------------------------");

    /*Crie uma função concatenarEmPaz que recebe duas variáveis. 
    Caso qualquer uma delas seja null ou undefined (cuide a melhor forma de verificar isso,
    foi visto em aula), considere “” no lugar. Exemplo

	concatenarEmPaz( undefined, “Soja” ) // “Soja”
	concatenarEmPaz( “Soja é bom, mas...”, null ) // “Soja é bom, mas...”
    concatenarEmPaz( “Soja é” ) // “Soja é”*/
    
    var coiso = {
        name: "coisa",
        concatenarEmPaz
    }
    var coisaSeria = {
        name: " cousaSeria",
        concatenarEmPaz
    }  
    var doida = {
        name: " doida",
        concatenarEmPaz
    }
    function concatenarEmPaz (nome, outroNome){
        if (nome === null || nome === undefined){
            console.log(""+outroNome);
        } else if (outroNome === null || outroNome === undefined){
            console.log(nome+""); 
        } else console.log(nome + outroNome);
    }

    coiso.concatenarEmPaz(coiso.name, coisaSeria.name);
    coiso.concatenarEmPaz(coiso.name, doida.name);
    coiso.concatenarEmPaz(coiso.name, foo);
    coiso.concatenarEmPaz(foo, doida.name);
    coiso.concatenarEmPaz(testePraDarErrado(doida), doida.name);

    console.log("------------------------------------------------------------------");
    /*Escreva uma função adicionar que permite somar dois números através de duas 
    chamadas diferentes (não necessariamente pra mesma função). Pirou? Ex:
    adicionar(3)(4) // 7       adicionar(5642)(8749) // 14391*/

    function adicionar (a, b) {
        return a + b;
      }
      
    console.log(adicionar(3, 4));
    console.log(adicionar(5642, 8749));
    console.log(adicionar(-12, 4));
    console.log(adicionar(0, -1));

    console.log("------------------------------------------------------------------");
    /*Faça uma função fiboSum que calcule a soma da sequência de Fibonacci para n números informados. Exemplo de chamada:
    fiboSum(7)  // 33 (soma dos 7 primeiros números da sequência: 1+1+2+3+5+8+13)
    Dica: aproveite toda "beleza" dos algoritmos recursivos (com cuidado). */

    function fiboSum (numero){ //somando os valores até chegar no valor 7
        if (numero==0) return 0;
        if (numero==1) return 1;
        return fiboSum(numero-1) + fiboSum (numero-2);
    }
    
    console.log(fiboSum(7));
    console.log(fiboSum(33));

    var soma=1;
    var outro=0;
    function fiboSoma (numero){ //somando os valores até ter 7 valores
        for (i=1; i<=numero; i++){
            soma = soma + (numero-1) + numero-2;
        }
        return soma;
    }
    console.log(fiboSoma(7));