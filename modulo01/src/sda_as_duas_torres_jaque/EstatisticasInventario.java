import java.util.ArrayList;
public class EstatisticasInventario{
    private InventarioList inventario;

    public EstatisticasInventario(InventarioList inventario){
        this.inventario = inventario;
    }
   
    public double calcularMedia(InventarioList inventario){
        double totalItem=0, soma=0;
        int i=0;
        totalItem = inventario.tamanhoInventario();
        for (i=0; i<totalItem; i++){ 
            soma= soma+ inventario.getItens().get(i).getQuantidade();
        }
        return soma/totalItem;
    }
    
}
