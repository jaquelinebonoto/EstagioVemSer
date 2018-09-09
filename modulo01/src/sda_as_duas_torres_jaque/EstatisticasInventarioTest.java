import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EstatisticasInventarioTest{
    private final double DELTA = 0.1;
    @Test
    public void calculaMedia125 (){
        InventarioList inventario = new InventarioList();
        Item espada = new Item("Espada", 1);
        Item flecha = new Item("Flecha", 2);
        Item machado = new Item("Machado", 2);
        Item armadura= new Item("Armadura", 1);
        inventario.adicionar(espada);
        inventario.adicionar(flecha);
        inventario.adicionar(machado);
        inventario.adicionar(armadura);
        EstatisticasInventario inventario1 = new EstatisticasInventario(inventario);
        assertEquals(1.5, inventario1.calcularMedia(inventario), DELTA);
    }
}
