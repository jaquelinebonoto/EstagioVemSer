import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoDaLuzTest {

    private static final double DELTA = 0.1;
    @Test
    public void elfoDaLuzNasceCom7FlechasE1EspadaEspecial(){
        ElfoDaLuz legolas = new ElfoDaLuz("Legolas");
        assertEquals("Legolas", legolas.getNome());
        assertEquals(7, legolas.getFlecha().getQuantidade());
        assertEquals(1, legolas.getEspadaEspecial().getQuantidade());
    }  

    @Test
    public void tentarTirarDeleAEspadaEspecial(){
        ElfoDaLuz legolas = new ElfoDaLuz("Legolas");
        Item espadaEspecial = new Item("Espada de Galvorn", 1);
        legolas.perderItem(espadaEspecial);
        assertEquals(1, legolas.getEspadaEspecial().getQuantidade());
    }  

    /*
    @Test
    public void tentarTirarOutroObjeto(){
        ElfoDaLuz legolas = new ElfoDaLuz("Legolas");
        legolas.perderItem(new Item("Flecha", 7));
        assertEquals(0, legolas.getFlecha().getQuantidade());
    }*/
    

    @Test
    public void atacar1VezComEspadaEspecial(){
        ElfoDaLuz feanor = new ElfoDaLuz("Fëanor");
        feanor.atacarComEspada(new Dwarf("Farlum")); // perde 21 unidades, foi o ataque 1
        assertEquals(79.0, feanor.getVida(), DELTA);
    }

    @Test
    public void atacar2VezesComEspadaEspecial(){
        ElfoDaLuz feanor = new ElfoDaLuz("Fëanor");
        feanor.atacarComEspada(new Dwarf("Farlum")); // perde 21 unidades, foi o ataque 1
        feanor.atacarComEspada(new Dwarf("Gul")); // ganha 10 unidades, foi o ataque 2    
        feanor.getVida(); // 89.0
    }

    @Test
    public void atacarAteMorrer(){
        ElfoDaLuz feanor = new ElfoDaLuz("Fëanor");
        Dwarf gul = new Dwarf("Gul");
        for (int i=0; i<17; i++)feanor.atacarComEspada(gul);
        assertEquals(0, feanor.getVida(), DELTA);
        assertEquals(0, gul.getVida(), DELTA);
    }
    
    @Test
    public void elfoDaLuzSoAtacaComUnidadeDeEspada () {
        ElfoDaLuz feanor = new ElfoDaLuz("Fëanor");
        feanor.getInventario().getItens().get(2).setQuantidade(0);
        feanor.atacarComEspada(new Dwarf("Gul"));
        assertEquals(79, feanor.getVida(), DELTA);
    }
}
