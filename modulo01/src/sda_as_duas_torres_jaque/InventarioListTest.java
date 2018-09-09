import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

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
        InventarioList inventario1 = new InventarioList();
        Item espada = new Item("Espada", 1);
        Item flecha = new Item("Flecha", 2);
        inventario1.adicionar(espada);
        inventario1.adicionar(flecha);
        assertEquals(2, inventario1.tamanhoInventario());  
    }

    @Test
    public void buscaItemPeloNomeArmadura(){
        InventarioList inventario1 = new InventarioList();
        Item espada = new Item("Espada", 1);
        Item flecha = new Item("Flecha", 2);
        Item machado = new Item("Machado", 2);
        Item armadura= new Item("Armadura", 1);
        inventario1.adicionar(espada);
        inventario1.adicionar(flecha);
        inventario1.adicionar(machado);
        inventario1.adicionar(armadura);
        Item resultado = inventario1.buscarItem("Armadura");
        assertEquals(armadura.getDescricao(), resultado.getDescricao());
    }

    /*@Test
    public void buscaItemPorNomeIncorretoRetornaNull(){
    InventarioList inventario1 = new InventarioList();
    Item espada = new Item("Espada", 1);
    Item flecha = new Item("Flecha", 2);
    Item machado = new Item("Machado", 2);
    Item armadura= new Item("Armadura", 1);
    inventario1.adicionar(espada);
    inventario1.adicionar(flecha);
    inventario1.adicionar(machado);
    inventario1.adicionar(armadura);
    Item resultado = inventario1.buscarItem("carro");
    assertEquals(null, resultado.getDescricao());
    }*/

    @Test
    public void inverteLista(){
        InventarioList inventario = new InventarioList();
        Item espada = new Item("Espada", 1);
        Item escudo = new Item("Escudo", 2);
        Item flecha = new Item("Flecha", 2);
        Item machado = new Item("Machado", 2);
        inventario.adicionar(espada);
        inventario.adicionar(escudo);
        inventario.adicionar(flecha);
        inventario.adicionar(machado);
        InventarioList invertida = new InventarioList();
        invertida.adicionar(machado);
        invertida.adicionar(flecha);
        invertida.adicionar(escudo);
        invertida.adicionar(espada);
        assertEquals(invertida.getItens(), inventario.inverter().getItens());
    }
}
