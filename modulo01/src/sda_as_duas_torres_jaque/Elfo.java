public class Elfo extends Personagem {
    protected int experiencia;
    protected int QTD_EXPERIENCIA;
    // type initializer
    {
        experiencia = 0;
        QTD_EXPERIENCIA = 1;
        QTD_DANO = 0.;
        super.ganharItem(new Item("Arco", 1));
        super.ganharItem(new Item("Flecha", 7));
    }

    public Elfo(String nomeInformado) {
        super(nomeInformado, 100.0, Status.VIVO);
    }

    public void atirarFlecha(Dwarf dwarf) {
        Item flecha = getFlecha();
        if (flecha.getQuantidade() > 0) {
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            experiencia += this.QTD_EXPERIENCIA;
            dwarf.perderVida();
            this.perderVida();
        }
    }

    public Item getFlecha() {
        return this.inventario.buscar("Flecha");
    }

    public int getExperiencia() {
        return this.experiencia;
    }

}