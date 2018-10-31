package eleicoes.recursos;
import static eleicoes.recursos.Situacao.FECHADA;
import eleicoes.votos.Voto;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author 0783170
 */
public class Urna implements Comparable<String>, Serializable { //para ser possível listar por localização.cidade
    private int zona;
    private int secao;
    private final static int MAX_VOTOS=300; //assim eu faria a declaração kk. usei no setVotos
    private Localizacao localizacao;
    private Situacao situacao;
    private LinkedList<Voto> votos;
    
    {
        situacao = FECHADA;
    }

    public Urna() {
    }

    public Urna(int zona, int secao, Situacao situacao) {
        this.zona = zona;
        this.secao = secao;
        this.situacao = situacao;
    }

    
    public Urna(int zona, int secao, Localizacao localizacao, Situacao situacao, LinkedList<Voto> votos) {
        this.zona = zona;
        this.secao = secao;
        this.localizacao = localizacao;
        this.situacao = situacao;
        this.votos = votos;
    }

    public Urna(int zone, int secaoo) {
        this.zona = zone;
        this.secao = secaoo;
    }
    
    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public int getSecao() {
        return secao;
    }

    public void setSecao(int secao) {
        this.secao = secao;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        if (votos.size() <MAX_VOTOS) this.votos = (LinkedList<Voto>) votos;
        else System.out.println("Limite de Votos Excedido");
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        String aux = "";
        if (votos!=null){
        for (Voto voto: votos){
            if (voto!=null)
                    aux += "\n" + voto.toString();
            }
        }
        return "Urna{" + "zona=" + zona + ", secao=" + secao + ", situacao=" + situacao + ", votos=" + aux + "}" + "Localização: " + (localizacao!=null?localizacao.toString():"Invalida");
    }

    @Override
    public int compareTo(String o) {
        throw new UnsupportedOperationException("Método não implementado de fato."); 
    }
    
    
}
