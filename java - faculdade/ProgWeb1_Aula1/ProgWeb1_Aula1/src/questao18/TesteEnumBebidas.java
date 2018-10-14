
package questao18;

import questao19.Enumeracoes;

public class TesteEnumBebidas {
    public static void main(String[] args) {
        System.out.println(Bebida.CocaCola + 
                          ": R$" + Bebida.CocaCola.getPreco());
        
        for (Bebida bebida : Bebida.values()) {
            System.out.println( bebida.toString());
        }
    }
}
