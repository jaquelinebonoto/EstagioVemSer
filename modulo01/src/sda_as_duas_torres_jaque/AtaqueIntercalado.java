import java.util.*;
public class AtaqueIntercalado implements Estrategias {
    HashMap<Class, ArrayList<Elfo>> porClasse = new HashMap<>();

    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) {
        for (Elfo elfo : atacantes) { //recebe a lista de elfos
            if (elfo.getStatus() == Status.VIVO) { //testa se está vivo
                this.inicializarListaDeClasse(elfo.getClass());
                porClasse.get(elfo.getClass()).add(elfo);
            }
        }
        ArrayList<Elfo> ordenados = new ArrayList<>(); //o array onde os elfos serão colocados em ordem
        ArrayList<Elfo> elfosVerdes = porClasse.get(ElfoVerde.class); //o array só com elfos verdes
        ArrayList<Elfo> elfosNoturnos = porClasse.get(ElfoNoturno.class); //só com noturnos
        int tamanhoIgualdade=0;
        if (elfosVerdes.size()<elfosNoturnos.size()) tamanhoIgualdade=elfosVerdes.size();
        else tamanhoIgualdade=elfosNoturnos.size();
        int k=0;
        if (atacantes.get(0) instanceof ElfoVerde){
            for (int i = 0; i <= tamanhoIgualdade-1; i++) {
                ordenados.add(k, elfosVerdes.get(i));
                k++;
                ordenados.add(k, elfosNoturnos.get(i));
                k++;
            }
        }
        if (atacantes.get(0) instanceof ElfoNoturno){
            for (int i = 0; i <= tamanhoIgualdade-1; i++) {
                ordenados.add(k, elfosNoturnos.get(i));
                k++;
                ordenados.add(k, elfosVerdes.get(i));
                k++;
            }
        }
        return ordenados;
    }

    private void inicializarListaDeClasse(Class classe) { //
        if (this.porClasse.get(classe) == null) {
            ArrayList<Elfo> elfosPorClasse = new ArrayList<>();
            porClasse.put(classe, elfosPorClasse);
        }
    }

}
