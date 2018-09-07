

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest{
    private final double DELTA=0.1;
    @Test
    public void dwarfPerde10DeVida(){
        Dwarf dwarf = new Dwarf ("Bernardo");
        dwarf.perderVida();
        assertEquals(100.0, dwarf.getVida(), DELTA);        
    }
    
    @Test
    public void DwarfNAsceComStatusVivo(){
        Dwarf dwarf = new Dwarf("Carlota filha de Odin");
        assertEquals(Status.VIVO, dwarf.getStatus());
    }
}
