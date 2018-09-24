describe( 'calcularCirculo', function() {

  // antes de cada teste, chama a biblioteca "chai" para poder usar as asserções de forma mais amigável (should, expect)
  // documentação: https://www.chaijs.com/
  beforeEach( function() {
    chai.should()
  } )

  // cada bloco "it" é um cenário de teste, como se fosse um @Test do JUnit
  // importante: garanta que o arquivo onde o código está implementado foi incluído, em rodar-testes.html
  /*it( 'deve calcular área de raio 1', function() {
    const raio = 1, tipoCalculo = 'A'
    const resultado = calcularCirculo( { raio, tipoCalculo } )
    resultado.should.equal( Math.PI )
  } )*/

    // isso é um cenário pendente, é preciso implementar o código no segundo parâmetro, que é uma function.
    it( 'deve calcular área de raio 4', function() {
      const resultado = objeto.calcularCirculo(objeto)
      resultado.should.equal(50.26548245743669)
    } )

    it( 'deve calcular circunferência de raio 2', function() {
      const resultado = objeto2.calcularCirculo(objeto2)
      resultado.should.equal(12.566370614359172)
    } )

    it( 'deve retornar erro ao tentar calcular valor negativo', function() {
      const resultado = objeto3.calcularCirculo(objeto3)
      const tipoResultado = typeof resultado
      tipoResultado.should.equal('undefined')
    } )
})
