import java.util.Random;

public class DadoD6 implements Sorteador {
    public int sortear() {
        Random random = new Random(); //classe que contem metodo para gerar numero aleatorio
        return random.nextInt(6) + 1; //aqui informa até que numero deverá gerar. o +1 é porque ele parte de zero por padrão
    }
}