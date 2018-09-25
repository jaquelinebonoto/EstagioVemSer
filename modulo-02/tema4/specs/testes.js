describe( 'somarPosicao', function() {

    beforeEach( function() {
        chai.should()
      } )

      it( 'deve somar todo o array', function() {
        const resultado = numeros.somarPosicao(numeros)
        resultado.should.equal(65.34)
    } )

})

describe( 'somarPosicaoPares', function() {

        beforeEach( function() {
            chai.should()
          } )
    
          it( 'deve somar somente os valores nas posições pares', function() {
            const resultado = numeros.somarPosicaoPares(numeros)
            resultado.should.equal(3.34)
    } )
    
})

describe( 'repassar', function() {
    beforeEach( function() {
        chai.should()
      } )
      const expect = chai.expect
      
    it( 'deve receber e devolver o objeto array de elfos', function() {
        var result = {}
        result = repassar(arrayElfos)
        expect(result).to.eql(arrayElfos);
        //result.should.equal([elfo1, elfo2])
    })
})

describe( 'porNoCaps', function() {
    beforeEach( function() {
        chai.should()
      } )
      const expect = chai.expect
      
    it( 'deve inserir uma palavra e retornar a mesma em caixa alta', function() {
        var palavra = "word"
        var res = porNoCaps(palavra)
        expect(res).to.equal('WORD');
    })
})

describe( 'verificaExperiencia', function() {
    beforeEach( function() {
        chai.should()
      } )
      const expect = chai.expect
      
    it( 'deve inserir valor de experiencia 0 e retornar sem experiência (false)', function() {
        var experience = 0
        var res = verificaExperienica(experience)
        expect(res).to.be.false
    })

    it( 'deve inserir valor de experiencia 3 e retornar com experiência (true)', function() {
        var experience = 3
        var res = verificaExperienica(experience) 
        expect(res).to.equal(true)
    })
})

describe( 'verificaExperienciaRetornaString', function() {
    beforeEach( function() {
        chai.should()
      } )
      const expect = chai.expect

    it( 'deve inserir valor de experiencia 3 e retornar string com experiência', function() {
        var experience = 3
        var res = verificaExperienciaRetornaString(experience) + " experiência"
        expect(res).to.equal('com experiência');
    })

    it( 'deve inserir valor de experiencia -1 e retornar string sem experiência', function() {
        var experience = -1
        var res = verificaExperienciaRetornaString(experience) + " experiência"
        expect(res).to.equal('sem experiência');
    })
})