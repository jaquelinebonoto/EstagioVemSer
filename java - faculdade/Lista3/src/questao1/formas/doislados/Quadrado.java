
package questao1.formas.doislados;

import questao1.formas.Figura;


public final class  Quadrado extends Figura{
    private double lado;

    public Quadrado() {
    }

    public Quadrado(double lado) {
        this.lado = lado;
    }
   
    @Override
    public String toString() {
        return "Quadrado{" + "lado=" + lado + '}';
    }

    @Override
    public double calculaArea() {
        return Math.pow(lado, 2);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    
    
}
