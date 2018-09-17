import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class AtaqueIntercaladoTest {

    @Test
    public void elfosIntercaladosInformei5Elfos() {
        Elfo legolas = new ElfoVerde("Legolas");
        Elfo yasser = new ElfoNoturno("Mad Yasser");
        Elfo ghilherme = new ElfoVerde("GG");
        Elfo rachid = new ElfoNoturno("Yace");
        Elfo henrique = new ElfoVerde("GhiGhi");

        ArrayList<Elfo> elfos = new ArrayList(
                Arrays.asList(legolas, yasser, ghilherme, rachid, henrique)
            );
        AtaqueIntercalado formacao = new AtaqueIntercalado();
        ArrayList<Elfo> esperado = new ArrayList(
                Arrays.asList(legolas, yasser, ghilherme, rachid)
            );
        assertEquals(esperado, formacao.getOrdemDeAtaque(elfos));
    }
    
        @Test
    public void elfosIntercaladosComecandoComNoturno() {
        Elfo rachid = new ElfoNoturno("Yace");
        Elfo legolas = new ElfoVerde("Legolas");
        Elfo yasser = new ElfoNoturno("Mad Yasser");
        Elfo ghilherme = new ElfoVerde("GG");
        Elfo henrique = new ElfoVerde("GhiGhi");

        ArrayList<Elfo> elfos = new ArrayList(
                Arrays.asList(rachid, legolas, yasser, ghilherme, henrique)
            );
        AtaqueIntercalado formacao = new AtaqueIntercalado();
        ArrayList<Elfo> esperado = new ArrayList(
                Arrays.asList(rachid, legolas, yasser, ghilherme)
            );
        assertEquals(esperado, formacao.getOrdemDeAtaque(elfos));
    }
}