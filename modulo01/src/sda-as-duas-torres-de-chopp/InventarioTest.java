import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest {

    @Test
    public void criarInventarioSemQuantidadeInformada() {
        Inventario inventario = new Inventario();
        assertEquals(99, inventario.getItens().length);
    }

    @Test
    public void criarInventarioInformandoQuantidadeItens() {
        Inventario inventario = new Inventario(42);
        assertEquals(42, inventario.getItens().length);
    }

    @Test
    public void adicionarUmItem() {
        Inventario inventario = new Inventario();
        Item espada = new Item("Espada", 1);
        inventario.adicionar(espada);
        assertEquals(espada, inventario.getItens()[0]);
    }

    @Test
    public void adicionarDoisItensComEspaçoParaUmNaoAdicionaSegundo() {
        Inventario inventario = new Inventario(1);
        Item espada = new Item("Espada", 1);
        Item armadura = new Item("Armadura", 1);
        inventario.adicionar(espada);
        inventario.adicionar(armadura);
        assertEquals(espada, inventario.getItens()[0]);
        assertEquals(1, inventario.getItens().length);
    }

    @Test
    public void obterItemNaPrimeiraPosicao() {
        Inventario inventario = new Inventario(1);
        Item espada = new Item("Espada", 1);
        inventario.adicionar(espada);
        assertEquals(espada, inventario.obter(0));
    }

    @Test
    public void obterItemNaoAdicionado() {
        Inventario inventario = new Inventario(1);
        Item espada = new Item("Espada", 1);
        assertNull(inventario.obter(0));
    }

    @Test
    public void removerItem() {
        Inventario inventario = new Inventario(1);
        Item espada = new Item("Espada", 1);
        inventario.adicionar(espada);
        inventario.remover(0);
        assertNull(inventario.obter(0));
    }

    @Test
    public void removerItemAntesDeAdicionarProximo() {
        Inventario inventario = new Inventario(1);
        Item espada = new Item("Espada", 1);
        Item armadura = new Item("Armadura", 1);
        inventario.adicionar(espada);
        inventario.remover(0);
        inventario.adicionar(armadura);
        assertEquals(armadura, inventario.obter(0));
        assertEquals(1, inventario.getItens().length);
    }

    @Test
    public void getDescricoesVariosItens() {
        Inventario inventario = new Inventario();
        Item espada = new Item("Espada", 1);
        Item escudo = new Item("Escudo", 2);
        inventario.adicionar(espada);
        inventario.adicionar(escudo);
        String resultado = inventario.getDescricoesItens();
        assertEquals("Espada,Escudo", resultado);
    }

    @Test
    public void getDescricoesItensRemovendoItemNoMeio() {
        Inventario inventario = new Inventario();
        Item espada = new Item("Espada", 1);
        Item escudo = new Item("Escudo", 2);
        Item flechas = new Item("Flechas", 3);
        inventario.adicionar(espada);
        inventario.adicionar(escudo);
        inventario.adicionar(flechas);
        inventario.remover(1);
        String resultado = inventario.getDescricoesItens();
        assertEquals("Espada,Flechas", resultado);
    }

    @Test
    public void getDescricoesItensVazio() {
        Inventario inventario = new Inventario();
        String resultado = inventario.getDescricoesItens();
        assertEquals("", resultado);
    }

    @Test
    public void getItemMaiorQuantidadeComVarios() {
        Inventario inventario = new Inventario();
        Item lanca = new Item("Lança", 1);
        Item espada = new Item("Espada de aço valiriano", 3);
        Item escudo = new Item("Escudo de madeira", 2);
        inventario.adicionar(lanca);
        inventario.adicionar(espada);
        inventario.adicionar(escudo);
        Item resultado = inventario.getItemComMaiorQuantidade();
        assertEquals(espada, resultado);
    }
    
    @Test
    public void getItemMaiorQuantidadeInventarioVazio() {
        Inventario inventario = new Inventario(0);
        Item resultado = inventario.getItemComMaiorQuantidade();
        assertNull(resultado);
    }

    @Test
    public void getItemMaiorQuantidadeItensComMesmaQuantidade() {
        Inventario inventario = new Inventario();
        Item lanca = new Item("Lança", 3);
        Item espada = new Item("Espada de aço valiriano", 3);
        Item escudo = new Item("Escudo de madeira", 2);
        inventario.adicionar(lanca);
        inventario.adicionar(espada);
        inventario.adicionar(escudo);
        Item resultado = inventario.getItemComMaiorQuantidade();
        assertEquals(lanca, resultado);
    }
    
}
















