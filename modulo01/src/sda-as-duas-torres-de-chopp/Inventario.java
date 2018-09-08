import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> itens;

    public Inventario() {
        this(0);
    }
    
    public Inventario(int quantidadeDeItens) {
        this.itens = new ArrayList<>(quantidadeDeItens);
    }

    public ArrayList<Item> getItens() {
        return this.itens;
    }

    public void adicionar(Item item) {
        this.itens.add(item);
    }

    public Item obter(int posicao) {
        return this.itens.get(posicao);
    }

    public void remover(int posicao) {
        this.itens.remove(posicao);
    }

    public String getDescricoesItens() {
        StringBuilder descricoes = new StringBuilder();
        for (int i = 0; i < this.itens.size(); i++) {
            if (this.itens.get(i) != null) {
                String descricao = this.itens.get(i).getDescricao();
                descricoes.append(descricao);
                boolean deveColocarVirgula = i < this.itens.size() - 1;
                if (deveColocarVirgula) {
                    descricoes.append(",");
                }
            }
        }

        return descricoes.toString();
    }

    public Item getItemComMaiorQuantidade() {

        int indice = 0, maiorQuantidadeParcial = 0;
        for (int i = 0; i < this.itens.size(); i++) {
            if (this.itens.get(i) != null) {
                int qtdAtual = this.itens.get(i).getQuantidade();
                if (qtdAtual > maiorQuantidadeParcial) {
                    maiorQuantidadeParcial = qtdAtual;
                    indice = i;
                }
            }
        }
        return !this.itens.isEmpty() ? this.itens.get(indice) : null;
    }
}

