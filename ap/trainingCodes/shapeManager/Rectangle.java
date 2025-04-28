package ap.trainingCodes.shapeManager;

public class Rectangle extends Shape{

    private double width=0, length=0;

    public Rectangle(){}

    public Rectangle(double width, double length, int x, int y){
        super(x, y);
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    public double getArea (){
        return width * length;
    }

}