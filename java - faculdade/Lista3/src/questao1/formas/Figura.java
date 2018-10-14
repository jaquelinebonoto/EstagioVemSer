
package questao1.formas;

import questao1.utils.Cor;


public abstract class Figura {
    private static int contador;
    protected Cor cor;

    public Figura() {
        contador++;
    }  
    public abstract double calculaArea ();
    public static int getContador() {
        return contador;
    }
    @Override
    public abstract String toString();

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
    
    
}
