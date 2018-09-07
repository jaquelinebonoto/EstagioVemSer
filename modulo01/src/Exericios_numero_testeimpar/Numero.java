public class Numero {
    private int numero;
    
    public Numero(int number) {
        this.numero =number ;
    }
    
    public boolean impar () {
        if (numero %2 == 1) {
            return true;
        }else {
            return false;
        }
    }
    
    public boolean verificarSomaDivisivel (int number) {
        if (number==0);    
        int soma=0;
        while (number>0) {
            soma = soma +number%10;
            number = number/10;
        }
        return soma%this.numero==0;
    }

    public int getNumero() {
        return numero;
    }
    
}