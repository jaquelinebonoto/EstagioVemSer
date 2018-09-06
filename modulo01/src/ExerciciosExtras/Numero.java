public class Numero {
    private int numero;
    
    public Numero(int numero) {
        this.numero = numero;
    }
    
    public boolean impar() {
        return numero % 2 == 1;
    }
    
    public boolean verificarSomaDivisivel(int numeroDivisor) {
        if (numeroDivisor == 0) return true;
        int soma = 0;
        while (numeroDivisor != 0) {
            soma += numeroDivisor % 10;
            numeroDivisor /= 10;
        }
        return soma % this.numero == 0;
    }
}