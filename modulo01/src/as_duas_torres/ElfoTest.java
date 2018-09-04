

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ElfoTest {
    @Test
    public void criarElfoInformandoNome (){
        Elfo legolas = new Elfo ("Legolas");
        assertEquals("Legolas", legolas.getNome());
    }
}
