import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NumerosTest {

    private final double DELTA = 0.1;

    @Test
    public void calcularMediaDeArrayPreenchido() {
        double[] entrada = { 1.0, 3.0, 5.0, 1.0, -10.0 };
        double[] esperado = { 2.0, 4.0, 3.0, -4.5 };
        Numeros numeros = new Numeros(entrada);
        double[] obtido = numeros.calcularMediaSeguinte();
        assertArrayEquals(esperado, obtido, DELTA);
    }

    @Test
    public void calcularMediaComArrayVazio() {
        double[] entrada = new double[] { };
        double[] esperado = new double[] { };
        Numeros numeros = new Numeros(entrada);
        double[] obtido = numeros.calcularMediaSeguinte();
        assertArrayEquals(esperado, obtido, DELTA);
    }
    
    @Test
    public void calcularMediaComArrayComUmElemento() {
        double[] entrada = new double[] { 5 };
        double[] esperado = new double[] { };
        Numeros numeros = new Numeros(entrada);
        double[] obtido = numeros.calcularMediaSeguinte();
        assertArrayEquals(esperado, obtido, DELTA);
    }

}
