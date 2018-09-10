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
    
    public double calcularMediana(InventarioList inventario){
        int n = inventario.tamanhoInventario(), posicao=n/2;
        double mediana=0;
        if (n%2==0) mediana = (inventario.getItens().get(posicao-1).getQuantidade()+inventario.getItens().get(posicao).getQuantidade())/2.0;
        else mediana= inventario.getItens().get(posicao).getQuantidade();
        return mediana;
    }
    
    public int itensAcimaDaMedia(EstatisticasInventario inventario, InventarioList inventario1){
        double media=0;
        int cont=0;
        media =inventario.calcularMedia(inventario1);
        for (int i=0; i<inventario1.tamanhoInventario(); i++){
            if(inventario1.getItens().get(i).getQuantidade()> media) cont++;
        }  
        return cont;
    }
}
