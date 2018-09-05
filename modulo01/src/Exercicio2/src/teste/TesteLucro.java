package teste;

import classe.Funcionario;

public class TesteLucro {
    public static void main(String[] args) {
    	
    	Funcionario func1 = new Funcionario ("Carlos Alberto", 500.0, 1000.0);
    	Funcionario func2 = new Funcionario ("Orlando Bloom", 500.0, 7840.50);
    	
    	func1.getLucro();
    	func2.getLucro();
    	
    	func1.toString();
    }
}
