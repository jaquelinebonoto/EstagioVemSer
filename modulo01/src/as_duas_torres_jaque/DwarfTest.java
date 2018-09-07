import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest {
    
    private final double DELTA = 0.1;
    
    @Test
    public void dwarfPerde10DeVida() {
        Dwarf dwarf = new Dwarf("Bernardin");
        dwarf.perderVida();
        assertEquals(100.0, dwarf.getVida(), DELTA);
    }
    
    @Test
    public void dwarfNasceComStatusVivo() {
        Dwarf dwarf = new Dwarf("Carlota Joaquina de Bourbon, filha de Carlos IV de Espanha");
        assertEquals(Status.VIVO, dwarf.getStatus());
    }
}