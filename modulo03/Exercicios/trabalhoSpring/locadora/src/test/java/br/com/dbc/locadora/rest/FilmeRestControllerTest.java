
package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.entity.Categoria;
import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.entity.FilmeDTO;
import br.com.dbc.locadora.repository.AluguelRepository;
import br.com.dbc.locadora.repository.FilmeRepository;
import br.com.dbc.locadora.repository.MidiaRepository;
import br.com.dbc.locadora.repository.ValorMidiaRepository;
import br.com.dbc.locadora.service.AluguelService;
import br.com.dbc.locadora.service.ClienteService;
import br.com.dbc.locadora.service.FilmeService;
import br.com.dbc.locadora.service.MidiaService;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author jaqueline.bonoto
 */
public class FilmeRestControllerTest {
    
    @Autowired
    private FilmeRestController filmeRestController;

    @Autowired
    private AluguelRepository aluguelRepository;
    
    @Autowired
    private FilmeRepository filmeRepository;
    
    @Autowired
    private MidiaRepository midiaRepository;
    
    @Autowired
    private ValorMidiaRepository valorMidiaRepository;

    @Autowired
    private AluguelService aluguelService;
    
    @Autowired
    private FilmeService filmeService;
    
    @Autowired
    private MidiaService midiaService;
    
    @Autowired
    private ClienteService clienteService;
        
    
    protected AbstractController getController() {
        return filmeRestController;
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
    public void testSalvarComMidia() {
        System.out.println("salvarComMidia");
        FilmeDTO dto = null;
        FilmeRestController instance = new FilmeRestController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.salvarComMidia(dto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of findByTituloOrCategoriaOrLancamento method, of class FilmeRestController.
     */
    @Test
    public void testFindByTituloOrCategoriaOrLancamento() {
        System.out.println("findByTituloOrCategoriaOrLancamento");
        Pageable pageable = null;
        String titulo = "";
        Categoria categoria = null;
        LocalDate lancamento = null;
        FilmeRestController instance = new FilmeRestController();
        ResponseEntity<Page<Filme>> expResult = null;
        ResponseEntity<Page<Filme>> result = instance.findByTituloOrCategoriaOrLancamento(pageable, titulo, categoria, lancamento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of put method, of class FilmeRestController.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        Long id = null;
        FilmeDTO input = null;
        FilmeRestController instance = new FilmeRestController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.put(id, input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
