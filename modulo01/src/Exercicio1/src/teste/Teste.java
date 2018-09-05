package teste;
import classe.Numero;

public class Teste {
    public static void main(String[] args) {
    	
    	Numero num1 = new Numero (5);
    	Numero num2 = new Numero (27);
    	Numero num3 = new Numero (2018);
    	
    	num1.impar();
    	num2.impar();
    	num3.impar();
    	
    	new Numero(9).verificarSomaDivisivel(1892376); // true, 1+8+9+2+3+7+6 = 36
    	new Numero(3).verificarSomaDivisivel(17); // false, 1+7 = 8

    	
    }
}
