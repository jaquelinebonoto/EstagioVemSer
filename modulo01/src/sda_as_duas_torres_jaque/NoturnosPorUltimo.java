  import java.util.*;

public class NoturnosPorUltimo implements Estrategias {
    HashMap<Class, ArrayList<Elfo>> porClasse = new HashMap<>();

    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) {
        for (Elfo elfo : atacantes) { //recebe a lista de elfos
            if (elfo.getStatus() == Status.VIVO) { //testa se está vivo
                this.inicializarListaDeClasse(elfo.getClass());
                porClasse.get(elfo.getClass()).add(elfo);
            }
        }
        ArrayList<Elfo> ordenados = new ArrayList<>(); //o array onde os elfos serão colocados em ordem
        
        if (porClasse.get(ElfoVerde.class)!=null)ordenados.addAll(porClasse.get(ElfoVerde.class)); //adiciona todos os elfo da classe Verde na lista ordenados
        if (porClasse.get(ElfoDaLuz.class)!=null)ordenados.addAll(porClasse.get(ElfoDaLuz.class)); 
        if (porClasse.get(ElfoNoturno.class)!=null)ordenados.addAll(porClasse.get(ElfoNoturno.class));
        return ordenados;
    }

    private void inicializarListaDeClasse(Class classe) { //
        if (this.porClasse.get(classe) == null) {
            ArrayList<Elfo> elfosPorClasse = new ArrayList<>();
            porClasse.put(classe, elfosPorClasse);
        }
    }

}
