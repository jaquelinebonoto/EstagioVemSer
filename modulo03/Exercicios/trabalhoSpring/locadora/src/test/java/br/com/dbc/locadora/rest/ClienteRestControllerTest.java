/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        Cliente c = Cliente.builder().nome("nome").endereco("endereco").telefone(999999999l).build();
        restMockMvc.perform(MockMvcRequestBuilders.post("/api/cliente")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsBytes(c)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value(c.getNome()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.telefone").value(c.getTelefone()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endereco").value(c.getEndereco()));
        List<Cliente> clientes = clienteRepository.findAll();
        Assert.assertEquals(1, clientes.size());
        Assert.assertEquals(c.getNome(), clientes.get(0).getNome());
        Assert.assertEquals(c.getEndereco(), clientes.get(0).getEndereco());
        Assert.assertEquals(c.getTelefone(), clientes.get(0).getTelefone());
    }
    

}
