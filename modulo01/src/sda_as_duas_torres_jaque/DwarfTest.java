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
    
    @Test
    public void ficarCom0VidasPartindoDeRecemNascido (){
        Dwarf dwarf = new Dwarf("Tyrion Lannister");
        for (int i=0; i<=10; i++) dwarf.perderVida();
        assertEquals(0.0, dwarf.getVida(), DELTA);
    }
    
    @Test
    public void ficarCom0VidasPartindoDoValorAtual() {
        Dwarf dwarf = new Dwarf("Greyjoy");
        dwarf.perderVida(); 
        double v = dwarf.getVida();
        for (int i=0; i<v/10.0; i++) dwarf.perderVida();
        assertEquals(0.0, dwarf.getVida(), DELTA);
    }
    
    @Test
    public void trocarStatusQuando0Vidas () {
        Dwarf dwarf = new Dwarf("Zack Efron");
        for (int i=0; i<=10; i++) {dwarf.perderVida();}
        dwarf.updateStatus();
        assertEquals (Status.MORTO, dwarf.getStatus());
    }
    
    @Test
    public void perderVidaDepoisDeMorto () {
        Dwarf dwarf = new Dwarf("Zack Efron");
        for (int i=0; i<=10; i++) {dwarf.perderVida();}
        dwarf.updateStatus();
        dwarf.perderVida();
        assertEquals (0.0, dwarf.getVida(), DELTA); 
    }
    
    @Test
    public void perderVidaDepoisDeMortoSemChamarUpdateStatus () {
        Dwarf dwarf = new Dwarf("Zack Efron");
        for (int i=0; i<=10; i++) {dwarf.perderVida();}
        dwarf.perderVida();
        assertEquals (0.0, dwarf.getVida(), DELTA); 
    }
}