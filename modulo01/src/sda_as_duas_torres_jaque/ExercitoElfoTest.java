import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoElfoTest{
    @Test
    public void alistarERetornarElfo (){
        ExercitoElfo army = new ExercitoElfo();
        ElfoVerde doe = new ElfoVerde ("John Doe");
        ElfoNoturno jack = new ElfoNoturno ("Jack Sparrow");
        army.alistarElfo("John Doe", doe);
        army.alistarElfo("Jack Sparrow", jack);
        assertEquals(doe, army.consultar("John Doe"));     
        assertEquals(jack, army.consultar("Jack Sparrow")); 
    }

    @Test
    public void naoPodeAlistarElfoDaLuz (){
        ExercitoElfo army = new ExercitoElfo();
        ElfoDaLuz doe = new ElfoDaLuz ("John Doe");   
        army.alistarElfo("John Doe", doe);
        assertEquals(null, army.consultar("John Doe"));     
    }
    
    @Test
    public void naoPodeAlistarElfo (){
        ExercitoElfo army = new ExercitoElfo();
        Elfo doe = new Elfo ("John Doe");   
        army.alistarElfo("John Doe", doe);
        assertNull (army.consultar("John Doe"));            
    }

    /*
    @Test public void retornarElfosVivos(){
        ExercitoElfo army = new ExercitoElfo();
        ElfoVerde doe = new ElfoVerde ("John Doe");
        ElfoNoturno jack = new ElfoNoturno ("Jack Sparrow");
        army.alistarElfo("John Doe", doe);
        army.alistarElfo("Jack Sparrow", jack);
        jack.setStatus(Status.MORTO);
        ArrayList<Elfos> esperado = new ArrayList (doe);
        assertEquals(esperado, army.vivos(_elfo_)
    }
*/
}
