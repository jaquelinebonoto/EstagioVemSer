import java.util.*;

public class ExercitoElfo {
    private HashMap<String, Elfo> exercito = new HashMap<>();

    public void alistarElfo (String nome, Elfo elfo){
        if (elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)
            exercito.put(elfo.nome, elfo);
    }

    public ArrayList<Elfo> vivos (Elfo elfo) {
        ArrayList<Elfo> elfosVivos = new ArrayList<>();
        if (elfo.getStatus()==Status.VIVO)
            elfosVivos.add(elfo);
        return elfosVivos;
    }

    public Elfo consultar(String nome){
        return exercito.get(nome);
    }
}