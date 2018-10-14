
package Questao8;

public class Cheque {
    private int numero;
    private int banco;
    private int agencia;

    public Cheque() {}

    public Cheque(int numero, int banco, int agencia) {
        this.numero = numero;
        this.banco = banco;
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getBanco() {
        return banco;
    }

    public void setBanco(int banco) {
        this.banco = banco;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "Cheque{" + "numero=" + numero + ", banco=" + banco + ", agencia=" + agencia + '}';
    }
    
}
