
public class Funcionario
{
	private String nome;
	private double salarioFixo;
	private double totalVendas;
	
	public Funcionario (String nomeInformado, double salarioInformado, double totalVendido) {
		this.nome = nomeInformado;
		this.salarioFixo = salarioInformado;
		this.totalVendas = totalVendido;
	}


 	public double getLucro() {
		return ((salarioFixo + (totalVendas*0.15))*0.9) ;
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
}
