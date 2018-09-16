
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemImperdivelTest{
    @Test
    public void itemImperdivelNaoPodeSerZerado() {
        Item item = new ItemImperdivel("Anduril", 1);
        item.setQuantidade(0);
        assertEquals(1, item.getQuantidade());
    }
}