
package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.LocadoraApplicationTests;
import static br.com.dbc.locadora.entity.Categoria.ACAO;
import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.entity.FilmeDTO;
import br.com.dbc.locadora.entity.MidiaDTO;
import static br.com.dbc.locadora.entity.Tipo.VHS;
import br.com.dbc.locadora.repository.FilmeRepository;
import br.com.dbc.locadora.service.FilmeService;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author jaqueline.bonoto
 */
public class FilmeRestControllerTest extends LocadoraApplicationTests {
    
    @Autowired
    private FilmeRestController filmeRestController;

    
    @Autowired
    private FilmeRepository filmeRepository;
    

    
    @Autowired
    private FilmeService filmeService;      
    
    @Override
    protected AbstractController getController() {
        return filmeRestController;
    }
       
    
    @After
    public void tearDown() {
    }



    @Test
    public void testFindByTituloOrCategoriaOrLancamento() throws Exception {
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
        
        restMockMvc.perform(MockMvcRequestBuilders.get("/api/filme/search?categoria=ACAO")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsBytes(filme)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content.[0].id").isNumber());
             
          
        int expResult = 1;
        List<Filme> resultado = filmeRepository.findAll();
        Assert.assertEquals(expResult, resultado.size());
        Assert.assertTrue(LocalDate.now().getYear()==filmeNormal.getLancamento().getYear());
    }

    
}
