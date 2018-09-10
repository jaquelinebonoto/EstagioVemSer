public class Dwarf extends Personagem{
    private Atributos atributos;
    private final double DANO = 10.0;

    public Dwarf(String nome) {
        super(nome, 110.0, Status.VIVO);
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
