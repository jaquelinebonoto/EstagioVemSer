package br.com.dbc.paiscidade.paiscidade;

import br.com.br.dbc.paiscidade.paiscidade.entity.Pais;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
    
    @org.junit.Test
    public void testBuscarPaisesQueComecamPorA () {
        System.out.println("buscarPaisPorNome");
        String nome = "%rasi%";
        PaisService instance = PaisService.getInstance();
        String expResult = "Brasil";
        List<Pais> result = instance.buscarPaisPorNome(nome);
        assertTrue(expResult.equalsIgnoreCase(result.get(0).getNomepais()));
    }
    
    @org.junit.Test
    public void testBuscarPorSigla() {
        System.out.println("buscarPaisPorSigla");
        String sigla = "BR";
        PaisService instance = PaisService.getInstance();
        String expResult = "BR";
        List<Pais> result = instance.buscarPaisPorSigla(sigla);
        assertEquals(result.get(0).getSiglapais(), expResult);
    }
    
        @org.junit.Test
    public void testBuscarPorId() {
        System.out.println("buscarPaisPorId");
        Long Id = new Long (3);
        PaisService instance = PaisService.getInstance();
        Long expResult = new Long (3);
        List<Pais> result = instance.buscarPaisPorId(Id);
        assertEquals(result.get(0).getIdpais() , expResult);
    }
    
}
