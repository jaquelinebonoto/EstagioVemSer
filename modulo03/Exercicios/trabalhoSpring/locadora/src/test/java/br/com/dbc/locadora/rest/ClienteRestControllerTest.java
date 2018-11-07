
package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.LocadoraApplicationTests;
import br.com.dbc.locadora.entity.Cliente;
import br.com.dbc.locadora.repository.ClienteRepository;
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
 * @author henrique.laporta
 */
public class ClienteRestControllerTest extends LocadoraApplicationTests {

    @Autowired
    private ClienteRestController clienteRestController;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    protected AbstractController getController() {
        return clienteRestController;
    }

    @Before
    public void beforeTest() {
        clienteRepository.deleteAll();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void clienteCreateTest() throws Exception {
        Cliente c = Cliente.builder().nome("nome").telefone("9999999").rua("").bairro("").cidade("").estado("").build();
        restMockMvc.perform(MockMvcRequestBuilders.post("/api/cliente")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsBytes(c)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value(c.getNome()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.telefone").value(c.getTelefone()));
        List<Cliente> clientes = clienteRepository.findAll();
        Assert.assertEquals(1, clientes.size());
        Assert.assertEquals(c.getNome(), clientes.get(0).getNome());
        Assert.assertEquals(c.getTelefone(), clientes.get(0).getTelefone());
    }
    
    @Test
    public void clienteDeleteTest() throws Exception {
        Cliente c = Cliente.builder().nome("nome").telefone("9999999").rua("").bairro("").cidade("").estado("").build();
        clienteRepository.save(c);
        restMockMvc.perform(MockMvcRequestBuilders.delete("/api/cliente/{id}", c.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsBytes(c)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").doesNotExist());
                
        List<Cliente> clientes = clienteRepository.findAll();
        Assert.assertEquals(0, clientes.size());
    }
}
