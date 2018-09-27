  class Relogio {
    constructor(){
      this._clock = new Date().toLocaleTimeString()

      this.iniciar = function(){
         meuH1.innerText = new Date().toLocaleTimeString()
      }
      this.parar = function(){
        clearInterval(idInterval)
        btnReiniciar.disabled = true
      }
    }
  }
