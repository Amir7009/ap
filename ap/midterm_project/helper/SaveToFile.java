package ap.midterm_project.helper;

import ap.midterm_project.dataBase.Library;
import ap.midterm_project.models.Librarian;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SaveToFile {

    public <T> void save(ArrayList<T> objects, String filePath){

        try {
            PrintWriter writer = new PrintWriter(filePath); // clear file to write again
            for (T item : objects) {
                writer.println(item.toString()); // an objet per one line
            }
            writer.close();
            System.out.println("saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
