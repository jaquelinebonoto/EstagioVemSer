public class Elfo extends Personagem {
    private int experiencia=0;

    Inventario inventarioElfo = new Inventario();
    Item flecha = new Item ("Flecha", 7);
    Item arco = new Item ("Arco", 1);

    public Elfo(String nomeInformado) {
        super(nomeInformado, 100.0, Status.VIVO);
        inventarioElfo.adicionar(flecha);
        inventarioElfo.adicionar(arco);
    }

    public void atirarFlecha(Dwarf dwarf) {
        if (inventarioElfo.getItem(flecha).getQuantidade() > 0) {
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            experiencia++;
            dwarf.perderVida();
        }
    }

    public Item getItem (Item item){
        for (int i = 0; i < this.inventarioElfo.tamanhoInventario(); i++) {
            Item itemAtual = this.inventarioElfo.obter(i);
            if (itemAtual.equals(item)) {
                return itemAtual;
            }
        }
        return null;
    }

    public Item getFlecha(){
        return this.flecha;
    }
    public int getExperiencia() {
        return this.experiencia;
    }

    public Status updateStatus (){
        if (getVida()==0.0) status = Status.MORTO;
        return status;
    }

}