package aula7;

public class Aluno extends Pessoa implements Comparable {

    private long matricula;
    private Cpf cpf;

    @Override
    public int compareTo(Object obj) {
        //primeiro conver o obj para um objeto do tipo Aluno
        Aluno aluno = (Aluno) obj;
        //A partir do objetos passado como parâmetro pega o Cpf
        Cpf cpfAluno = aluno.getCpf();
        //compara os Cpf dos objetos
        return this.getCpf().compareTo(cpfAluno);
    }

    public Aluno() {
    }

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
        return super.toString() + "Aluno [matricula=" + matricula + "]" + (cpf != null ? cpf.toString() : "Cpf inv�lido!");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.matricula ^ (this.matricula >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.matricula != other.matricula) {
            return false;
        }
        return true;
    }



    
}
