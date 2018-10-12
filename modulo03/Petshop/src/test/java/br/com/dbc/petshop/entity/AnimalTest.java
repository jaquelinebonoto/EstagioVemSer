
package br.com.dbc.petshop.entity;

import br.com.dbc.petshop.service.AnimalService;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author tiago
 */
public class AnimalTest {
    
    public AnimalTest() {
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

    /*@Test
    public void testFindAll() throws SQLException {
        System.out.println("findAll");
        AnimalService.getInstance().adiciona10Animais();
        //PersistenceUtils.getEm().createQuery("SELECT a FROM Animal a WHERE a.nome like :nome").setParameter("nome", "Cao%").getResultList();
        List<Cliente> result = PersistenceUtils
                .getEm()
                .createQuery("SELECT a FROM Animal a WHERE a.nome like :nome")
                .setParameter("nome", "Cao%")
                .getResultList();
        int expected = 10;
        assertEquals(expected, result.size());
    }*/
    
}
