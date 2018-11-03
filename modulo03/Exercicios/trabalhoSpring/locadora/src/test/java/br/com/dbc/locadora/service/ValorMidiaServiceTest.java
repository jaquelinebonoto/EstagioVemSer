package br.com.dbc.locadora.service;

import br.com.dbc.locadora.LocadoraApplicationTests;
import br.com.dbc.locadora.rest.AbstractController;
import br.com.dbc.locadora.rest.ValorMidiaRestController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Windows
 */
public class ValorMidiaServiceTest extends LocadoraApplicationTests {

    @Autowired
    private ValorMidiaRestController valorMidiaRestController;

    @Autowired
    private FilmeService filmeService;
    
    @Override
    protected AbstractController getController() {
        return valorMidiaRestController;
    }



    /*@Test
    public void testDeleteByIdMidia() throws Exception {
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

        restMockMvc.perform(MockMvcRequestBuilders.get("/api/valormidia")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsBytes(filme)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content.[0].id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content.[0].lancamento").value("2018-11-01"));

        int expResult = 1;
        List<Filme> resultado = filmeRepository.findAll();
        Assert.assertEquals(expResult, resultado.size());
    }*/

}
