<<<<<<< HEAD:modulo01/src/sda_as_duas_torres_jaque/Elfo.java
   public class Elfo {
    private Atributos atributos;
=======
public class Elfo extends Personagem {
>>>>>>> master:modulo01/src/sda-as-duas-torres-de-chopp/Elfo.java
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
<<<<<<< HEAD:modulo01/src/sda_as_duas_torres_jaque/Elfo.java
        this.atributos = new Atributos (nomeInformado, Status.VIVO, 100.0);
    }

    public String getNome() {
        return nome;
=======
        super(nomeInformado, 100.0, Status.VIVO);
>>>>>>> master:modulo01/src/sda-as-duas-torres-de-chopp/Elfo.java
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