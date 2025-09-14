package ap.projects.finalProject.storage.tabSplit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TabSplitMostLateStudentsIO {

    public static void save(TreeMap<Integer, String> lateStudents, String fileName) {

        try (
                PrintWriter pw = new PrintWriter(new FileOutputStream(
                        fileName))
        ) {
            for (Map.Entry<Integer, String> entry : lateStudents.entrySet()) {
                pw.println(entry.getKey() + "\t" + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error writing late students to TabSplit: " + e.getMessage());
        }
    }

    public static TreeMap<Integer, String> load(String fileName) {

        TreeMap<Integer, String> students = new TreeMap<>();

        try {

            for (String line : new ArrayList<>(Files.lines(Paths.get(fileName)).toList())) {

                String[] items = line.split("\t");
                students.put(Integer.parseInt(items[0]), items[1]);

            }


        } catch (IOException e) {
            System.err.println("Error reading late students from TabSplit: " + e.getMessage());
            return students;
        }

        return students;
    }

}
