import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class PaginadorInventarioTest {

    @Test
    public void pularLimitarComInventarioVazio() {
        Inventario inventario = new Inventario();
        PaginadorInventario paginador = new PaginadorInventario(inventario);
        ArrayList<Item> primeiraPagina = paginador.limitar(1);
        assertTrue(primeiraPagina.isEmpty());
    }

    @Test
    public void pularLimitarComApenasUmItem() {
        Inventario inventario = new Inventario();
        Item espada = new Item("Espada de ferro", 2);
        inventario.adicionar(espada);
        PaginadorInventario paginador = new PaginadorInventario(inventario);
        paginador.pular(0);
        ArrayList<Item> resultado = paginador.limitar(1);
        assertEquals(espada, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void pularLimitarDentroDosLimites() {
        Inventario inventario = new Inventario();
        Item espada = new Item("Espada", 1);
        Item escudoMetal = new Item("Escudo de metal", 2);
        Item pocaoHp = new Item("Poção de HP", 3);
        Item bracelete = new Item("Bracelete", 1);
        inventario.adicionar(espada);
        inventario.adicionar(escudoMetal);
        inventario.adicionar(pocaoHp);
        inventario.adicionar(bracelete);
        PaginadorInventario paginador = new PaginadorInventario(inventario);
        paginador.pular(0);
        ArrayList<Item> primeiraPagina = paginador.limitar(2);
        assertEquals(2, primeiraPagina.size());
        assertEquals(espada, primeiraPagina.get(0));
        assertEquals(escudoMetal, primeiraPagina.get(1));
        paginador.pular(2);
        ArrayList<Item> segundaPagina = paginador.limitar(2);
        assertEquals(2, segundaPagina.size());
        assertEquals(pocaoHp, segundaPagina.get(0));
        assertEquals(bracelete, segundaPagina.get(1));
    }

    @Test
    public void pularForaDosLimites() {
        Inventario inventario = new Inventario();
        Item espada = new Item("Espada", 1);
        Item escudoMetal = new Item("Escudo de metal", 2);
        inventario.adicionar(espada);
        inventario.adicionar(escudoMetal);
        PaginadorInventario paginador = new PaginadorInventario(inventario);
        paginador.pular(3);
        ArrayList<Item> primeiraPagina = paginador.limitar(2);
        assertTrue(primeiraPagina.isEmpty());
    }

    @Test
    public void limitarForaDosLimites() {
        Inventario inventario = new Inventario();
        Item espada = new Item("Espada", 1);
        Item escudoMetal = new Item("Escudo de metal", 2);
        inventario.adicionar(espada);
        inventario.adicionar(escudoMetal);
        PaginadorInventario paginador = new PaginadorInventario(inventario);
        paginador.pular(0);
        ArrayList<Item> primeiraPagina = paginador.limitar(3);
        assertEquals(2, primeiraPagina.size());
        assertEquals(espada, primeiraPagina.get(0));
        assertEquals(escudoMetal, primeiraPagina.get(1));
    }
    
    @Test
    public void pularELimitarForaDosLimites() {
        Inventario inventario = new Inventario();
        Item espada = new Item("Espada", 1);
        Item escudoMetal = new Item("Escudo de metal", 2);
        inventario.adicionar(espada);
        inventario.adicionar(escudoMetal);
        PaginadorInventario paginador = new PaginadorInventario(inventario);
        paginador.pular(3);
        ArrayList<Item> primeiraPagina = paginador.limitar(3);
        assertTrue(primeiraPagina.isEmpty());
    }

}
