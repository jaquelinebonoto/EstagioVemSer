public class Numero {
    private int numero;
    
    public Numero(int numero) {
        this.numero = numero;
    }
    
    public boolean impar() {
        return numero % 2 == 1;
    }
}