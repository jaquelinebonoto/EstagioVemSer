import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// PascalCase
public class FuncionarioTest {
    @Test
    public void capitaoAmericaDeveLucrar585() {
        Funcionario capitaoAmerica = new Funcionario("Capitão América", 500.0, 1000.0);
        assertEquals(585.0, capitaoAmerica.getLucro(), 0.1);
    }
    
    @Test
    // camelCase
    public void rogueDeveLucrar1508() {
        Funcionario rogue = new Funcionario("Rogue", 500.0, 7840.50);
        assertEquals(1508.4675, rogue.getLucro(), 0.1);
    }
}