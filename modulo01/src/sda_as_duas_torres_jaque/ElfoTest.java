import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class ElfoTest {
    
    private final double DELTA = 0.1;
    
    @Test
    public void criarElfoInformandoNome() {
        Elfo legolas = new Elfo("Legolas");
        assertEquals("Legolas", legolas.getNome());
    }   

    @Test
    public void celebornAtiraUmaFlecha() {
        Elfo celeborn = new Elfo("Celeborn");
        celeborn.atirarFlecha(new Dwarf("Gimli"));
        assertEquals(6, celeborn.getFlecha().getQuantidade());
        assertEquals(1, celeborn.getExperiencia());
    }

    @Test
    public void legolasTentaAtirarOitoFlechas() {
        Elfo elfo = new Elfo("Legolas");
        elfo.atirarFlecha(new Dwarf("Gimli"));
        elfo.atirarFlecha(new Dwarf("Gimli"));
        elfo.atirarFlecha(new Dwarf("Gimli"));
        elfo.atirarFlecha(new Dwarf("Gimli"));
        elfo.atirarFlecha(new Dwarf("Gimli"));
        elfo.atirarFlecha(new Dwarf("Gimli"));
        elfo.atirarFlecha(new Dwarf("Gimli"));
        elfo.atirarFlecha(new Dwarf("Gimli"));
        assertEquals(0, elfo.getFlecha().getQuantidade());
        assertEquals(7, elfo.getExperiencia());
    }

    @Test
    public void atirarFlechaEmUmDwarf() {
        Elfo legolas = new Elfo("Legolas");
        Dwarf gimli = new Dwarf("Gimli");
        legolas.atirarFlecha(gimli);
        assertEquals(6, legolas.getFlecha().getQuantidade());
        assertEquals(1, legolas.getExperiencia());
        assertEquals(100.0, gimli.getVida(), DELTA);
    }
    
}