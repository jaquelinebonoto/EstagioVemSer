package lista1;

public class Curso {
    private String nome;
    private double duracao;
    private Data data;
    
    public Curso(){};
    
    public Curso(String nome, double duracao, Data data){
        this.nome = nome;
        this.duracao = duracao;
        this.data= data;
    }

    @Override
    public String toString() {
        return "Curso{" + "nome=" + nome + ", duracao=" + duracao + ", data=" + data.toString() + '}';
    }
    
    public String imprime(){
        return toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    
    
}
