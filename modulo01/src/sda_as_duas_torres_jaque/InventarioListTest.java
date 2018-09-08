import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.lang.String;

public class InventarioListTest{
    @Test
    public void criarInventario() {
        ArrayList<Item> inventario = new ArrayList<>();
        assertEquals(true, inventario.isEmpty());
    }

    @Test
    public void adicionar1ItemNoInventarioNaoEstarVazio(){
        ArrayList<Item> inventario = new ArrayList<>();
        Item espada = new Item("Espada", 1);
        inventario.add(espada);
        assertEquals(false, inventario.isEmpty());        
    }

    @Test
    public void adicionar2ItensEVoltarTamanho(){
        ArrayList<Item> inventario = new ArrayList<>();
        Item espada = new Item("Espada", 1);
        Item flecha = new Item("Flecha", 2);
        inventario.add(espada);
        inventario.add(flecha);
        assertEquals(2, inventario.size());        
    }

    @Test
    public void buscaItemPeloNome(){
        ArrayList<Item> inventario1 = new ArrayList<>();
        Item espada = new Item("Espada", 1);
        Item flecha = new Item("Flecha", 2);
        inventario1.add(espada);
        inventario1.add(flecha); 
        Item resultado = inventario1.
        assertEquals(flecha, resultado);
    }
}
