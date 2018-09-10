public class Dwarf {
    private Atributos atributos;
    private final double DANO = 10.0;
    
    public Dwarf(String nome) {
        this.atributos = new Atributos (nome, Status.VIVO, 110.0);
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
