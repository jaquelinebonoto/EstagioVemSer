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
    
    public boolean vazio() {
        return this.itens.isEmpty();
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
    
    public Item buscar(String descricao) {
        for (int i = 0; i < this.itens.size(); i++) {
            Item itemAtual = this.itens.get(i);
            if (itemAtual.getDescricao().equals(descricao)) {
                return itemAtual;
            }
        }
        return null;
    }
    
    public ArrayList<Item> inverter() {
        ArrayList<Item> listaInvertida = new ArrayList<>(this.itens.size());
        for (int i = this.itens.size() - 1; i >= 0; i--) {
            listaInvertida.add(this.itens.get(i));
        }
        return listaInvertida;
    }
    
    public void ordenarItens() {
        ordenarItens(TipoOrdenacao.ASC);
    }
    
    public void ordenarItens(TipoOrdenacao tipoOrdenacao) {
        for (int i = 0; i < this.itens.size(); i++) {
            for (int j = 0; j < this.itens.size() - 1; j++) {
                Item atual = this.itens.get(j);
                Item proximo = this.itens.get(j + 1);
                boolean deveTrocar = tipoOrdenacao == TipoOrdenacao.ASC ? atual.getQuantidade() > proximo.getQuantidade() : atual.getQuantidade() < proximo.getQuantidade();
                if (deveTrocar) {
                    Item itemTrocado = atual;
                    this.itens.set(j, proximo);
                    this.itens.set(j + 1, itemTrocado);
                }
            }
        }
    }
}