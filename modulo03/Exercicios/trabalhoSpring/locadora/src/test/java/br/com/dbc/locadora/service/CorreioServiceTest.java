
package br.com.dbc.locadora.service;

import br.com.dbc.locadora.LocadoraApplicationTests;
import br.com.dbc.locadora.entity.Cliente;
import br.com.dbc.locadora.rest.AbstractController;
import br.com.dbc.locadora.rest.ClienteRestController;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author jaqueline.bonoto
 */
public class CorreioServiceTest extends LocadoraApplicationTests{
    
    @Autowired
    private ClienteRestController clienteRestController;
    @Override
    protected AbstractController getController() {
        return clienteRestController;
    }
        
    @After
    public void tearDown() {
    }

    /**
     * Test of buscarCEP method, of class CorreioService.
     */
    @Test
    public void testBuscarCEP() throws Exception {
        String cep = "94920350";
        CorreioService mock = Mockito.mock(CorreioService.class);
        Cliente c = Cliente.builder().rua("Rua Luis Cardoso").cidade("Cachoeirinha").estado("RS").build();
        restMockMvc.perform(MockMvcRequestBuilders.get("/api/cliente/cep/{cep}", cep)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.estado").isString())                     
                .andExpect(MockMvcResultMatchers.jsonPath("$.bairro").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$.cidade").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$.estado").isString());
    }    
}
