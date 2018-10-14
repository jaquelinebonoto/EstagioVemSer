
package questao1.formas.treslados;

import questao1.formas.Figura;

public class TrianguloEquilatero extends Figura{
    private double lado;

    public TrianguloEquilatero() {
    }

    public TrianguloEquilatero(double lado) {
        this.lado = lado;
    }

    @Override
    public String toString() {
        return "TrianguloEquilatero{" + "lado=" + lado + '}';
    }

    @Override
    public double calculaArea() {
        return ((Math.pow(lado, 2.0))/4)*Math.sqrt(3);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

}
