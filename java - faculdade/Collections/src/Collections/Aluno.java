package Collections;


public class Aluno extends Pessoa implements Comparable<Object> {
	private long matricula;
	private Cpf cpf;

	@Override
	public int compareTo(Object obj) {
		Aluno param = (Aluno) obj;
		if (this.matricula==param.getMatricula()) return 0;
		if (this.matricula>=param.getMatricula()) return 1;
		return -1;
	}
	
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
		return super.toString() + "Aluno: matricula: " + matricula + ". " + (cpf!=null?cpf.toString():"Cpf inv�lido!");
	}
	
	

}