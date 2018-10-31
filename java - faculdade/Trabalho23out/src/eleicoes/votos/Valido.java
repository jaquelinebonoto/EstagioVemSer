package eleicoes.votos;

import java.io.Serializable;

/**
 *
 * @author 0783170
 */
public class Valido extends Voto implements Serializable{
    private long eleitor;
    private int candidatoLegenda;
    protected static int contValidos=0;

    public Valido() {
    }

    public Valido(long eleitor, int candidatoLegenda) {
        this.eleitor = eleitor;
        this.candidatoLegenda = candidatoLegenda;
        contValidos++;
    }

    public Valido(long eleitor, int candidatoLegenda, int ano) {
        super(ano);
        this.eleitor = eleitor;
        this.candidatoLegenda = candidatoLegenda;
        contValidos++;
    }

    public Valido(int ano) {
        super(ano);
    }

    public long getEleitor() {
        return eleitor;
    }

    public int getCandidatoLegenda() {
        return candidatoLegenda;
    }

    public static int getContValidos() {
        return contValidos;
    }

    public void setEleitor(long eleitor) {
        this.eleitor = eleitor;
    }

    public void setCandidatoLegenda(int candidatoLegenda) {
        this.candidatoLegenda = candidatoLegenda;
    }

    
    @Override
    public String toString() {
        return "Valido{" + "eleitor=" + eleitor + ", candidatoLegenda=" + candidatoLegenda + '}';
    }
   
}
