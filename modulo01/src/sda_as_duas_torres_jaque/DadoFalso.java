public class DadoFalso implements Sorteador {
    
    private int valorFalso;
    
    public void simularValor(int valor) { //recebe o valor que iremos testar
        this.valorFalso = valor;
    }
    
    public int sortear() { //implementa o método sortear da interface. retorna o valor falso informado
        return this.valorFalso;
    }
}