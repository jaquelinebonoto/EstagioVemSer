package br.com.dbc.petshop.entity;

import br.com.dbc.petshop.service.ClienteService;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClienteTest {

    public ClienteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        HibernateUtil.getSessionFactory().openSession();
        PersistenceUtils.beginTransaction();
        PersistenceUtils.getEm().createNativeQuery("DELETE FROM ANIMAL WHERE 1=1").executeUpdate();
        PersistenceUtils.getEm().createNativeQuery("DELETE FROM CLIENTE WHERE 1=1").executeUpdate();
        PersistenceUtils.getEm().getTransaction().commit();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testFindAll() throws SQLException {
        System.out.println("findAll");
        ClienteService.getInstance().adiciona10();
        //PersistenceUtils.getEm().createQuery("SELECT C FROM Cliente C WHERE C.nome like :nome").setParameter("nome", "Joao%").getResultList();
        List<Cliente> result = PersistenceUtils
                .getEm()
                .createQuery("SELECT C FROM Cliente C WHERE C.nome like :nome")
                .setParameter("nome", "Joao%")
                .getResultList();
        int expected = 10;
        assertEquals(expected, result.size());
    }
    
    @Test
    public void testBuscarClientePorNomeCriteria() throws SQLException {
        System.out.println("testBuscarClientePorNomeCriteria");
        String nome = "Joao%";
        ClienteService instance = ClienteService.getInstance();
        instance.adiciona10Hibernate();
        String expNome = "Joao0";
        List<Cliente> result = instance.buscarClientePorNomeCriteria(nome);
        assertEquals(10, result.size());    
        assertEquals(expNome, result.get(0).getNome());
    }
}
