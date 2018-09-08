import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest {

    private final double DELTA = 0.1;

    @Test
    public void dwarfNasceComStatusVivoE110Vida() {
        Dwarf dwarf = new Dwarf("Carlota Joaquina de Bourbon, filha de Carlos IV de Espanha");
        assertEquals(110.0, dwarf.getVida(), DELTA);
        assertEquals(Status.VIVO, dwarf.getStatus());
    }    

    @Test
    public void dwarfPerde10DeVida() {
        Dwarf dwarf = new Dwarf("Bernardin");
        dwarf.perderVida();
        assertEquals(100.0, dwarf.getVida(), DELTA);
        assertEquals(Status.VIVO, dwarf.getStatus());
    }

    @Test
    public void dwarfPerde110DeVida() {
        Dwarf dwarf = new Dwarf("Thorin Escudo de Carvalho");
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        assertEquals(0.0, dwarf.getVida(), DELTA);
        assertEquals(Status.MORTO, dwarf.getStatus());
    }

    @Test
    public void dwarfPerderVidaMaisQue11Vezes() {
        Dwarf dwarf = new Dwarf("Thorin Escudo de Carvalho");
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        assertEquals(0.0, dwarf.getVida(), DELTA);
        assertEquals(Status.MORTO, dwarf.getStatus());
    }
}