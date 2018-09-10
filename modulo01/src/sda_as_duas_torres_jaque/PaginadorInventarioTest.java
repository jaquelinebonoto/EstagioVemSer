
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PaginadorInventarioTest {
    @Test
    public void PaginadorInventarioTest() {
        InventarioList inventario = new InventarioList();
        InventarioList inventarioTeste = new InventarioList();
        InventarioList inventarioTeste2 = new InventarioList();
        Item espada = new Item("Espada", 1);
        Item escudo = new Item("Escudo de metal", 2);
        Item pocao = new Item("Poção de HP", 3);
        Item bracelete = new Item("Bracelete", 1);
        inventario.adicionar(espada);
        inventarioTeste.adicionar(espada);
        inventario.adicionar(escudo);
        inventarioTeste.adicionar(escudo);
        inventario.adicionar(pocao);
        inventarioTeste2.adicionar(pocao);
        inventario.adicionar(bracelete);
        inventarioTeste2.adicionar(bracelete);
        PaginadorInventario paginador = new PaginadorInventario(inventario);
        paginador.pular(0);
        assertEquals(inventarioTeste.getItens(), paginador.limitar(2));
        paginador.pular(2);
        paginador.limitar(2);
        assertEquals(inventarioTeste2.getItens(), paginador.limitar(2));
        //paginador.pular(2);
        //paginador.limitar(2); // retorna os itens “Poção de HP” e “Bracelete”

    }
}
