public class Dwarf {
    private String nome;
    private Status status = Status.VIVO;
    private double vida = 110.0;
    private final double QTD_DANO = 10.0;
    
    public Dwarf(String nome) {
        this.nome = nome;
    }
    
    public void perderVida() {
        vida -= this.vida >= QTD_DANO ? QTD_DANO : 0;
        if (vida == 0.0) {
            this.status = Status.MORTO;
        }
    }
    
    public double getVida() {
        return this.vida;
    }
    
    public Status getStatus() {
        return this.status;
    }
}