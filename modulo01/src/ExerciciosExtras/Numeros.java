public class Numeros {
    
    private double[] numeros;
    
    public Numeros(double[] numeros) {
        this.numeros = numeros;
    }
    
    public double[] calcularMediaSeguinte() {
        boolean possuiNumeros = this.numeros.length > 0; 
        double[] medias = new double[possuiNumeros ? this.numeros.length - 1 : 0];
        for (int i = 0; i < this.numeros.length - 1; i++) {
            medias[i] = (this.numeros[i] + this.numeros[i+1])/2.0;
        }
        return medias;
    }
}