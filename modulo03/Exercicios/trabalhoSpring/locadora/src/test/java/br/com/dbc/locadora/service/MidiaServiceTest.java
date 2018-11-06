package br.com.dbc.locadora.service;

import br.com.dbc.locadora.LocadoraApplicationTests;
import static br.com.dbc.locadora.entity.Categoria.ACAO;
import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.dto.FilmeDTO;
import br.com.dbc.locadora.dto.MidiaDTO;
import br.com.dbc.locadora.entity.Midia;
import static br.com.dbc.locadora.entity.Tipo.DVD;
import static br.com.dbc.locadora.entity.Tipo.VHS;
import br.com.dbc.locadora.repository.FilmeRepository;
import br.com.dbc.locadora.repository.MidiaRepository;
import br.com.dbc.locadora.repository.ValorMidiaRepository;
import br.com.dbc.locadora.rest.AbstractController;
import br.com.dbc.locadora.rest.MidiaRestController;
import java.time.LocalDate;
import java.util.Arrays;
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
 * @author Windows
 */
public class MidiaServiceTest extends LocadoraApplicationTests {
    
    @Autowired
    private MidiaRestController midiaRestController;
    
    @Autowired
    private MidiaRepository midiaRepository;
    
    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private ValorMidiaRepository valorMidiaRepository;
    
    @Autowired 
    private FilmeService filmeService;
        
    @Override
    protected AbstractController getController() {
        return midiaRestController;
    }
    @Before
    public void beforeTest() {
        valorMidiaRepository.deleteAll();
        midiaRepository.deleteAll();
        filmeRepository.deleteAll();
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
    
    /*@Test
    public void atualizarMidia(){
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
        MidiaDTO nova = MidiaDTO.builder().tipo(DVD).quantidade(1).valor(3.0).build();
        Midia midiaNormal = nova.DtotoMidia(filmeNormal);
        
        restMockMvc.perform(MockMvcRequestBuilders.get("/api/midia/count/DVD")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(objectMapper.writeValueAsBytes(filme)))
            .andExpect(MockMvcResultMatchers.status().isOk())
           .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }*/

}
