package br.com.dbc.petshophibernate.service;

import br.com.dbc.petshophibernate.dao.ClienteDAO;
import br.com.dbc.petshophibernate.dao.HibernateUtil;
import br.com.dbc.petshophibernate.entity.Animal;
import br.com.dbc.petshophibernate.entity.Cliente;
import java.util.Arrays;
import java.util.List;
import javassist.NotFoundException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.createSQLQuery("DELETE FROM CLIENTE_ANIMAL").executeUpdate();
        session.createSQLQuery("DELETE FROM Animal").executeUpdate();
        session.createSQLQuery("DELETE FROM Cliente").executeUpdate();
        t.commit();
        session.close();        
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
        Assert.assertEquals("Cliente pegando nome", cliente1.getNome(), result.getNome());
        Assert.assertEquals("Cliente pagando pelo ID", cliente1.getId(), result.getId());        
        Assert.assertEquals("Quantidade de animais diferentes",
                cliente1.getAnimalList().size(),
                result.getAnimalList().size());
        session.close();
    }
    
    @Test
    public void testCreate2() {
        System.out.println("create");
        Cliente cliente2 =
                Cliente.builder()
                .nome("Cliente1")
                .animalList(Arrays.asList(Animal.builder()
                        .nome("Animal1")
                        .build()))
                .build();
        ClienteService.getInstance().create(cliente2);
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Cliente> clientes = session.createCriteria(Cliente.class).list();
        Assert.assertEquals("Quantidade de clientes errada", 1, clientes.size());
        Cliente result = clientes.stream().findAny().get();
        Assert.assertEquals("Cliente pegando nome", cliente2.getNome(), result.getNome());
        Assert.assertEquals("Cliente pagando pelo ID", cliente2.getId(), result.getId());        
        Assert.assertEquals("Quantidade de animais diferentes",
                cliente2.getAnimalList().size(),
                result.getAnimalList().size());
        session.close();
    }
    
    
    @Test
    public void testCreateComDoisAnimais() {
        System.out.println("create");
        Cliente cliente2;
        cliente2 = Cliente.builder()
                .nome("Cliente2")
                .animalList(Arrays.asList(
                        Animal.builder().nome("Animal1").build(), 
                        Animal.builder().nome("Animal2").build())
                )
                .build();
        ClienteService.getInstance().create(cliente2);
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Cliente> clientes = session.createCriteria(Cliente.class).list();
        Cliente result = clientes.stream().findAny().get();
        Assert.assertEquals("Cliente Diferente", cliente2.getNome(), result.getNome());
        Assert.assertEquals("Cliente Diferente", cliente2.getId(), result.getId());        
        Assert.assertEquals("Quantidade de animais diferentes",
                cliente2.getAnimalList().size(),
                result.getAnimalList().size());
        session.close();
    }
   
    @Test
    public void testCreateMocked(){
        System.out.println("create mocked");
        Cliente cliente1 = Cliente.builder()
                .nome("Cliente 1")
                .animalList(
                        Arrays.asList(
                                Animal.builder()
                                .nome("Animal 1")
                                .build()))
                .build();
        ClienteDAO daoMock = Mockito.mock(ClienteDAO.class); //chama o DAO mas não irá executar de fato
        Mockito.doNothing().when(daoMock).createOrUpdate(cliente1); //dizendo para não enviar quando chamar o createOrUpdate
        
        ClienteService clienteService = Mockito.spy(ClienteService.class); //criando um service do tipo mock e mandando usar os métodos de verdade
        Mockito.when(clienteService.getDao()).thenReturn(daoMock); //vai retornar o DAO falso. é isso que queremos testar aqui
        //se o service está chamando o DAO
        
        clienteService.create(cliente1); //chamou a função create do service
        verify(daoMock, times(1)).createOrUpdate(cliente1); //daoMock.create deve ser =1 e times(1) também
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCreateException(){
        System.out.println("create exception");
        ClienteService.getInstance()
                .create(
                    Cliente.builder().id(1l).build()
                );
    }
    
    @Test(expected = HibernateException.class)
    public void testConectionException(){
        System.out.println("create mocked");
        Cliente cliente1 = Cliente.builder()
                .nome("Cliente 1")
                .animalList(
                        Arrays.asList(
                                Animal.builder()
                                .nome("Animal 1")
                                .build()))
                .build();
        ClienteDAO daoMock = Mockito.mock(ClienteDAO.class); 
        Mockito.doThrow(HibernateException.class).when(daoMock).createOrUpdate(cliente1);
        ClienteService clienteService = Mockito.spy(ClienteService.class); 
        Mockito.when(clienteService.getDao()).thenReturn(daoMock); 
        clienteService.create(cliente1);
    }
    
    @Test
    public void testUpdateMocked(){
        System.out.println("update mocked");
        Cliente cliente1 = Cliente.builder()
                .id(1l)
                .nome("Cliente 1")
                .animalList(
                        Arrays.asList(
                                Animal.builder()
                                .nome("Animal 1")
                                .build()))
                .build();
        ClienteDAO daoMock = Mockito.mock(ClienteDAO.class); 
        Mockito.doNothing().when(daoMock).createOrUpdate(cliente1); 
        
        ClienteService clienteService = Mockito.spy(ClienteService.class); 
        Mockito.when(clienteService.getDao()).thenReturn(daoMock); 
        
        clienteService.update(cliente1);
        verify(daoMock, times(1)).createOrUpdate(cliente1); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateException(){
        System.out.println("create exception");
        ClienteService.getInstance()
                .update(
                    Cliente.builder().build()
                );
    }
    
    @Test
    public void testDeleteMocked() throws NotFoundException{
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
        ClienteDAO daoMock = Mockito.mock(ClienteDAO.class); 
        
        Mockito.doNothing().when(daoMock).delete(cliente1); 
        Mockito.doReturn(cliente1).when(daoMock).findById(cliente1.getId());
        
        ClienteService clienteService = Mockito.spy(ClienteService.class); 
        Mockito.when(clienteService.getDao()).thenReturn(daoMock); 
        
        clienteService.delete(cliente1.getId()); 
        verify(daoMock, times(1)).delete(cliente1); 
        verify(daoMock, times(1)).findById(cliente1.getId()); 
    }
    
}

        
        /*
        public void delete(ID id) throws NotFoundException{
        if(id == null){
            throw new IllegalArgumentException("Deletar um Cliente não pode ter ID NULL");
        }
        ENTITY entity = findOne(id);
        if(entity == null){
            throw new NotFoundException("");
        }
        getDao().delete(entity);
    }*/