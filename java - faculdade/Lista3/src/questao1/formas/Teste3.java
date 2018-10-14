
package questao1.formas;

import questao1.formas.doislados.Quadrado;
import questao1.utils.Cor;

public class Teste3 {
    public static void main(String args[]){
        Figura quad = new Quadrado();
        quad.cor = new Cor (0,0,0);
        System.out.println(quad.toString());
        System.out.println(quad.getCor());
        System.out.println(Figura.getContador());
 }

}
