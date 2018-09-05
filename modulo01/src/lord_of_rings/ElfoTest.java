

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ElfoTest{
    @Test
    public void celebornAtiraUmaFlecha(){
      Elfo celeborn = new Elfo("Celeborn");
      celeborn.atirarFlecha();
      assertEquals(6, celeborn.getQtdFlechas());
      assertEquals(1, celeborn.getExperiencia());
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
      assertEquals(0, elfo.getFlecha().getQuantidade());
      assertEquals(7, elfo.getExperiencia());
    }
}
