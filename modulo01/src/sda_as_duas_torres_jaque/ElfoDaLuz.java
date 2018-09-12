import java.util.Arrays;
import java.util.ArrayList;

public class ElfoDaLuz extends Elfo {
    Item espadaEspecial = new Item("Espada de Galvorn", 1);
    private int ataques =0;
    {
        super.ganharItem(espadaEspecial);
    }
    public ElfoDaLuz(String nome) {
        super(nome);
        QTD_DANO = 21.;
    }

    public void perderItem(Item item) {
        if (item.getDescricao().equals("Espada de Galvorn")){
            System.out.println("O Elfo da Luz deve carregar sua espada até o fim de seus dias.");
        }
        this.inventario.getItens().remove(item);
    }

    public Item getEspadaEspecial() {
        return this.inventario.buscar("Espada de Galvorn");
    }
    
    public void ganharVida(){
        this.vida +=10.0;
    }

    public void atacarComEspada(Dwarf dwarf){
        if(numeroDeAtaques()%2==1) super.perderVida();
        else this.ganharVida();            
    }
    
    public int numeroDeAtaques (){
        this.ataques+=1;
        return ataques;
    }
}
