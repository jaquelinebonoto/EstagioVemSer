
package questao1.formas.semlado;
import questao1.formas.*;
import questao1.utils.Cor;

public class Circulo extends Figura{
    private final double PI = Math.PI;
    private double raio;

    public Circulo() {
    }

    public Circulo(double raio) {
        this.raio = raio;
    }
    

    @Override
    public String toString() {
        return "Circulo{" + "PI=" + PI + ", raio=" + raio + '}';
    }

    public double calculaArea() {
        return PI*Math.pow(raio, 2);
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
    
    
}
