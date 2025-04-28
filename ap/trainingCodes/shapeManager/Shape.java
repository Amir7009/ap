package ap.trainingCodes.shapeManager;

public class Shape {

    private final double area = 0;
    private int x=0, y=0;

    public Shape(){}

    public Shape(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double getArea(){
        return area;
    }

    public void getCoordinate(){
        System.out.println("X= " + x + " Y= " + y);
    }

}