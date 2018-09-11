import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class ElfoVerdeTest {
    /*@Test
    public void elfoVerdeAdicionarItemPermitido() {
        ElfoVerde elfa = new ElfoVerde("Zaleria Qiric");
        Item arcoVidro = new Item("Arco de Vidro", 1);
        elfa.ganharItem(arcoVidro);
        ArrayList<Item> esperado = new ArrayList<>(Arrays.asList(
                    new Item("Arco", 1),
                    new Item("Flecha", 7),
                    arcoVidro
                ));
        assertEquals(esperado, elfa.getInventario().getItens());
    }

    @Test
    public void elfoVerdeAdicionarItemNaoPermitido() {
        ElfoVerde elfa = new ElfoVerde("Zaleria Qiric");
        Item ironBoots = new Item("Botas de ferro", 1);
        elfa.ganharItem(ironBoots);
        ArrayList<Item> esperado = new ArrayList<>(Arrays.asList(
                    new Item("Arco", 1),
                    new Item("Flecha", 7)
                ));
        assertEquals(esperado, elfa.getInventario().getItens());
    }

    @Test
    public void elfoVerdeRemoverItemPermitido() {
        ElfoVerde elfa = new ElfoVerde("Zaleria Qiric");
        Item arcoVidro = new Item("Arco de Vidro", 1);
        elfa.ganharItem(arcoVidro);
        ArrayList<Item> esperado = new ArrayList<>(Arrays.asList(
                    new Item("Arco", 1),
                    new Item("Flecha", 7)
                ));
        elfa.perderItem(arcoVidro);
        assertEquals(esperado, elfa.getInventario().getItens());
    }

    @Test
    public void elfoVerdeRemoverItemNaoPermitido() {
        ElfoVerde elfa = new ElfoVerde("Zaleria Qiric");
        Item ironBoots = new Item("Botas de ferro", 1);
        elfa.ganharItem(ironBoots);
        ArrayList<Item> esperado = new ArrayList<>(Arrays.asList(
                    new Item("Arco", 1),
                    new Item("Flecha", 7)
                ));
        elfa.perderItem(ironBoots);
        assertEquals(esperado, elfa.getInventario().getItens());
    }
    
    @Test
    public void celebornAtiraUmaFlecha() {
        Elfo celeborn = new ElfoVerde("Celeborn");
        celeborn.atirarFlecha(new Dwarf("Gimli"));
        assertEquals(6, celeborn.getFlecha().getQuantidade());
        assertEquals(2, celeborn.getExperiencia());
    }

    @Test
    public void legolasTentaAtirarOitoFlechas() {
        Elfo elfo = new ElfoVerde("Legolas");
        elfo.atirarFlecha(new Dwarf("Gimli"));
        elfo.atirarFlecha(new Dwarf("Gimli"));
        elfo.atirarFlecha(new Dwarf("Gimli"));
        elfo.atirarFlecha(new Dwarf("Gimli"));
        elfo.atirarFlecha(new Dwarf("Gimli"));
        elfo.atirarFlecha(new Dwarf("Gimli"));
        elfo.atirarFlecha(new Dwarf("Gimli"));
        elfo.atirarFlecha(new Dwarf("Gimli"));
        assertEquals(0, elfo.getFlecha().getQuantidade());
        assertEquals(14, elfo.getExperiencia());
    }*/
}