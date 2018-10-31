package eleicoes.votos;

import java.io.Serializable;

/**
 *
 * @author 0783170
 */
public abstract class Voto implements Serializable {
    int ano;
    private static int contador=0;

    public Voto() {
        contador++;
    }

    public Voto(int ano) {
        this.ano = ano;
        contador++;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public static int getContador() { //não deve ser declarado como obstrato pq precisamos implementar ele aqui também, pela classe voto
        return contador; //e iremos querer saber o total de votos sem precisar somar Valido + nulo + branco
    } 

    @Override
    public String toString() {
        return "Voto{" + "ano=" + ano + '}';
    }
   
}
