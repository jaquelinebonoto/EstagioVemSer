package br.com.dbc.petshophibernate.service;

import br.com.dbc.petshophibernate.dao.HibernateUtil;
import br.com.dbc.petshophibernate.entity.Animal;
import static br.com.dbc.petshophibernate.entity.Animal.builder;
import br.com.dbc.petshophibernate.entity.Cliente;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaqueline.bonoto
 */
public class ClienteServiceTest {
    
    public ClienteServiceTest() {
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



    @Test
    public void testCreate() {
        System.out.println("create");
        Cliente cliente1 =
                Cliente.builder()
                .nome("Cliente1")
                .animalList(Arrays.asList(Animal.builder()
                        .nome("Animal1")
                        .build()))
                .build();
        ClienteService.getInstance().create(cliente1);
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Cliente> clientes = session.createCriteria(Cliente.class).list();
        Assert.assertEquals("Quantidade de clientes errada", 1, clientes.size());
        Cliente result = clientes.stream().findAny().get();
        Assert.assertEquals("Cliente Diferente", cliente1.getNome(), result.getNome());
        Assert.assertEquals("Cliente Diferente", cliente1.getId(), result.getId());        
        Assert.assertEquals("Quantidade de animais diferentes",
                cliente1.getAnimalList().size(),
                result.getAnimalList().size());
        session.close();
    }
    

}
