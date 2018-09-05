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
		int soma=0;
		int aux=numero;
		while (numero>0) {
			soma = soma +numero%10;
			numero = numero/10;
		}
		if (soma!=0 || soma%aux==0){
		    return true;
		}else{
			return false;
		}
	}

	public int getNumero() {
		return numero;
	}
	
}