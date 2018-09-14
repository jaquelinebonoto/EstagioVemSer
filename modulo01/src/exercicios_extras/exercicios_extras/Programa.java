
public class Programa {
    public static void main(String[] args){
        //ler entrada
        int entrada = 1;
        int x = 5;
        int y = 10;
        FormaGeometrica formaGeometrica = FormaGeometricaFactory.criar(entrada, x, y);
        System.out.println(formaGeometrica.calcularArea());  
        int entrada1 = 2;
        int x1 = 5;
        int y1 = 10;
        FormaGeometrica formaGeometrica1 = FormaGeometricaFactory.criar(entrada1, x1, y1);
        System.out.println(formaGeometrica1.calcularArea());    
    }
}