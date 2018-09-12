
public class ItemImperdivel extends Item {

    public ItemImperdivel(String descricao, int quantidade){
        super(descricao, quantidade);
    }

    public void setQuantidade(int novaQuantidade){
        if (novaQuantidade >0) this.quantidade = novaQuantidade;
    }
}
