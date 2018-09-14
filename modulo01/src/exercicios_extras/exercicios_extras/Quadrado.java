
public class Quadrado implements FormaGeometrica {
    
    private double x=0.;
    private double y=1.;

    public void setX (double x){
        this.x = x;
    }

    public void setY (double y){
        this.y = y;
    }

    public double calcularArea() {
        // put your code here
        return Math.pow(x, 2);
    }
    
}
