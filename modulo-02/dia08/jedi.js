class Jedi {
  constructor(nome) {
    this.nome = nome

    const h1 = document.createElement('h1')
    h1.innerText = this.nome
    h1.id = `jedi_${ this.nome }`
    const dadosJedi = document.getElementById( 'dadosJedi')
    dadosJedi.appendChild(h1)
  }

  atacar(){
    //const h1 = document.getElementById(`jedi_${this.nome}`)
    let self = this
    setTimeout ( function(){
      self.h1.innerText += ' atacou!'
    }, 1000)
  }

  atacar(){
    setTimeout ( () => {
      self.h1.innerText += ' atacou!'
    }, 1000)
  }
}
