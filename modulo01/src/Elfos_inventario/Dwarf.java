/*Permitir que Elfos atirem flechas em Dwarves (anões)! 
 * Lembrem-se que um Dwarf nasce com 110.0 unidades de vida 
 * e perde 10 a cada flechada. */

public class Dwarf{
    private String nome;
    private Status status = Status.VIVO;
    private double vida=110.0;

    public Dwarf(String nome){
        this.nome = nome;
    }

    public void perderVida(){
        vida -=10;
    }
    
    public double getVida(){
        return this.vida;
    }
    
    public Status getStatus(){
        return this.status;
    }
}
