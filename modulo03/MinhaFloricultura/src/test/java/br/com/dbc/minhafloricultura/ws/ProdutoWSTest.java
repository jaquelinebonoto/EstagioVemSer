/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.minhafloricultura.ws;

import br.com.dbc.minhafloricultura.entidade.Produto;
import br.com.dbc.minhafloricultura.entidade.dao.ProdutoDAO;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 *
 * @author jaqueline.bonoto
 */
public class ProdutoWSTest {

    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testBuscarProdutoPorNome() {
        ProdutoDAO produtoDAO = Mockito.mock(ProdutoDAO.class);
        ProdutoWS wse = Mockito.spy(ProdutoWS.class); //criando um service do tipo mock e mandando usar os métodos de verdade
        Mockito.when(wse.getDAO()).thenReturn(produtoDAO); //vai retornar o DAO falso. é isso que queremos testar aqui
        Mockito.when(produtoDAO.buscarProdutoPelaDescricao(ArgumentMatchers.anyString()))
                .thenReturn(Arrays.asList(new Produto(1l, "Tekpix", 1l)));
        System.out.println("buscarProdutoPorNome");
        String descricao = "Tekpi%";
        String expNome = "Tekpix";
        List<Produto> result = wse.buscarProdutoPelaDescricao(descricao);
        assertEquals(1, result.size());
        assertEquals(expNome,  result.get(0).getDescricao());
        verify(produtoDAO, times(1)).buscarProdutoPelaDescricao(descricao);
    }

}
