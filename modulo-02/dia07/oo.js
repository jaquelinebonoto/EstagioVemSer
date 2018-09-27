// public class Elfo {
//   private String nome;

//   public Elfo(String nome) {
//     this.nome = nome;
//   }

//   public void setNome(String nome) {
//     this.nome = nome;
//   }

//   public String getNome() {
//     return this.nome;
//   }

//   public void atirarFlecha() {
//     //
//   }
// }
// Prototype:
// function Elfo(nome) {
//   this.nome = nome
// }

// Elfo.prototype.atirarFlecha = function() {
//   console.log(`alguma coisa`)
// }

class Personagem {
  constructor( nome ) {
    this._nome = nome
  }

  get nome() {
    return this._nome + " FUNGHI!!"
  }

  set nome( nome ) {
    document.getElementById( 'nome' ).innerText = nome
    this._nome = nome
  }
}


class Elfo extends Personagem {
  constructor( nome ) {
    super( nome )
    this.qtdFlechas = 7
  }

  static qtdElfos() {
    return 2
  }

  atirarFlecha() {
    console.log( `feitooo` )
  }
}
const galadriel = new Elfo( 'Galadriel' )


const legolas = new Elfo( 'Legolas' )
//legolas.nome = 'L'
console.log( legolas.nome )
legolas.atirarFlecha()

const feanor = new Elfo( 'Feanor' )
//feanor.nome = 'F'
console.log( feanor.nome )
feanor.atirarFlecha()

console.log( Elfo.qtdElfos() )


// diferente de:
