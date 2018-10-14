package classes;
public class Aluno extends Pessoa {
	private long matricula;
	private Cpf cpf;

	public Aluno(){}
	public Aluno(String nome, String telefone, String endereco, long matricula, Cpf cpf) {
		super(nome, telefone, endereco);
		this.matricula = matricula;
		this.cpf = cpf;
	}
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	public Cpf getCpf() {
		return cpf;
	}
	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}
	@Override
	public String toString() {
		return super.toString() + "Aluno [matricula=" + matricula + "]" + (cpf!=null?cpf.toString():"Cpf inv�lido!");
	}
}
