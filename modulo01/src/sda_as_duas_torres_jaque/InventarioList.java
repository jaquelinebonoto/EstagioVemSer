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
        for(i = 1; i < this.itens.size()-1; i ++){  
            String description = itens.get(i).getDescricao();
            if(description.equals(descricao)) break;
            //if (i==this.itens.size()-2 && !(description.equals(descricao))) itens.get(0);
        }
        return itens.get(i);
    }

    public InventarioList inverter(){
        InventarioList invertida = new InventarioList();
        for (int i=this.itens.size()-1; i>=0; i--){
            invertida.adicionar(this.itens.get(i));    
        }
        return invertida;
    }
}
