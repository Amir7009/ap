package ap.projects.finalProject.storage.tabSplit;

import ap.projects.finalProject.model.Student;

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

        try {

            for(String line : new ArrayList<>(Files.lines(Paths.get(fileName)).toList())){

                String[] items = line.split("\t");
                Student student = new Student(items[0], items[1], items[2], items[3]);
                student.setActive(Boolean.parseBoolean(items[4]));
                student.setNotifications(items[5]);
                student.setLoanHistory(items[6]);
                student.setLoansCount(Integer.parseInt(items[7]));
                student.setLoansCount(Integer.parseInt(items[8]));
                student.setLateLoansCount(Integer.parseInt(items[9]));


                students.put(student.getUsername(), student);
            }


        } catch (IOException e) {
            System.err.println("Error reading students from TabSplit: " + e.getMessage());
            return students;
        }

        return students;
    }

}
