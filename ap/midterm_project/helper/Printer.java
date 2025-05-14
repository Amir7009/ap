package ap.midterm_project.helper;

import java.util.ArrayList;

public class Printer {

    public <T> void  printObjectInfo(ArrayList<T> objects){

        if (objects.isEmpty()) {
            System.out.println("No items found.");
            return;
        }

        for (T object : objects) {

            System.out.println(object.toString());

        }

    }

}
