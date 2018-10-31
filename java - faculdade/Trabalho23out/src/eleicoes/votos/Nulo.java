
package eleicoes.votos;

import java.io.Serializable;

/**
 *
 * @author 0783170
 */
public class Nulo extends Voto implements Serializable{
    protected static int contNulos=0;

    public Nulo() {
        contNulos ++;
    }

    public Nulo(int ano) {
        super(ano);
        contNulos ++;
    }

    public static int getContNulos() {
        return contNulos;
    }

    public Nulo(long eleitor1, int candLegenda, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}

