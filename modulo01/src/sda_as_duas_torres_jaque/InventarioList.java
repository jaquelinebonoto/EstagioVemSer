import java.util.ArrayList;


public class InventarioList {
    private ArrayList<Item> itens;

    public InventarioList() {
        itens = new ArrayList<>();
    }

    public ArrayList<Item> getItens() {
        return this.itens;
    }
    
    public void adicionar(Item item) {
        itens.add(item);
    }
    
    public int tamanhoInventario (){
        return itens.size();
    }
    
    public Item buscarItem(String descricao){
        int i = 0;
        StringBuilder descricoes = new StringBuilder();
        for(i = 0; i < this.itens.size(); i ++){  
            String description = itens.get(i).getDescricao();
            if(description.equals(descricao)) break;
        }
        return itens.get(i);
    }

}
