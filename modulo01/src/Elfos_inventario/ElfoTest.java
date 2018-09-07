import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest{
    @Test
    public void celebornAtiraUmaFlecha(){
      Elfo celeborn = new Elfo("Celeborn");
      celeborn.atirarFlecha();
      assertEquals(7, celeborn.getQtdFlechas());
      assertEquals(0, celeborn.getExperiencia());
    }
    @Test
    public void legolasAtiraUmaFlecha(){
      Elfo elfo = new Elfo("Legolas");
      elfo.atirarFlecha();
      elfo.atirarFlecha();
      elfo.atirarFlecha();
      elfo.atirarFlecha();
      elfo.atirarFlecha();
      elfo.atirarFlecha();
      elfo.atirarFlecha();
      elfo.atirarFlecha();
      assertEquals(7, elfo.getQtdFlechas());
      assertEquals(0, elfo.getExperiencia());
    }
    
    @Test
    public void adicionaCaneca(){
        Item caneca = new Item("Caneca bonita", 1);
        Inventario inventario1 = new Inventario (1);
        inventario1.adicionaItem(caneca);
        assertEquals("Caneca bonita", inventario1.getItem(0).getDescricao());
    }
    
    /*@Test
    public void adicionaLancasEFlechas (){
        Item lancas = new Item("Lança de lançar", 3);
        Item flechas = new Item("Flechinhas", 10);
        Inventario inventario1 = new Inventario(1);
        inventario1.adicionaItem(lancas);
        inventario1.adicionaItem(flechas);
        assertEquals(
    }*/
}
