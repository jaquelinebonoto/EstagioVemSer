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
    
<<<<<<< HEAD:modulo01/src/sda_as_duas_torres_jaque/Item.java
    //espada.equals(outraEspada)
    public boolean equals(Object outroItem){
        Item outro = (Item)outroItem;
        boolean iguais = this.descricao.equals(outro.getDescricao())
                            && this.quantidade == outro.getQuantidade();
        return iguais;        
    }
}
=======
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
>>>>>>> master:modulo01/src/sda-as-duas-torres-de-chopp/Item.java
