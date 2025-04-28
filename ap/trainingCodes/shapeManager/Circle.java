package ap.trainingCodes.shapeManager;

public class Circle extends Shape{

    private double r = 0;

    public Circle(){}

    public Circle(double r){
        this.r = r;
    }

    public Circle(double r, int x, int y){
        super(x, y);
        this.r = r;
    }

    public double getArea (){
        return Math.PI * r * r;
    }

}