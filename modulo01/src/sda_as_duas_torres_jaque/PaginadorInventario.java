import java.util.ArrayList;

public class PaginadorInventario {
    private Inventario inventario;
    private int marcador;

    public PaginadorInventario(Inventario inventario) {
        this.inventario = inventario;
        this.marcador = 0;
    }
    
    public void pular(int marcador) {
        this.marcador = marcador;
    }

    public ArrayList<Item> limitar(int qtd) {
        ArrayList<Item> subConjunto = new ArrayList<>();
        int fim = this.marcador + qtd;
        for (int i = this.marcador; i < fim && i < this.inventario.getItens().size(); i++) {
            subConjunto.add(this.inventario.obter(i));
        }
        return subConjunto;
    }
}
