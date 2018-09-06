public class Elfo {
    private String nome;
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
        nome = nomeInformado;
    }

    public String getNome() {
        return nome;
    }

    public void atirarFlecha() {
        if (flecha.getQuantidade() > 0) {
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            experiencia++;
        }
    }

    public Item getFlecha() {
        return this.flecha;
    }
    // Law of Demeter
    // elfo.getFlecha().getQuantidade();
    // elfo.getQtdFlechas();

    public int getExperiencia() {
        return this.experiencia;
    }

    
    
    
    
}