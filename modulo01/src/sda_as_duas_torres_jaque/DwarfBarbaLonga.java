public class DwarfBarbaLonga extends Dwarf {
    
    private Sorteador sorteador;
    
    public DwarfBarbaLonga(String nome) {
        super(nome);
        sorteador = new DadoD6(); //instanciou um dado e chamou o método da interface sortear
    }
    
    public DwarfBarbaLonga(String nome, Sorteador sorteador) {
        this(nome);
        this.sorteador = sorteador;
    }
    
    public void perderVida() {
        boolean devePerderVida = sorteador.sortear() <= 4; //ele irá perder a vida em 2/3 das vezes. 4 chances em um dado de 6 lados.
        if (devePerderVida) {
            super.perderVida();
        }
    }
}
