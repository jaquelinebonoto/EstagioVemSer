<<<<<<< HEAD:modulo01/src/sda_as_duas_torres_jaque/Dwarf.java
public class Dwarf {
    private Atributos atributos;
    private final double DANO = 10.0;
    
    public Dwarf(String nome) {
        this.atributos = new Atributos (nome, Status.VIVO, 110.0);
=======
public class Dwarf extends Personagem {
    private Atributos atributos;
    private final double QTD_DANO = 10.0;

    public Dwarf(String nome) {
        super(nome, 110.0, Status.VIVO);
>>>>>>> master:modulo01/src/sda-as-duas-torres-de-chopp/Dwarf.java
    }

    public void perderVida() {
<<<<<<< HEAD:modulo01/src/sda_as_duas_torres_jaque/Dwarf.java
        if(status == Status.VIVO) vida -= DANO;
        updateStatus();
    }
    
    public double getVida() {
        return this.vida;
    }
    
    public Status getStatus() {
        return this.status;
=======
        vida -= vida >= QTD_DANO ? QTD_DANO : 0;
        if (vida == 0.0) {
            this.status = Status.MORTO;
        }
>>>>>>> master:modulo01/src/sda-as-duas-torres-de-chopp/Dwarf.java
    }
    
    public Status updateStatus (){
        if (getVida()==0.0) status = Status.MORTO;
        return status;
    }
}
