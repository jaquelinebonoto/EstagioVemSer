package classe;

/*Exerc�cio 04
Na classe Elfo, adicione um atributo qtdFlechas (inteiro), que comece com o valor 7 e outro campo experiencia (inteiro), 
que come�a com 0. Tamb�m adicione um m�todo atirarFlecha que diminui a quantidade atual de flechas do elfo a cada 
chamada e aumente a experi�ncia. 
Seja cuidadoso com os casos de teste e evite situa��es que n�o fazem sentido.*/

public class Elfo {
	private String nome;
	private int qtdFlechas=7;
	private int experiencia=0;
	
	public Elfo (String nomeElfo, int totalFlechas, int nivelExperiencia) {
		this.setNome(nomeElfo);
		this.setQtdFlechas(totalFlechas);
		this.experiencia = nivelExperiencia;
	}
	
	public int atirarFlecha(int qtdFlechas) {
		getExperiencia();
		return qtdFlechas--;
	}
	
	public int getExperiencia () {
		return experiencia++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdFlechas() {
		return qtdFlechas;
	}

	public void setQtdFlechas(int qtdFlechas) {
		this.qtdFlechas = qtdFlechas;
	}
	
	
}
