public class FormaGeometricaFactory {
    public static FormaGeometrica criar (int tipo, double x, double y){
        FormaGeometrica formaGeometrica = null;
        switch(tipo){
            case 1:
            formaGeometrica = new Retangulo();
            break;
            case 2:
            formaGeometrica = new Quadrado();
            break;
        }
        formaGeometrica.setX(x);
        formaGeometrica.setY(y);
        return formaGeometrica;
    }
}
