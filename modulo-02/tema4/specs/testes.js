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

    describe( 'formatarElfosSoNome', function() {
        beforeEach( function() {
            chai.should()
          } )
          const expect = chai.expect
    
          const elfo3 = { nome: "LEGOLAS", experiencia: 0, qtdFlechas: 6 }
          const elfo4 = { nome: "GALADRIEL", experiencia: 1, qtdFlechas: 1 }
          const arrayEsperado = [ elfo3, elfo4]

          const elfo1 = { nome: "Legolas", experiencia: 0, qtdFlechas: 6 }
          const elfo2 = { nome: "Galadriel", experiencia: 1, qtdFlechas: 1 }
          const arrayElfos = [ elfo1, elfo2]

        it( 'deve retornar os nomes em Caps Lock usando Array', function() {
            var result = {}
            result = formatarElfosSoNome(arrayElfos)
            expect(result).to.eql(arrayEsperado);
        })
      })


  describe( 'formatarElfosNomeExperiencia', function() {
          beforeEach( function() {
          chai.should()
          } )
          const expect = chai.expect
          
          const elfo3 = { nome: "LEGOLAS", temExperiencia: false}
          const elfo4 = { nome: "GALADRIEL", temExperiencia: true}
          const arrayEsperado2 = [ elfo3, elfo4]

        it( 'deve retornar nome em Caps e experiencia TRUE or FALSE', function() {
          var result = formatarElfosNomeExperiencia(arrayElfos)
          expect(result).to.eql(arrayEsperado2);
        }) 
    })

    describe( 'formatarElfos', function() {
      beforeEach( function() {
      chai.should()
      } )
      const expect = chai.expect

      const elfo3 = { nome: "LEGOLAS", temExperiencia: false, qtdFlechas: 6}
      const elfo4 = { nome: "GALADRIEL", temExperiencia: true, qtdFlechas: 1}
      const arrayEsperado3 = [ elfo3, elfo4]

    it( 'deve retornar nome/experiencia/qtdflechas no mesmo objeto', function() {
      var result = formatarElfos(arrayElfos)
      expect(result).to.eql(arrayEsperado3);
    }) 
})
