import java.util.Arrays;
import java.util.ArrayList;

public class ElfoVerde extends Elfo {

    private final ArrayList<String> DESCRICOES_PERMITIDAS = new ArrayList<>(Arrays.asList(
                "Espada de aço valiriano",
                "Arco de Vidro",
                "Flecha de Vidro"
            ));

    public ElfoVerde(String nome) {
        super(nome);
        QTD_EXPERIENCIA *= 2;
    }

    public void ganharItem(Item item) {
        boolean descricaoValida = DESCRICOES_PERMITIDAS.contains(item.getDescricao());
        if (descricaoValida) {
            this.inventario.adicionar(item);
        }
    }
}

