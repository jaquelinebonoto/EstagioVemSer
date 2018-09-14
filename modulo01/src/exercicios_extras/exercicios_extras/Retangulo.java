
public class Retangulo implements FormaGeometrica{
    private double x, y;

    public void setX (double x){
        this.x = x;
    }

    public void setY (double y){
        this.y = y;
    }
    
    public double calcularArea() {
        // put your code here
        return this.x * this.y;
    }
}
