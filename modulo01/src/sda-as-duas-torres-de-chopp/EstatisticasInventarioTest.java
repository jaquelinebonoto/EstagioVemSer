import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EstatisticasInventarioTest {

    private final double DELTA = 0.1;

    @Test
    public void calcularMediaInventarioVazio() {
        Inventario inventario = new Inventario();
        EstatisticasInventario estatisticas = new EstatisticasInventario(inventario);
        assertTrue(Double.isNaN(estatisticas.calcularMedia()));
        // assertNull(estatisticas.calcularMedia());
    }

    @Test
    public void calcularMediaInventarioUmElemento() {
        Inventario inventario = new Inventario();
        inventario.adicionar(new Item("Escudo de aluminio", 2));
        EstatisticasInventario estatisticas = new EstatisticasInventario(inventario);
        assertEquals(2, estatisticas.calcularMedia(), DELTA);
    }

    @Test
    public void calcularMediaInventarioQtdsIguais() {
        Inventario inventario = new Inventario();
        inventario.adicionar(new Item("Escudo de aluminio", 4));
        inventario.adicionar(new Item("Flechas de fogo", 4));
        EstatisticasInventario estatisticas = new EstatisticasInventario(inventario);
        assertEquals(4, estatisticas.calcularMedia(), DELTA);
    }

    @Test
    public void calcularMediaInventarioQtdsDiferentes() {
        Inventario inventario = new Inventario();
        inventario.adicionar(new Item("Escudo de aluminio", 4));
        inventario.adicionar(new Item("Flechas de fogo", 4));
        inventario.adicionar(new Item("Anduril", 1));
        EstatisticasInventario estatisticas = new EstatisticasInventario(inventario);
        assertEquals(3, estatisticas.calcularMedia(), DELTA);
    }

    @Test
    public void calcularMedianaComInventarioVazio() {
        Inventario inventario = new Inventario();
        EstatisticasInventario estatisticas = new EstatisticasInventario(inventario);
        assertTrue(Double.isNaN(estatisticas.calcularMediana()));
        // assertNull(estatisticas.calcularMediana());
    }

    @Test
    public void calcularMedianaComUmItem() {
        Inventario inventario = new Inventario();
        inventario.adicionar(new Item("Lembas", 5));
        EstatisticasInventario estatisticas = new EstatisticasInventario(inventario);
        assertEquals(5, estatisticas.calcularMediana(), DELTA);
    }

    @Test
    public void calcularMedianaComQtdParDeItens() {
        Inventario inventario = new Inventario();
        inventario.adicionar(new Item("Escudo de aluminio", 2));
        inventario.adicionar(new Item("Flechas de fogo", 3));
        inventario.adicionar(new Item("Bracelete", 4));
        inventario.adicionar(new Item("Lembas", 5));
        EstatisticasInventario estatisticas = new EstatisticasInventario(inventario);
        assertEquals(3.5, estatisticas.calcularMediana(), DELTA);
    }

    @Test
    public void calcularMedianaComQtdImparDeItens() {
        Inventario inventario = new Inventario();
        inventario.adicionar(new Item("Anduril", 1));
        inventario.adicionar(new Item("Escudo de aluminio", 2));
        inventario.adicionar(new Item("Flechas de fogo", 3));
        inventario.adicionar(new Item("Bracelete", 4));
        inventario.adicionar(new Item("Lembas", 5));
        EstatisticasInventario estatisticas = new EstatisticasInventario(inventario);
        assertEquals(3, estatisticas.calcularMediana(), DELTA);
    }

    @Test
    public void calcularMedianaComItensDesordenados() {
        Inventario inventario = new Inventario();
        inventario.adicionar(new Item("Lembas", 5));
        inventario.adicionar(new Item("Escudo de aluminio", 2));
        inventario.adicionar(new Item("Anduril", 1));
        inventario.adicionar(new Item("Bracelete", 4));
        inventario.adicionar(new Item("Flechas de fogo", 3));
        EstatisticasInventario estatisticas = new EstatisticasInventario(inventario);
        // TODO: passar esse cenario quando implementar ordenaçao.
        //assertEquals(3, estatisticas.calcularMediana(), DELTA);
    }

    @Test
    public void qtdItensAcimaDaMediaInventarioVazio() {
        Inventario inventario = new Inventario();
        EstatisticasInventario estatisticas = new EstatisticasInventario(inventario);
        assertEquals(0, estatisticas.qtdItensAcimaDaMedia());
    }

    @Test
    public void qtdItensAcimaDaMediaComUmItem() {
        Inventario inventario = new Inventario();
        EstatisticasInventario estatisticas = new EstatisticasInventario(inventario);
        inventario.adicionar(new Item("Arco de vidro", 1));
        assertEquals(0, estatisticas.qtdItensAcimaDaMedia());
    }

    @Test
    public void qtdItensAcimaDaMediaComVariosItens() {
        Inventario inventario = new Inventario();
        EstatisticasInventario estatisticas = new EstatisticasInventario(inventario);
        inventario.adicionar(new Item("Lembas", 5));
        inventario.adicionar(new Item("Escudo de aluminio", 2));
        inventario.adicionar(new Item("Anduril", 1));
        inventario.adicionar(new Item("Bracelete", 4));
        inventario.adicionar(new Item("Flechas de fogo", 2));
        inventario.adicionar(new Item("Clava de madeira", 6));
        assertEquals(3, estatisticas.qtdItensAcimaDaMedia());
    }

    @Test
    public void qtdItensAcimaDaMediaComItemIgualAMedia() {
        Inventario inventario = new Inventario();
        EstatisticasInventario estatisticas = new EstatisticasInventario(inventario);
        inventario.adicionar(new Item("Lembas", 5));
        inventario.adicionar(new Item("Escudo de aluminio", 2));
        inventario.adicionar(new Item("Anduril", 1));
        inventario.adicionar(new Item("Bracelete", 4));
        inventario.adicionar(new Item("Flechas de fogo", 3));
        assertEquals(2, estatisticas.qtdItensAcimaDaMedia());
    }
}
