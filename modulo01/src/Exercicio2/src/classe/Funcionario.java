package classe;

/*Exercício 02

Crie uma classe Funcionario que receba, na criação, um nome, 
um valor de salário fixo (double) e outro valor 
que é o total de vendas no mês de um vendedor (double), respectivamente. 
Sabemos que devemos retirar 10% do salário fixo para impostos 
e que o vendedor recebe 15% de comissão de suas vendas, 
mas que também devemos diminuir 10% em cima do valor líquido recebido nas comissões, 
pois o governo precisa arrecadar impostos. 
Seu objetivo é calcular o lucro total do vendedor ao final do mês. 
Exemplo:
	new Funcionario(“Capitão América”, 500.0, 1000.0).getLucro() // 585.0
new Funcionario(“Rogue”, 500.0, 7840.50).getLucro() // 1508.4675
*/

public class Funcionario {
	private String nome;
	private double salarioFixo;
	private double totalVendas;
	
	public Funcionario (String nomeInformado, double salarioInformado, double totalVendido) {
		this.nome = nomeInformado;
		this.salarioFixo = salarioInformado;
		this.totalVendas = totalVendido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalarioFixo() {
		return salarioFixo;
	}

	public void setSalarioFixo(double salarioFixo) {
		this.salarioFixo = salarioFixo;
	}

	public double getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(double totalVendas) {
		this.totalVendas = totalVendas;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", salarioFixo=" + salarioFixo + ", totalVendas=" + totalVendas + "]";
	}

	public double getLucro() {
		return ((salarioFixo + (totalVendas*0.15))*0.9) ;
	}
	
}
