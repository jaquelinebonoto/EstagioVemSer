

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
	double[] entrada = new double[ ] { 1.0, 3.0, 5.0, 1.0, -10.0 };
	Numeros numeros = new Numeros(entrada);
	numeros.calcularMediaSeguinte(); // [2.0,4.0,3.0,-4.5]
 */
public class NumerosTest{
    @Test
    public void calculaMediaArrayProfessor(){
        double[] entrada = new double[ ] {1.0,3.0,5.0,1.0,-10.0};
	Numeros numeros = new Numeros(entrada, 4);
	assertArrayEquals (double []{2.0,4.0,3.0,-4.5},numeros.calcularMediaSeguinte());
    }
}
