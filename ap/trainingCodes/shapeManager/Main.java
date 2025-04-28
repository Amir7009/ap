package ap.trainingCodes.shapeManager;

public class Main {

    public static void main(String[] args) {

        Shape r1 = new Rectangle(3, 4);
        Rectangle r2 = new Rectangle(4, 6, 1, 1);
        Shape c1 = new Circle(3);
        Circle c2 = new Circle(4, 1, 1);
        Shape sh = new Shape();

        ShapeManager.addShape(r1);
        ShapeManager.addShape(r2);
        ShapeManager.addShape(c1);
        ShapeManager.addShape(c2);
        ShapeManager.addShape(sh);

        System.out.println(ShapeManager.getTotalArea());

    }

}