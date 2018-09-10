public class Item extends Object {
    private String descricao;
    private int quantidade;

    public Item(String descricao, int quantidade) {
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
    }
    
    // espada.equals(outraEspada);
    @Override
    public boolean equals(Object outroItem) {
        Item outro = (Item)outroItem;
        
        boolean iguais = 
            this.descricao.equals(outro.descricao)
            && this.quantidade == outro.quantidade;
        return iguais;
    }
}