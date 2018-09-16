import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class NoturnosPorUltimoTest {
    @Test
    public void elfosVerdesFicamNaFrente() {
        Elfo yasser = new ElfoNoturno("Mad Yasser");
        Elfo ghilherme = new ElfoVerde("GG");
        Elfo rachid = new ElfoNoturno("Yace");
        Elfo henrique = new ElfoVerde("GhiGhi");

        ArrayList<Elfo> elfos = new ArrayList(
                Arrays.asList(yasser, ghilherme, rachid, henrique)
            );
        NoturnosPorUltimo formacao = new NoturnosPorUltimo();
        ArrayList<Elfo> esperado = new ArrayList(
                Arrays.asList(ghilherme, henrique, yasser, rachid)
            );
        assertEquals(esperado, formacao.getOrdemDeAtaque(elfos));
    }

    @Test
    public void elfosMortosNaoEntramNaFormacao() {
        Elfo yasser = new ElfoNoturno("Mad Yasser");
        Elfo ghilherme = new ElfoVerde("GG");
        Elfo rachid = new ElfoNoturno("Yace");
        Elfo henrique = new ElfoVerde("GhiGhi");        
        Elfo amanda = new ElfoDaLuz("Amandita");

        for (int i = 0; i < 10; i++) {
            yasser.perderVida();
            amanda.perderVida();
        }        
        ArrayList<Elfo> elfos = new ArrayList(
                Arrays.asList(yasser, ghilherme, rachid, henrique, amanda)
            );
        NoturnosPorUltimo formacao = new NoturnosPorUltimo();

        ArrayList<Elfo> esperado = new ArrayList(
                Arrays.asList(ghilherme, henrique, rachid)
            );
        assertEquals(esperado, formacao.getOrdemDeAtaque(elfos));
    }

    @Test
    public void elfosDaLuzFicamEntreVerdesENoturnos() {
        Elfo yasser = new ElfoNoturno("Mad Yasser");
        Elfo ghilherme = new ElfoVerde("GG");
        Elfo amanda = new ElfoDaLuz("Amandita");
        Elfo tanara = new ElfoDaLuz("Tanarinha");

        ArrayList<Elfo> elfos = new ArrayList(
                Arrays.asList(yasser, ghilherme, amanda, tanara)
            );

        NoturnosPorUltimo formacao = new NoturnosPorUltimo();

        ArrayList<Elfo> esperado = new ArrayList(
                Arrays.asList(ghilherme, amanda, tanara,  yasser)
            );

        assertEquals(esperado, formacao.getOrdemDeAtaque(elfos));
    }

    @Test
    public void listaSemElfoVerdeIniciaComElfosDaLuz() {
        Elfo yasser = new ElfoNoturno("Mad Yasser");
        Elfo amanda = new ElfoDaLuz("Amandita");
        Elfo tanara = new ElfoDaLuz("Tanarinha");

        ArrayList<Elfo> elfos = new ArrayList(
                Arrays.asList(amanda, yasser, tanara)
            );
        NoturnosPorUltimo formacao = new NoturnosPorUltimo();
        ArrayList<Elfo> esperado = new ArrayList(
                Arrays.asList(amanda, tanara,  yasser)
            );

        assertEquals(esperado, formacao.getOrdemDeAtaque(elfos));
    }
}