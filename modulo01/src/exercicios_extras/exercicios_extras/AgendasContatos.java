import java.util.*;

public class AgendasContatos {
    private HashMap<String, String> agenda = new HashMap<>();
    
    public void adicionar(String nome, String telefone) {
        agenda.put(nome, telefone);
    }
    
    public String consultar(String nome){
        return agenda.get(nome);
    }
    
    /*public String pesquisarPorValor (String telefone){
        for (String key : agenda.keySet()){
            if (agenda.containsValue(telefone));
            telefone. = agenda.hashCode();

        }
    }*/
}

