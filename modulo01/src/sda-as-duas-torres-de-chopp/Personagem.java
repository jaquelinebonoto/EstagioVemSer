public class Personagem {
    protected String nome;
    protected double vida;
    protected Status status;
    
    public Personagem(String nome, double vida, Status status) {
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