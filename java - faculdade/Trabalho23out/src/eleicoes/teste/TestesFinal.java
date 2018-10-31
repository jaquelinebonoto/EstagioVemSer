
package eleicoes.teste;


import eleicoes.votos.*;
import eleicoes.recursos.*;
import static eleicoes.recursos.Situacao.ABERTA;
import static eleicoes.recursos.Situacao.FECHADA;
import java.util.LinkedList;


/**
 *
 * @author 0783170
 */
public class TestesFinal {
    public static void main(String[] args) {
        
    //1 - Cadastra uma urna
    Urna u = new Urna(148, 253, null, FECHADA, null);

    //2- Abre Urna
    u.setSituacao(ABERTA);

    //3 - Cadastra um voto
    Voto v = new Valido();
    Voto v1 = new Nulo();
    Voto v2 = new Valido();
    LinkedList <Voto> votos = new LinkedList <>();
    votos.add(v);
    votos.add(v1);
    votos.add(v2);
    u.setVotos(votos);
    
    
    //4 - Fechar Urna, Mostrar total de votos, e o total por tipo de voto.
    u.setSituacao(FECHADA);
    System.out.println("Total de Votos " + Voto.getContador());
    System.out.println("Total de Votos Válidos: " + Valido.getContValidos());
    System.out.println("Total de Votos Nulos: " + Nulo.getContNulos());
    System.out.println("Total de Votos Brancos: " + Branco.getContBrancos());
    System.out.println("Status da Urna: "+ u.getSituacao().toString());   
    }
}
