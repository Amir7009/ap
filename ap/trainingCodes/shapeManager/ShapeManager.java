package ap.trainingCodes.shapeManager;

import java.util.ArrayList;
import java.util.List;

public class ShapeManager {

    private static List<Shape> list = new ArrayList<>();
    private static double totalArea = 0;

    public static void addShape (Shape c){
        list.add(c);
    }

    public static double getTotalArea (){

        for (Shape i : list){
            totalArea += i.getArea();
        }

        return totalArea;

    }
}