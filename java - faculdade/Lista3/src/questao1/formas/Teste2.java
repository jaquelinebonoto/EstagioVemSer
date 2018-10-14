
package questao1.formas;

import questao1.formas.semlado.Circulo;
import questao1.utils.Cor;

public class Teste2 {
    public static void main(String args[]){
        Figura obj = new Circulo();
        System.out.println(obj.getContador());
        System.out.println(Figura.getContador());
        Figura objec = new Circulo();
        System.out.println(Figura.getContador());
        
        Circulo objeto = new Circulo(3.0);
        objeto.cor = new Cor(255, 255, 255);
        //objeto.contador = 0;
        //objeto.raio = 3.0;
        //System.out.println(objeto.PI);
        //System.out.println(Circulo.PI);
        System.out.println(objeto.calculaArea() + " /  " + objeto.getRaio());
    }
}
