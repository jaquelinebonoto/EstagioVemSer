package conjuntos;
import java.util.*;

public class Conjunto2 {

    public static void main(String[] args) {
        Set<String> cidades = new LinkedHashSet<>();
        cidades.add("Porto Alegre");
        cidades.add("Canoas");
        cidades.add("Alvorada");
        cidades.add("Viamão");
        for (String cidade : cidades) {
            System.out.println(cidade);
        }

    }

}
