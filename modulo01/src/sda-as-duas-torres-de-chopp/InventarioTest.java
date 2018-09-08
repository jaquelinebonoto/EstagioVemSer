import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest {

    @Test
    public void criarInventarioInformandoQuantidadeItens() {
        Inventario inventario = new Inventario(42);
        assertEquals(0, inventario.getItens().size());
    }

    @Test
    public void adicionarUmItem() {
        Inventario inventario = new Inventario();
        Item espada = new Item("Espada", 1);
        inventario.adicionar(espada);
        assertEquals(espada, inventario.getItens().get(0));
    }

    @Test
    public void adicionarDoisItensComEspaçoInicialParaUmAdicionaSegundo() {
        Inventario inventario = new Inventario(1);
        Item espada = new Item("Espada", 1);
        Item armadura = new Item("Armadura", 1);
        inventario.adicionar(espada);
        inventario.adicionar(armadura);
        assertEquals(espada, inventario.getItens().get(0));
        assertEquals(2, inventario.getItens().size());
    }

    @Test
    public void obterItemNaPrimeiraPosicao() {
        Inventario inventario = new Inventario(1);
        Item espada = new Item("Espada", 1);
        inventario.adicionar(espada);
        assertEquals(espada, inventario.obter(0));
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void obterItemNaoAdicionado() {
        Inventario inventario = new Inventario(1);
        Item espada = new Item("Espada", 1);
        Item primeiroItem = inventario.obter(0);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void removerItem() {
        Inventario inventario = new Inventario(1);
        Item espada = new Item("Espada", 1);
        inventario.adicionar(espada);
        inventario.remover(0);
        Item primeiroItem = inventario.obter(0);
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
        assertEquals(1, inventario.getItens().size());
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
        Item xicara = new Item("Chip", 1);

        inventario.adicionar(espada);
        inventario.adicionar(escudo);//
        inventario.adicionar(flechas);
        inventario.adicionar(xicara);//
        inventario.adicionar(espada);
        inventario.adicionar(escudo);//
        inventario.adicionar(flechas);
        inventario.adicionar(xicara);//

        inventario.remover(1);
        inventario.remover(2);
        inventario.remover(3);
        inventario.remover(4);
        String resultado = inventario.getDescricoesItens();
        assertEquals("Espada,Flechas,Espada,Flechas", resultado);
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

    @Test
    public void buscarItemComInventarioVazio() {
        Inventario inventario = new Inventario();
        assertNull(inventario.buscar("Malha de ferro"));
    }

    @Test
    public void buscarItemComMesmaDescricaoRetornaPrimeiro() {
        Inventario inventario = new Inventario();
        Item lanca = new Item("Lança", 3);
        Item espada = new Item("Espada de aço valiriano", 3);
        Item espada2 = new Item("Espada de aço valiriano", 2);
        inventario.adicionar(lanca);
        inventario.adicionar(espada);
        inventario.adicionar(espada2);
        Item resultado = inventario.buscar("Espada de aço valiriano");
        assertEquals("Espada de aço valiriano", resultado.getDescricao());
        assertEquals(3, resultado.getQuantidade());
    }

    @Test
    public void buscarItemForaDoInventarioRetornaNull() {
        Inventario inventario = new Inventario();
        Item lanca = new Item("Lança", 3);
        Item espada = new Item("Espada de aço valiriano", 3);
        inventario.adicionar(lanca);
        inventario.adicionar(espada);
        Item resultado = inventario.buscar("Botas de couro");
        assertNull(resultado);
    }

    @Test
    public void buscarItemNormal() {
        Inventario inventario = new Inventario();
        Item lanca = new Item("Lança", 1);
        Item espada = new Item("Espada de aço valiriano", 3);
        inventario.adicionar(lanca);
        inventario.adicionar(espada);
        Item resultado = inventario.buscar("Lança");
        assertEquals("Lança", resultado.getDescricao());
        assertEquals(1, resultado.getQuantidade());
    }
}