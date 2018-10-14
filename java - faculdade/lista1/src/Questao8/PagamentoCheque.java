
package Questao8;

public class PagamentoCheque extends Pagamento {
    private String data;
    private Cheque cheque;

    public PagamentoCheque() {}

    public PagamentoCheque(String data, Cheque cheque, double total) {
        super(total);
        this.data = data;
        this.cheque = cheque;
    }
    
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Cheque getCheque() {
        return cheque;
    }

    public void setCheque(Cheque cheque) {
        this.cheque = cheque;
    }

    @Override
    public String toString() {
        return "PagamentoCheque{" + "data=" + data + ", cheque=" + cheque + '}';
    }

    
        
}
