package eleicoes.recursos;

import java.io.Serializable;

/**
 *
 * @author 0783170
 */
public final class Localizacao implements Serializable { //aqui onde defino localizacao como final
    //esta classe não poderia ter subclasses. se houvesse algum método abstrato
    //chegando até ela de alguma superclasse, teria que ser implementado aqui.
    //PROTEGE E AUMENTA O DESEMPENHO DO CÓDIGO
    private String cidade;
    private String uf;

    public Localizacao() {
    }

    public Localizacao(String cidade, String uf) {
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Localizacao{" + "cidade=" + cidade + ", uf=" + uf + '}';
    }
    
}
