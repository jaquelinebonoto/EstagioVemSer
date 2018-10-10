package br.com.dbc.paiscidade.paiscidade;

import br.com.br.dbc.paiscidade.paiscidade.entity.Pais;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaisServiceTest {
    
    public PaisServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @org.junit.Test
    public void testBuscarPaisPorNome() {
        System.out.println("buscarPaisPorNome");
        String nome = "%rasi%";
        PaisService instance = PaisService.getInstance();
        String expResult = "Brasil";
        List<Pais> result = instance.buscarPaisPorNome(nome);
        assertTrue(expResult.equalsIgnoreCase(result.get(0).getNomepais()));
    }
    
}
