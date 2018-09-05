
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class FuncionarioTest
{
    @Test
    public void testeLucro(){
        assertEquals(585.0, new Funcionario("Capitão América", 500.0, 1000.0).getLucro(), 0.0);
        assertEquals(1508.4675, new Funcionario("Rogue", 500.0, 7840.50).getLucro(), 0.0);
    }
    
    @Test
    public void joaoDeveLucrar1508(){
        Funcionario joao = new Funcionario ("João", 500.0, 7840.50);
        assertEquals(1508.4675, joao.getLucro(), 0.1);
    }
    

}
