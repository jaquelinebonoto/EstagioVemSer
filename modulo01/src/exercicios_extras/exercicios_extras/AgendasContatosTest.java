import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AgendasContatosTest {

    @Test
    public void adicionarNomeERetornar (){
        AgendasContatos agenda = new AgendasContatos();
        agenda.adicionar("Bernardo", "555555");
        agenda.adicionar("Mithrandir", "444444");
        assertEquals("555555", agenda.consultar("Bernardo"));        
        assertEquals("444444", agenda.consultar("Mithrandir"));   
    }

    /*@Test
    public void adicionarDoisContatosEGerarCsv(){
        AgendasContatos agenda = new AgendasContatos();
        agenda.adicionar("Bernardo", "555555");
        agenda.adicionar("Mithrandir", "444444");
        assertEquals("Bernardo,555555\nMithrandir,444444\n", agenda.csv());        
    }*/

}
