public class Dwarf {
    private String nome;
    private Status status = Status.VIVO;
    private double vida = 110.0;
    private final double DANO = 10.0;
    
    public Dwarf(String nome) {
        this.nome = nome;
    }
    
    public void perderVida() {
        if(status == Status.VIVO) vida -= DANO;
        updateStatus();
    }
    
    public double getVida() {
        return this.vida;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public Status updateStatus (){
        if (getVida()==0.0) status = Status.MORTO;
        return status;
    }
}
