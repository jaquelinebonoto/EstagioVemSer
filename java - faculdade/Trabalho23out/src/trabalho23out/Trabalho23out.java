
package trabalho23out;

import eleicoes.arquivo.Arquivo;
import eleicoes.recursos.Urna;
import eleicoes.votos.Branco;
import eleicoes.votos.Valido;
import eleicoes.votos.Voto;


/**
 *
 * @author 0783170
 */
public class Trabalho23out {


    public static void main(String[] args)  {
        Arquivo<Voto> a = new Arquivo("teste.txt");
        a.abrir("w");
        Voto v = new Valido (2018);
        Voto v2 = new Branco (2017);
        a.gravarObjeto(v);
        a.gravarObjeto(v2);
        a.fechar();
        
        Arquivo<Urna> urna = new Arquivo("urna.txt");
        urna.abrir("w");
        Urna v3 = new Urna();
        Urna v4 = new Urna();
        urna.gravarObjeto(v3);
        urna.gravarObjeto(v4);
        urna.fechar();

        a.abrir("r");
        a.lerObjeto();
        a.fechar();
        
    }
    
}
