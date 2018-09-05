package classe;


/*Exercício 01

Escreva um método impar, na classe Numero, que retorne true caso o número da
instância seja ímpar e false caso contrário. 
Exemplo:
	new Numero(5).impar(); // true
	new Numero(27).impar(); // true
	new Numero(2018).impar(); // false */

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
	
	/*Na classe Numero, adicione um método de instância chamado verificarSomaDivisivel, que recebe um número inteiro por parâmetro e retorne:
	
	true (verdadeiro) caso a soma de todos dígitos do número informado por parâmetro seja 0 ou múltiplo do número do objeto.
	false (falso) para todos outros casos. */

	public boolean verificarSomaDivisivel (int number) {
		int i=100000;
		int soma=0;
		if (numero<=999999) {
			while (i>=0) {
			soma = (numero/i) + soma;
			i=i/10;
			}if (soma%numero==0 || soma==0){
				return true;
			}
		}
		else{
			return false;
		}
		return false;
	}

	public int getNumero() {
		return numero;
	}
	
}