
package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.LocadoraApplicationTests;
import br.com.dbc.locadora.dto.CatalogoSearchDTO;
import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.entity.Midia;
import static br.com.dbc.locadora.entity.Tipo.BLUE_RAY;
import static br.com.dbc.locadora.entity.Tipo.DVD;
import static br.com.dbc.locadora.entity.Tipo.VHS;
import br.com.dbc.locadora.entity.ValorMidia;
import br.com.dbc.locadora.repository.FilmeRepository;
import br.com.dbc.locadora.repository.MidiaRepository;
import br.com.dbc.locadora.repository.ValorMidiaRepository;
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
public class FilmeRestControllerTest extends LocadoraApplicationTests {
    
    @Autowired
    private FilmeRestController filmeRestController;

    
    @Autowired
    private FilmeRepository filmeRepository;
    
    @Autowired
    private MidiaRepository midiaRepository;
    
    @Autowired
    private ValorMidiaRepository valorMidiaRepository;
    
    
    @Autowired
    private FilmeService filmeService;      
    
    @Override
    protected AbstractController getController() {
        return filmeRestController;
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
    public void testFindValorByIdFilme() throws Exception{
        Filme filme = new Filme();
        filmeRepository.save(filme);
        List<Midia> midias = new ArrayList<>();
        midias.add(midiaRepository.save(Midia.builder().tipo(VHS).filme(filme).build()));
        midias.add(midiaRepository.save(Midia.builder().tipo(DVD).filme(filme).build()));
        midias.add(midiaRepository.save(Midia.builder().tipo(BLUE_RAY).filme(filme).build()));

        List<ValorMidia> valores = new ArrayList<>();
        valores.add(valorMidiaRepository.save(ValorMidia.builder().valor(2.1).midia(midias.get(0)).build()));
        valores.add(valorMidiaRepository.save(ValorMidia.builder().valor(2.5).midia(midias.get(1)).build()));
        valores.add(valorMidiaRepository.save(ValorMidia.builder().valor(3.1).midia(midias.get(2)).build()));

        Assert.assertEquals(midias.get(0).getFilme(), filme);
        List<Filme> lista = filmeRepository.findAll();
        Assert.assertEquals(1, lista.size());
        Assert.assertEquals(lista.get(0), filme);
        restMockMvc.perform(MockMvcRequestBuilders.get("/api/filme/precos/{id}", filme.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content.[0].id").isNumber());
    }
    
    @Test
    public void testCatalogo() throws Exception{
        Filme filme = new Filme();
        filme.setTitulo("Joao");
        filmeRepository.save(filme);
        List<Midia> midias = new ArrayList<>();
        midias.add(midiaRepository.save(Midia.builder().tipo(VHS).filme(filme).build()));
        midias.add(midiaRepository.save(Midia.builder().tipo(DVD).filme(filme).build()));
        midias.add(midiaRepository.save(Midia.builder().tipo(BLUE_RAY).filme(filme).build()));
        CatalogoSearchDTO entrada = CatalogoSearchDTO.builder().titulo("Joao").build();
                
        List<ValorMidia> valores = new ArrayList<>();
        valores.add(valorMidiaRepository.save(ValorMidia.builder().valor(2.1).midia(midias.get(0)).build()));
        valores.add(valorMidiaRepository.save(ValorMidia.builder().valor(2.5).midia(midias.get(1)).build()));
        valores.add(valorMidiaRepository.save(ValorMidia.builder().valor(3.1).midia(midias.get(2)).build()));
        
        restMockMvc.perform(MockMvcRequestBuilders.post("/api/filme/search/catalogo")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsBytes(entrada)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content.[0].filme.id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content.[0].filme.titulo").value(filme.getTitulo()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content.[0].midias.[0].valorVigente").value(2.1));
    }
}
