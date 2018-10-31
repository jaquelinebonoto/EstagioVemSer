
package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.LocadoraApplicationTests;
import br.com.dbc.locadora.entity.Aluguel;
import br.com.dbc.locadora.entity.AluguelDTO;
import static br.com.dbc.locadora.entity.Categoria.ACAO;
import br.com.dbc.locadora.entity.Cliente;
import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.entity.FilmeDTO;
import br.com.dbc.locadora.entity.Midia;
import br.com.dbc.locadora.entity.MidiaDTO;
import br.com.dbc.locadora.entity.Tipo;
import static br.com.dbc.locadora.entity.Tipo.VHS;
import br.com.dbc.locadora.repository.AluguelRepository;
import br.com.dbc.locadora.repository.FilmeRepository;
import br.com.dbc.locadora.repository.MidiaRepository;
import br.com.dbc.locadora.repository.ValorMidiaRepository;
import br.com.dbc.locadora.service.AluguelService;
import br.com.dbc.locadora.service.ClienteService;
import br.com.dbc.locadora.service.FilmeService;
import br.com.dbc.locadora.service.MidiaService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
        
    @Override
    protected AbstractController getController() {
        return aluguelRestController;
    }
    
    @Before
    public void beforeTest() {
        valorMidiaRepository.deleteAll();
        midiaRepository.deleteAll();
        filmeRepository.deleteAll();
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
        /*MidiaDTO m1 = MidiaDTO.builder().tipo(Tipo.VHS).quantidade(2).valor(2.0).build();;
        MidiaDTO m2 = MidiaDTO.builder().tipo(Tipo.VHS).quantidade(4).valor(4.0).build();
        List<MidiaDTO> midias = new ArrayList<>();
        midias.add(m1);
        midias.add(m2);*/
                        
        FilmeDTO filme = FilmeDTO.builder()
                        .titulo("O filme")
                        .lancamento(LocalDate.now())
                        .categoria(ACAO)
                        .midia(Arrays.asList(
                            MidiaDTO.builder().tipo(VHS).quantidade(2).valor(2.0).build(), 
                            MidiaDTO.builder().tipo(VHS).quantidade(4).valor(4.0).build()) 
                    )
                        .build();
    
        Filme filmeNormal = filmeService.salvarComMidia(filme);
        List<Midia> midiasEnt = midiaRepository.findByFilmeId(filmeNormal.getId());
        
        List<Long> midiasId = new ArrayList<>();
        midiasId.add(midiasEnt.get(0).getId());
        midiasId.add(midiasEnt.get(1).getId());        
        
        Cliente cliente = new Cliente();
        clienteService.save(cliente);
        AluguelDTO dto = AluguelDTO.builder()
                .id(1l)
                .idCliente(cliente.getId())
                .midias(midiasId)
                .build();
        
        Aluguel aluguel = aluguelService.cadastrarRetirada(dto);
               
        restMockMvc.perform(MockMvcRequestBuilders.post("/api/aluguel/retirada")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsBytes(dto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.retirada").value("2018-10-31"));
                
                       
        int expResult = 2;
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
