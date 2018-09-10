public class Atributos {
    private String nome;
    private double vida;
    private Status status;
    
    public Atributos(String nome, double vida, Status status) {
        this.nome = nome;
        this.vida = vida;
        this.status = status;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public double getVida() {
        return this.vida;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public void setVida(double vida) {
        this.vida = vida;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
}








