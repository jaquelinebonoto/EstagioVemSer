import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NumeroTest {
    @Test
    public void numero5Impar() {
        // Arrange
        Numero cinco = new Numero(5);
        // Act
        boolean resultado = cinco.impar();
        // Assert
        assertTrue(resultado);
    }
    
    @Test
    public void numero27Impar() {
        // Arrange
        Numero cinco = new Numero(27);
        // Act
        boolean resultado = cinco.impar();
        // Assert
        assertTrue(resultado);
    }
    
    @Test
    public void numero2018NaoImpar() {
        // Arrange
        Numero cinco = new Numero(2018);
        // Act
        boolean resultado = cinco.impar();
        // Assert
        assertFalse(resultado);
    }
    
    @Test
    public void verificar1892376DivisivelPor9() {
        assertTrue(new Numero(9).verificarSomaDivisivel(1892376));
    }
    
    @Test
    public void verificar0DeveSerVerdadeiro() {
        assertTrue(new Numero(98765).verificarSomaDivisivel(0));
    }
    
    @Test
    public void verificarSe23NaoEhDivisivel() {
        assertFalse(new Numero(98765).verificarSomaDivisivel(23));
    }
}

























