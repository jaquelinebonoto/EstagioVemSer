import java.util.*;

public class NoturnosPorUltimo implements Estrategias{
    List<Elfo> ordenados = new ArrayList<>();
    
    
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes){
        for (int i=0; i<=atacantes.size(); i++){
             if (atacantes instanceof ElfoVerde) ordenados.add(atacantes.get(i));
             
        }
       
        return ordenados;
    }
}
