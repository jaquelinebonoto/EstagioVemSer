
/**
 Crie uma classe Numeros, que recebe um array de números racionais 
 (inteiros negativos, positivos ou com precisão numérica) informado 
 na sua criação e que tenha um método calcularMediaSeguinte 
 que retorne um array com a média entre cada número e o número seguinte. 
 */
/*public class Numeros{
    private double[] entrada;
    private double[] media=new double [3];
    private int n;
    
    public Numeros(double []entrada){
        this.entrada = entrada;
    }

    public int calculaTamanhoEntrada (double []entrada){
        n= entrada.length;
        return n;
    }
    
    public double[] calcularMediaSeguinte (){
        for (int i=0; i<=n; i++){
            media[i] = ((entrada[i]+entrada[1+i])/2);
        }
        return media;
    }
}*/

public class Numeros{
    private int n=4;
    private double[] entrada = new double [n];
    private double[] media= new double [n-1];
    
    public Numeros(double []entrada){
        this.entrada = entrada;
    }
   
    public double [] calcularMediaSeguinte (double []entrada){
        for (int i=1; i<n; i++){
            media[i-1] = ((entrada[i]+entrada[i-1])/2);
        }
        return media;
    }
}
