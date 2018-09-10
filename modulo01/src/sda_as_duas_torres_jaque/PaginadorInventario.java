import java.util.ArrayList;

public class PaginadorInventario
{
    private InventarioList inventario;

    public PaginadorInventario(InventarioList inventario){
        this.inventario = inventario;
    }

    public void pular (int n){
        limitar(n);
        //inventario.getItens().get(n);
    }
    
    public ArrayList<Item> limitar (int n){
        InventarioList limitar = new InventarioList();
        Item item;
        //PaginadorInventario pager = new PaginadorInventario(inventario);
        for (int i=0; i<=n-1; i++){
            item = inventario.getItens().get(i);
            limitar.adicionar(item);            
        }
        return limitar.getItens();
    }
    
}
