import java.util.ArrayList;

public class PaginadorInventario
{
    private InventarioList inventario;
    private int marcador;

    public PaginadorInventario(InventarioList inventario){
         this.inventario = inventario;
         this.marcador =0;
    }

    public void pular (int n){
        this.marcador = n;
    }
    
   /* public ArrayList<Item> limitar (int n){
        ArrayList<Item> limitar = new ArrayList<>();
        Item item;
        for (int i=marcador; i<=n-1; i++){
            item = inventario.getItens().get(i);
                    
        }
        return limitar.get(i);
    }*/
}
