package ap.midterm_project.helper;

import ap.midterm_project.models.Book;
import ap.midterm_project.models.Librarian;
import ap.midterm_project.models.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadFromFile {

    public  ArrayList<Book> loadBooks(String filePath) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                books.add(Book.fromString(line));
            }
            scanner.close();
            System.out.println("Books loaded!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
        return books;

    }

    public  ArrayList<Student> loadStudents(String filePath) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                students.add(Student.fromString(line));
            }
            scanner.close();
            System.out.println("Students loaded!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
        return students;

    }

    public  ArrayList<Librarian> loadLibrarians(String filePath) {
        ArrayList<Librarian> librarians = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                librarians.add(Librarian.fromString(line));
            }
            scanner.close();
            System.out.println("Librarians loaded!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
        return librarians;
    }

}
