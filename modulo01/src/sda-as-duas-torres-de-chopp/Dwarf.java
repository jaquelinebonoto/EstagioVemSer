public class Dwarf extends Personagem {
    private Atributos atributos;
    private final double QTD_DANO = 10.0;

    public Dwarf(String nome) {
        super(nome, 110.0, Status.VIVO);
    }

    public void perderVida() {
        vida -= vida >= QTD_DANO ? QTD_DANO : 0;
        if (vida == 0.0) {
            this.status = Status.MORTO;
        }
    }
}