package classe;


/*Exerc�cio 01

Escreva um m�todo impar, na classe Numero, que retorne true caso o n�mero da
inst�ncia seja �mpar e false caso contr�rio. 
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
	
	/*Na classe Numero, adicione um m�todo de inst�ncia chamado verificarSomaDivisivel, que recebe um n�mero inteiro por par�metro e retorne:
	
	true (verdadeiro) caso a soma de todos d�gitos do n�mero informado por par�metro seja 0 ou m�ltiplo do n�mero do objeto.
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