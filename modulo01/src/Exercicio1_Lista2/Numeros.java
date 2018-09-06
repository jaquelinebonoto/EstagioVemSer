
/**
 Crie uma classe Numeros, que recebe um array de números racionais 
 (inteiros negativos, positivos ou com precisão numérica) informado 
 na sua criação e que tenha um método calcularMediaSeguinte 
 que retorne um array com a média entre cada número e o número seguinte. 
 */
public class Numeros{
    double[] entrada;
    double[] media;
    int n;
    
    public Numeros(double []entrada, int n){
        this.entrada = entrada;
        this.n = n;
    }

    public double calcularMediaSeguinte (double []entrada){
        int i=0;
        for (i=0; i<n; i++){
            media[i] = (entrada[i]+entrada[i+1]/2);
        }
        return media[n];
    }
}
