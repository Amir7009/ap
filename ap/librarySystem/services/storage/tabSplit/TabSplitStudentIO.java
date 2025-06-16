package ap.librarySystem.services.storage.tabSplit;

import ap.librarySystem.models.Student;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TabSplitStudentIO {

    public static void save(LinkedHashMap<String, Student> students, String fileName) {

        try (
                PrintWriter pw = new PrintWriter(new FileOutputStream(
                        fileName))
        ) {
            for (Student student : students.values())
                pw.println(student.tabSplit());

        } catch (FileNotFoundException e) {
            System.err.println("Error writing students to TabSplit: " + e.getMessage());
        }
    }

    public static LinkedHashMap<String, Student> load(String fileName) {

        LinkedHashMap<String, Student> students = new LinkedHashMap<>();
        ArrayList<Student> list;

        try {
            list = new ArrayList<>(Files.lines(Paths.get(fileName))
                    .map(s -> s.split("\t"))
                    .map(s -> new Student(s[0], s[1], s[2], s[3], s[4], s[5], s[6]))
                    .toList());

        } catch (IOException e) {
            System.err.println("Error reading students from TabSplit: " + e.getMessage());
            return students;
        }

        for (Student student : list)
            students.put(student.getStudentID(), student);

        return students;
    }

}
