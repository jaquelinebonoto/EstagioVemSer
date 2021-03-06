import java.util.*;

public class AgendasContatos {
    private HashMap<String, String> agenda = new LinkedHashMap<>();
    
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
    
    public String csv() {
        StringBuilder builder = new StringBuilder();
        String separator = System.lineSeparator();
        for(HashMap.Entry<String, String> par: agenda.entrySet()){
            String chave = par.getKey();
            String valor = par.getValue();
            String contato = String.format("%s,%s%s", chave, valor, separator);
            builder.append(contato);
        }
        return  builder.toString();
    }
}

