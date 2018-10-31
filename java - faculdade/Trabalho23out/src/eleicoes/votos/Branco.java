/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleicoes.votos;

import java.io.Serializable;

/**
 *
 * @author 0783170
 */
public class Branco extends Voto implements Serializable {
    protected static int contBrancos=0;
        private long eleitor;

    public Branco() {
        contBrancos ++;
    }

    public Branco(int ano) {
        super(ano);
        contBrancos ++;
    }

    public static int getContBrancos() {
        return contBrancos;
    }    

    public Branco(long eleitor1, int i) {
        super();
        this.eleitor = eleitor1;
        contBrancos ++;        
    }
}
