public class EstatisticasInventario {

    private Inventario inventario;

    public EstatisticasInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public double calcularMedia() {
        if (this.inventario.vazio()) {
            return Double.NaN;
        }
        double somaQtds = .0;
        for (Item item : inventario.getItens()) {
            somaQtds += item.getQuantidade();
        }
        return somaQtds / inventario.getItens().size();
    }

    public double calcularMediana() {
        if (this.inventario.vazio()) {
            return Double.NaN;
        }
        this.inventario.ordenarItens();
        int qtdItens = this.inventario.getItens().size();
        int meio = qtdItens / 2;
        boolean qtdImpar = qtdItens % 2 == 1;
        if (qtdImpar) {
            return this.inventario.obter(meio).getQuantidade();
        }
        int qtdMeioMenosUm = this.inventario.obter(meio - 1).getQuantidade();
        int qtdMeio = this.inventario.obter(meio).getQuantidade();
        return (qtdMeioMenosUm + qtdMeio) / 2.;
    }
    
    public int qtdItensAcimaDaMedia() {
        double media = this.calcularMedia();
        int qtdAcima = 0;
        
        for (Item item : this.inventario.getItens()) {
            if (item.getQuantidade() > media) {
                qtdAcima++;
            }
        }
        return qtdAcima;
    }
}