   public class Elfo {
    private Atributos atributos;
    private int experiencia;
    private Item arco;
    private Item flecha;

    // type initializer
    {
        experiencia = 0;
        arco = new Item("Arco", 1);
        flecha = new Item("Flecha", 7);
    }

    public Elfo(String nomeInformado) {
        this.atributos = new Atributos (nomeInformado, Status.VIVO, 100.0);
    }

    public String getNome() {
        return nome;
    }

    public void atirarFlecha(Dwarf dwarf) {
        if (flecha.getQuantidade() > 0) {
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            experiencia++;
            dwarf.perderVida();
        }
    }

    public Item getFlecha() {
        return this.flecha;
    }

    public int getExperiencia() {
        return this.experiencia;
    }
}