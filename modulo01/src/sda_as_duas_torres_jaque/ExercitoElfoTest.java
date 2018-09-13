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
        //assertEquals(jack, army.consultar("Mithrandir")); 
    }

}
