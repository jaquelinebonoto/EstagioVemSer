public class Dwarf {
    private Atributos atributos;
    private final double QTD_DANO = 10.0;
    
    public Dwarf(String nome) {
        this.atributos = new Atributos(nome, 110.0, Status.VIVO);
    }
    
    public void perderVida() {
        double dano = this.atributos.getVida() >= QTD_DANO ? QTD_DANO : 0;
        double vida = this.atributos.getVida() - dano;
        this.atributos.setVida(vida);
        if (vida == 0.0) {
            this.atributos.setStatus(Status.MORTO);
        }
    }
    
    public double getVida() {
        return this.atributos.getVida();
    }
    
    public Status getStatus() {
        return this.atributos.getStatus();
    }
}