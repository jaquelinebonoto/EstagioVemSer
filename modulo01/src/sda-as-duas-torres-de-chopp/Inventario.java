public class Inventario {
    private Item[] itens;
    private int posicaoAPreencher = 0, itensPreenchidos = 0;

    public Inventario(int quantidadeDeItens) {
        this.itens = new Item[quantidadeDeItens];
    }

    public Inventario() {
        this(99);
    }

    public Item[] getItens() {
        return this.itens;
    }

    public void adicionar(Item item) {
        for (int i = this.posicaoAPreencher; i < this.itens.length; i++) {
            if (this.itens[i] == null) {
                this.itens[i] = item;
                posicaoAPreencher = i + 1;
                itensPreenchidos++;
                break;
            }
        }
    }

    public Item obter(int posicao) {
        return this.itens[posicao];
    }

    public void remover(int posicao) {
        this.itens[posicao] = null;
        posicaoAPreencher = posicao;
        itensPreenchidos--;
    }

    public String getDescricoesItens() {
        StringBuilder descricoes = new StringBuilder(1024);

        for (int i = 0; i < this.itens.length; i++) {
            if (this.itens[i] != null) {
                String descricao = this.itens[i].getDescricao();
                descricoes.append(descricao);
                if (i < this.itensPreenchidos - 1) {
                    descricoes.append(",");
                }
            }
        }

        return descricoes.toString();
    }

    public Item getItemComMaiorQuantidade() {

        int indice = 0, maiorQuantidadeParcial = 0;
        for (int i = 0; i < this.itens.length; i++) {
            if (this.itens[i] != null) {
                int qtdAtual = this.itens[i].getQuantidade();
                if (qtdAtual > maiorQuantidadeParcial) {
                    maiorQuantidadeParcial = qtdAtual;
                    indice = i;
                }
            }
        }
        return this.itens.length > 0 ? this.itens[indice] : null;
    }
}

