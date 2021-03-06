package classes;

public class Cpf implements Comparable {

    private long numero;
    private int digito;

    public Cpf() {
    }

    public Cpf(long numero, int digito) {
        super();
        this.numero = numero;
        this.digito = digito;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    @Override
    public String toString() {
        return "Cpf [numero=" + numero + ", digito=" + digito + "]";
    }

    @Override
    public int compareTo(Object obj) {
        Cpf objCpf = (Cpf) obj;
        if (getNumero() == objCpf.getNumero()) {
            return 0;
        } else if (getNumero() < objCpf.getNumero()) {
            return -1;
        } else {
            return 1;
        }

    }

}
