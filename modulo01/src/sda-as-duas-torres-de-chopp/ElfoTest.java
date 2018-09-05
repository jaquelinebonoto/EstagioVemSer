import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void criarElfoInformandoNome() {
        Elfo legolas = new Elfo("Legolas");
        assertEquals("Legolas", legolas.getNome());
    }   

    @Test
    public void celebornAtiraUmaFlecha() {
        Elfo celeborn = new Elfo("Celeborn");
        celeborn.atirarFlecha();
        assertEquals(6, celeborn.getQtdFlechas());
        assertEquals(1, celeborn.getExperiencia());
    }

    @Test
    public void legolasTentaAtirarOitoFlechas() {
        Elfo elfo = new Elfo("Legolas");
        elfo.atirarFlecha();
        elfo.atirarFlecha();
        elfo.atirarFlecha();
        elfo.atirarFlecha();
        elfo.atirarFlecha();
        elfo.atirarFlecha();
        elfo.atirarFlecha();
        elfo.atirarFlecha();
        assertEquals(0, elfo.getQtdFlechas());
        assertEquals(7, elfo.getExperiencia());
    }
}


