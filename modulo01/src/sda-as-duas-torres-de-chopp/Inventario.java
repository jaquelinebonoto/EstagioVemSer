public class Inventario {
    private Item[] itens;
    
    public Inventario(int quantidadeDeItens) {
        this.itens = new Item[quantidadeDeItens];
    }
    
    public Inventario() {
        this.itens = new Item[99];
    }
    
    public Item[] getItens() {
        return this.itens;
    }
    
    public void adicionar(Item item) {
        for (int i = 0; i < this.itens.length; i++) {
            if (this.itens[i] == null) {
                this.itens[i] = item;
                break;
            }
        }
    }
    
    public Item obter(int posicao) {
        return this.itens[posicao];
    }
    
    public void remover(int posicao) {
        this.itens[posicao] = null;
    }
}