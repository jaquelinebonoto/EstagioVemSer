
package br.com.dbc.petshopjpa.dao.service;


import br.com.dbc.petshopjpa.dao.ClienteDAO;
import br.com.dbc.petshopjpa.dao.PersistenceUtils;
import br.com.dbc.petshopjpa.entity.Animal;
import br.com.dbc.petshopjpa.entity.Cliente;
import java.util.Arrays;
import java.util.List;
import javassist.NotFoundException;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import static oracle.net.aso.b.c;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.internal.util.reflection.Whitebox;


/**
 *
 * @author jaqueline.bonoto
 */
public class ClienteServiceTest {
    
    public ClienteServiceTest() {
    }
    
    private final EntityManager em = PersistenceUtils.getEntityManager();
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        em.getTransaction().begin();
        em.createQuery("delete from Cliente").executeUpdate();
        em.getTransaction().commit();
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testFindAll() {
        System.out.println("findAll");
        em.getTransaction().begin();
        Cliente c = Cliente.builder()
                .nome("João")
                .animalList(Arrays.asList(Animal
                        .builder()
                        .nome("Catioro")
                        .build()))
                .build();
        em.persist(c);
        em.getTransaction().commit();
        ClienteService instance = new ClienteService();
        List<Cliente> clientes = instance.findAll();
        
        Assert.assertEquals( 1, clientes.size() );
        
        Assert.assertEquals( c.getId(), 
                        clientes.stream().findFirst().get().getId() );
        
        Assert.assertEquals( c.getAnimalList().size(), 
                        clientes.stream().findFirst().get().getAnimalList().size());
        
        Assert.assertEquals( c.getAnimalList().get(0).getId(), 
                        clientes.stream().findFirst().get().getAnimalList().get(0).getId());
    }
    
    @Test
    public void testFindOneMocked (){
        ClienteService clienteService = new ClienteService();
        ClienteDAO clienteDAO = Mockito.mock(ClienteDAO.class);
        Whitebox.setInternalState(clienteService, "clienteDAO", clienteDAO);
        Cliente created = Cliente.builder().nome("Jovem").animalList(Arrays.asList(
                        Animal.builder().nome("Animal1").build(), 
                        Animal.builder().nome("Animal2").build())
                )
                .build();
        Mockito.doReturn(created).when(clienteDAO).findOne(created.getId());
        Cliente returned = clienteService.findOne(created.getId());
        Assert.assertEquals(created.getId(), returned.getId());
        Mockito.verify(clienteDAO, times(1)).findOne(created.getId());
   }
    
    @Test
    public void testDeleteMocked() {
        ClienteService clienteService = new ClienteService();
        ClienteDAO clienteDAO = Mockito.mock(ClienteDAO.class);   
        Whitebox.setInternalState(clienteService, "clienteDAO", clienteDAO);
        System.out.println("delete mocked");
        Cliente cliente1 = Cliente.builder()
                .id(1l)
                .nome("Cliente 1")
                .animalList(
                        Arrays.asList(
                                Animal.builder()
                                .nome("Animal 1")
                                .build()))
                .build();
        //Mockito.doNothing().when(clienteDAO).delete(cliente1.getId()); faz isso por padrão por isso funciona comentado
        clienteService.delete(cliente1.getId()); 
        verify(clienteDAO, times(1)).delete(cliente1.getId()); 
    }
}
