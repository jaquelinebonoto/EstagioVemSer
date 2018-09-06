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
}
