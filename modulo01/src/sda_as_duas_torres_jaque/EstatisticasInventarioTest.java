import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EstatisticasInventarioTest{
    private final double DELTA = 0.1;
    @Test
    public void calculaMedia125 (){
        Inventario inventario = new Inventario();
        Item espada = new Item("Espada", 1);
        Item flecha = new Item("Flecha", 2);
        Item machado = new Item("Machado", 2);
        Item armadura= new Item("Armadura", 1);
        inventario.adicionar(espada);
        inventario.adicionar(flecha);
        inventario.adicionar(machado);
        inventario.adicionar(armadura);
        EstatisticasInventario inventario1 = new EstatisticasInventario(inventario);
        assertEquals(1.5, inventario1.calcularMedia(), DELTA);
    }
    
    @Test 
    public void calculoMedianaParResult5ponto5(){
        Inventario inventario = new Inventario();
        Item espada = new Item("Espada", 1);
        Item flecha = new Item("Flecha", 4);
        Item machado = new Item("Machado", 4);
        Item armadura= new Item("Armadura", 5);
        Item espada1 = new Item("Espada1", 6);
        Item flecha1 = new Item("Flecha1", 7);
        Item machado1 = new Item("Machado1", 7);
        Item armadura1= new Item("Armadura1", 7);
        inventario.adicionar(espada);
        inventario.adicionar(flecha);
        inventario.adicionar(machado);
        inventario.adicionar(armadura);
        inventario.adicionar(espada1);
        inventario.adicionar(flecha1);
        inventario.adicionar(machado1);
        inventario.adicionar(armadura1);
        EstatisticasInventario inventario1 = new EstatisticasInventario(inventario);
        assertEquals(5.5, inventario1.calcularMediana(), DELTA);        
    }
    
    @Test 
    public void testarSeNEstaCorreto(){
        Inventario inventario = new Inventario();
        Item espada = new Item("Espada", 1);
        Item flecha = new Item("Flecha", 4);
        Item machado = new Item("Machado", 4);
        Item armadura= new Item("Armadura", 5);
        Item espada1 = new Item("Espada1", 6);
        Item flecha1 = new Item("Flecha1", 7);
        Item machado1 = new Item("Machado1", 7);
        Item armadura1= new Item("Armadura1", 7);
        inventario.adicionar(espada);
        inventario.adicionar(flecha);
        inventario.adicionar(machado);
        inventario.adicionar(armadura);
        inventario.adicionar(espada1);
        inventario.adicionar(flecha1);
        inventario.adicionar(machado1);
        inventario.adicionar(armadura1);
        EstatisticasInventario inventario1 = new EstatisticasInventario(inventario);
        assertEquals(8, inventario.tamanhoInventario());        
    }
    @Test 
    public void calculoMedianaImparResult7(){
        Inventario inventario = new Inventario();
        Item espada = new Item("Espada", 2);
        Item flecha = new Item("Flecha", 2);
        Item machado = new Item("Machado", 3);
        Item armadura= new Item("Armadura", 7);
        Item espada1 = new Item("Espada1", 8);
        Item flecha1 = new Item("Flecha1", 9);
        Item machado1 = new Item("Machado1", 9);
        inventario.adicionar(espada);
        inventario.adicionar(flecha);
        inventario.adicionar(machado);
        inventario.adicionar(armadura);
        inventario.adicionar(espada1);
        inventario.adicionar(flecha1);
        inventario.adicionar(machado1);
        EstatisticasInventario inventario1 = new EstatisticasInventario(inventario);
        assertEquals(7.0, inventario1.calcularMediana(), DELTA);        
    }
    
    @Test 
    public void quatroItensAcimaDaMedia(){
        Inventario inventario = new Inventario();
        Item espada = new Item("Espada", 2);
        Item flecha = new Item("Flecha", 2);
        Item machado = new Item("Machado", 3);
        Item armadura= new Item("Armadura", 7);
        Item espada1 = new Item("Espada1", 8);
        Item flecha1 = new Item("Flecha1", 9);
        Item machado1 = new Item("Machado1", 9);
        inventario.adicionar(espada);
        inventario.adicionar(flecha);
        inventario.adicionar(machado);
        inventario.adicionar(armadura);
        inventario.adicionar(espada1);
        inventario.adicionar(flecha1);
        inventario.adicionar(machado1);
        EstatisticasInventario inventario1 = new EstatisticasInventario(inventario);
        assertEquals(4, inventario1.itensAcimaDaMedia());        
    }
}
