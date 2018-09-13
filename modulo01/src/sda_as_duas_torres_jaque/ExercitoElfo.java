import java.util.*;

public class ExercitoElfo {
    private HashMap<String, Elfo> exercito = new HashMap<>();

    public void alistarElfo (String nome, Elfo elfo){
        if (elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)
            exercito.put(elfo.nome, elfo);
    }
    
/*
    public ArrayList<Elfo> consultaPorStatus(Status status){
         ArrayList<Elfo> elfosVivos = new ArrayList<>();
         
    }*/
    

    
    public Elfo consultar(String nome){
        return exercito.get(nome);
    }
}