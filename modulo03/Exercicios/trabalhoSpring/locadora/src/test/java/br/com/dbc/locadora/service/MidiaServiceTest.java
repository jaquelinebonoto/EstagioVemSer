package br.com.dbc.locadora.service;

import br.com.dbc.locadora.LocadoraApplicationTests;
import static br.com.dbc.locadora.entity.Categoria.ACAO;
import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.dto.FilmeDTO;
import br.com.dbc.locadora.dto.MidiaDTO;
import static br.com.dbc.locadora.entity.Tipo.DVD;
import static br.com.dbc.locadora.entity.Tipo.VHS;
import br.com.dbc.locadora.repository.MidiaRepository;
import br.com.dbc.locadora.rest.AbstractController;
import br.com.dbc.locadora.rest.MidiaRestController;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author Windows
 */
public class MidiaServiceTest extends LocadoraApplicationTests {
    
    @Autowired
    private MidiaRestController midiaRestController;
    
    @Autowired
    private MidiaRepository midiaRepository;
        
    @Autowired 
    private FilmeService filmeService;
        
    @Override
    protected AbstractController getController() {
        return midiaRestController;
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCountByTipo() throws Exception {
        
        FilmeDTO filme = FilmeDTO.builder()
                        .titulo("O filme")
                        .lancamento(LocalDate.now())
                        .categoria(ACAO)
                        .midia(Arrays.asList(
                            MidiaDTO.builder().tipo(DVD).quantidade(2).valor(3.0).build(), 
                            MidiaDTO.builder().tipo(VHS).quantidade(2).valor(3.0).build(),
                            MidiaDTO.builder().tipo(DVD).quantidade(6).valor(3.0).build())
                    )
                        .build();
    
        Filme filmeNormal = filmeService.salvarComMidia(filme);        
        
        restMockMvc.perform(MockMvcRequestBuilders.get("/api/midia/count/DVD")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsBytes(filme)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        

        Assert.assertTrue(8 == midiaRepository.countByTipo(DVD));
    }

}
