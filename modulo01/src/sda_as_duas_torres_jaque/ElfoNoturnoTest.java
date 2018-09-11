import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest {

    private final double DELTA = 0.1;

    @Test
    public void elfoNoturnoNaoAtirarFlechaNaoMudaVida() {
        Elfo aimon = new ElfoNoturno("Aimon Yesfaren");
        assertEquals(100.0, aimon.getVida(), DELTA);
        assertEquals(0, aimon.getExperiencia());
        assertEquals(7, aimon.getFlecha().getQuantidade());
        assertEquals(Status.VIVO, aimon.getStatus());
    }

    @Test
    public void elfoNoturnoAtirarUmaFlecha() {
        Elfo aimon = new ElfoNoturno("Aimon Yesfaren");
        aimon.atirarFlecha(new Dwarf("Thorin"));
        assertEquals(85., aimon.getVida(), DELTA);
        assertEquals(3, aimon.getExperiencia());
        assertEquals(6, aimon.getFlecha().getQuantidade());
        assertEquals(Status.VIVO, aimon.getStatus());
    }

    @Test
    public void elfoNoturnoAtirarSeteFlechas() {
        Elfo aimon = new ElfoNoturno("Aimon Yesfaren");
        aimon.atirarFlecha(new Dwarf("Thorin"));
        aimon.atirarFlecha(new Dwarf("Thorin"));
        aimon.atirarFlecha(new Dwarf("Thorin"));
        aimon.atirarFlecha(new Dwarf("Thorin"));
        aimon.atirarFlecha(new Dwarf("Thorin"));
        aimon.atirarFlecha(new Dwarf("Thorin"));
        aimon.atirarFlecha(new Dwarf("Thorin"));
        assertEquals(0., aimon.getVida(), DELTA);
        assertEquals(21, aimon.getExperiencia());
        assertEquals(0, aimon.getFlecha().getQuantidade());
        assertEquals(Status.MORTO, aimon.getStatus());
    }

    @Test
    public void elfoNoturnoAtirarOitoFlechas() {
        Elfo aimon = new ElfoNoturno("Aimon Yesfaren");
        aimon.atirarFlecha(new Dwarf("Thorin"));
        aimon.atirarFlecha(new Dwarf("Thorin"));
        aimon.atirarFlecha(new Dwarf("Thorin"));
        aimon.atirarFlecha(new Dwarf("Thorin"));
        aimon.atirarFlecha(new Dwarf("Thorin"));
        aimon.atirarFlecha(new Dwarf("Thorin"));
        aimon.atirarFlecha(new Dwarf("Thorin"));
        aimon.atirarFlecha(new Dwarf("Thorin"));
        assertEquals(0., aimon.getVida(), DELTA);
        assertEquals(21, aimon.getExperiencia());
        assertEquals(0, aimon.getFlecha().getQuantidade());
        assertEquals(Status.MORTO, aimon.getStatus());
    }
}
