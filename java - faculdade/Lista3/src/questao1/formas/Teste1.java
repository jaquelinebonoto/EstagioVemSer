
package questao1.formas;

import questao1.formas.doislados.Quadrado;
import questao1.formas.semlado.Circulo;
import questao1.formas.treslados.TrianguloEquilatero;

public class Teste1 {
    public static void main(String args[]){
        Figura vet[] = new Figura[4];
        //vet[0] = new Figura() {};
        vet[0] = new Quadrado(5.1);
        vet[1] = new Quadrado(5.5);
        vet[2] = new Circulo(12.0);
        vet[3] = new TrianguloEquilatero(15);
        for(Figura f: vet){
         System.out.println(f.calculaArea());
    }
 }

}
