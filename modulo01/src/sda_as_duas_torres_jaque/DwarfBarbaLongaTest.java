import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfBarbaLongaTest {

    private final double DELTA = 0.1;

    @Test
    public void dwarfDevePerderVida66Percent() { //para perder vida ele deverá tirar no dado um valor de 1 a 4
        DadoFalso dadoFalso = new DadoFalso(); //criamos um dado falso
        dadoFalso.simularValor(4); //queremos que o resultado seja 4
        Dwarf balin = new DwarfBarbaLonga("Balin", dadoFalso); //o dwarf barba longa recebe o dado falso
        balin.perderVida();
        assertEquals(100.0, balin.getVida(), DELTA); //deve perder 10. de vida.
    }

    @Test
    public void dwarfNaoDevePerderVida33Percent() { //não perdder neste caso será valor 5 ou 6
        DadoFalso dadoFalso = new DadoFalso();
        dadoFalso.simularValor(5);
        Dwarf balin = new DwarfBarbaLonga("Balin", dadoFalso);
        balin.perderVida();
        assertEquals(110.0, balin.getVida(), DELTA);
    }
}
