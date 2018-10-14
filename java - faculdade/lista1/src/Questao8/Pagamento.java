
package Questao8;

public class Pagamento {
    private double total;

    public Pagamento() {
    }

    public Pagamento(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "total=" + total + '}';
    }
    
}
