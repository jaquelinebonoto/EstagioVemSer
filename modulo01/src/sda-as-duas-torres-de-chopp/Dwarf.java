public class Dwarf {
    private String nome;
    private Status status = Status.VIVO;
    private double vida = 110.0;
    
    public Dwarf(String nome) {
        this.nome = nome;
    }
    
    public void perderVida() {
        vida -= 10.0;
    }
    
    public double getVida() {
        return this.vida;
    }
    
    public Status getStatus() {
        return this.status;
    }
}