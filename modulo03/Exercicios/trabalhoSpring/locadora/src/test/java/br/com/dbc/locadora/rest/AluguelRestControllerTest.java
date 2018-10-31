
package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.LocadoraApplicationTests;
import br.com.dbc.locadora.entity.Aluguel;
import br.com.dbc.locadora.entity.AluguelDTO;
import static br.com.dbc.locadora.entity.Categoria.ACAO;
import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.entity.FilmeDTO;
import br.com.dbc.locadora.repository.AluguelRepository;
import br.com.dbc.locadora.service.AluguelService;
import br.com.dbc.locadora.service.FilmeService;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author jaqueline.bonoto
 */
public class AluguelRestControllerTest extends LocadoraApplicationTests {
    
    @Autowired
    private AluguelRestController aluguelRestController;

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private AluguelService aluguelService;
    
    @Autowired
    private FilmeService filmeService;
        
    @Override
    protected AbstractController getController() {
        return aluguelRestController;
    }
    
    @Before
    public void beforeTest() {
        aluguelRepository.deleteAll();
    }
    
    @After
    public void tearDown() {
    }

/*
    @Test
    public void testGetService() {
        System.out.println("getService");
        AluguelRestController instance = new AluguelRestController();
        AluguelService expResult = null;
        AluguelService result = instance.getService();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    
    @Test
    public void testCadastrarRetirada() throws Exception {
        System.out.println("cadastrarRetirada");
        List<Long> midias = new ArrayList<>();
        midias.add(1l);
        midias.add(2l);
        
        
        FilmeDTO filme = FilmeDTO.builder()
                        .id(1l)
                        .titulo("O filme")
                        .lancamento(null)
                        .categoria(ACAO)
                        .build();
        filmeService.salvarComMidia(filme);
        
        
        AluguelDTO dto = AluguelDTO.builder()
                .idCliente(1l)
                .midias(midias)
                .build();
        
        Aluguel aluguel = aluguelService.DtotoAluguel(dto);
        aluguelRepository.save(aluguel);
        aluguelRestController.cadastrarRetirada(dto);
        
        restMockMvc.perform(MockMvcRequestBuilders.post("/api/aluguel/retirada")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsBytes(dto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.retirada").value("yyyy-MM-dd"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.multa").value(0));
                       
        int expResult = 1;
        List<Aluguel> resultado = aluguelRepository.findAll();
        Assert.assertEquals(expResult, resultado.size());
        
    }

/*
    @Test
    public void testCadastrarDevolucao() {
        System.out.println("cadastrarDevolucao");
        AluguelDTO dto = null;
        AluguelRestController instance = new AluguelRestController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.cadastrarDevolucao(dto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    @Test
    public void testFindByAluguelPrevisao() {
        System.out.println("findByAluguelPrevisao");
        Pageable pageable = null;
        LocalDate previsao = null;
        AluguelRestController instance = new AluguelRestController();
        ResponseEntity<Page<Filme>> expResult = null;
        ResponseEntity<Page<Filme>> result = instance.findByAluguelPrevisao(pageable, previsao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
