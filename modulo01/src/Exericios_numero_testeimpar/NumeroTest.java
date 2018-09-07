

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NumeroTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NumeroTest
{
    @Test    
    public void testeImpar () {
               
        assertEquals(true, new Numero(5).impar());
        assertEquals(true, new Numero(27).impar());
        assertEquals(false, new Numero(2018).impar());
        
    }    
    
    @Test
    public void testeSomaDigitos (){
        assertEquals(true, new Numero(9).verificarSomaDivisivel(1892376));
        assertEquals(false, new Numero(3).verificarSomaDivisivel(17));
    }  
        
}
