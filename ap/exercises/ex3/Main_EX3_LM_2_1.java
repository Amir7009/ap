package ap.exercises.ex3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_EX3_LM_2_1 {

    public static void main(String[] args) {

        // Add students
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Amir Hossein", "Mohebbi", "112233", "Computer"));
        students.add(new Student("Amir Mohammad", "Najafi", "332211", "Computer"));
        students.add(new Student("Hamed", "Jalal Mousavi", "331122", "Electrical"));

        // Add books
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Namira", "Sadegh Karamyar", "120", "1398"));
        books.add(new Book("Kimiaghar", "Paolo Kuiilo", "90", "2008"));
        books.add(new Book("Animal Farm", "George Orvel", "96", "1402"));
        books.add(new Book("Otello", "William", "54", "1500"));


        // Search student
        searchStudent (students);

        // Borrow a book
        String[][] lentBooks = new String[10][2];
        System.out.println("Enter a book title to borrow: ");
        Scanner input = new Scanner(System.in);
        String temp = input.nextLine();
        boolean allow = true;
        for (int i=0 ; i < books.size() && allow ; i++){
            if (temp.equalsIgnoreCase(books.get(i).getTitle()) ){
                if (books.get(i).isBorrowed){
                    System.out.println("The book is already borrowed!");
                }
                else{
                    System.out.println("Enter yor name: ");
                    books.get(i).setBorrowerName(input.nextLine());
                    System.out.println("The book borrowed successfully!" );
                    books.get(i).isBorrowed = true;
                }
                allow = false;
            }
        }
        if (allow) {
            System.out.println("The book Not found!");
        }

        // Create file for save to file
        File file1 = new File("students.txt");
        File file2 = new File("books.txt");
        File file3 = new File("borrow.txt");
        try { // create backup file
            file1.createNewFile(); // Create backup file.
            file2.createNewFile();
            file3.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Call for save data
        saveArraysToFile(students, books);

        // Load files
        ArrayList<Student> loadStudents = new ArrayList<>();
        ArrayList<Book> loadBooks = new ArrayList<>();
        loadFiles(loadStudents, loadBooks, lentBooks);

    }

    private static void saveArraysToFile(ArrayList<Student> students, ArrayList<Book> books) {
        try { // to empty file
            FileWriter fileWriter = new FileWriter("students.txt", false);
            fileWriter.close();
            FileWriter fileWriter2 = new FileWriter("books.txt", false);
            fileWriter2.close();
            FileWriter fileWriter3 = new FileWriter("borrow.txt", false);
            fileWriter3.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try { // to write file
            PrintWriter out = new PrintWriter("students.txt");
            PrintWriter out2 = new PrintWriter("books.txt");
            PrintWriter out3 = new PrintWriter("borrow.txt");

            // write students
            for (Student student : students) {
                out.println("\n" + student.getfName());
                out.println(student.getlName());
                out.println(student.getStCode());
                out.print(student.getStudyingField());
            }
            out.close();

            // write books
            for (Book book : books) {
                out2.println("\n" + book.getTitle());
                out2.println(book.getAuthor());
                out2.println(book.getPages());
                out2.print(book.getYear());
                if (book.isBorrowed){
                    out3.println("\n" + book.getTitle());
                    out3.print(book.getBorrowerName());
                }
            }
            out2.close();
            out3.close();

        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadFiles(ArrayList<Student> loadStudents, ArrayList<Book> loadBooks, String[][] lentBooks) {
        // Read from files
        Scanner text1 = null;
        Scanner text2 = null;
        Scanner text3 = null;
        try {
            text1 = new Scanner(new File("students.txt"));
            text2 = new Scanner(new File("books.txt"));
            text3 = new Scanner(new File("borrow.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Read students
        text1.nextLine();
        for (int j = 0 ; j <= loadStudents.size() && text1.hasNext(); j++) {
            loadStudents.add(new Student(null, null, null, null));
            loadStudents.get(j).setfName(text1.nextLine());
            loadStudents.get(j).setlName(text1.nextLine());
            loadStudents.get(j).setStCode(text1.nextLine());
            loadStudents.get(j).setStudyingField(text1.nextLine());
        }
        text1.close();

        // Read books
        text2.nextLine();
        for (int i=0 ; i <= loadBooks.size() && text2.hasNext(); i++){
            loadBooks.add(new Book(null, null, null, null));
            loadBooks.get(i).setTitle(text2.nextLine());
            loadBooks.get(i).setAuthor(text2.nextLine());
            loadBooks.get(i).setPages(text2.nextLine());
            loadBooks.get(i).setYear(text2.nextLine());
        }
        text2.close();

        // Read borrow data
        text3.nextLine();
        for (int k=0 ; k<10 && text3.hasNext() ; k++){
            lentBooks[k][0] = text3.nextLine();
            lentBooks[k][1] = text3.nextLine();
        }
    }

    private static void searchStudent (ArrayList<Student> students){
        System.out.println("Please Enter student's last name for search: ");
        Scanner input = new Scanner(System.in);
        String tmp = input.nextLine();
        int i = 0;
        for (Student student : students) {
            if (tmp.equalsIgnoreCase(student.getlName())) {
                System.out.print("First name: " + student.getfName());
                System.out.print("\nSt code: " + student.getStCode());
                System.out.println("\nStudying field: " + student.getStudyingField());
                i++;
            }
        }
        if (i == 0){
            System.out.println("Not found!");
        }
    }
}

class Student {
    private String fName, lName, stCode, studyingField;

    public Student(String fName, String lName, String stCode, String studyingField) {
        this.fName = fName;
        this.lName = lName;
        this.stCode = stCode;
        this.studyingField = studyingField;
    }

    // getter methods
    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getStCode() {
        return stCode;
    }

    public String getStudyingField() {
        return studyingField;
    }

    // setter methods (also for edit attributes)
    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setStCode(String stCode) {
        this.stCode = stCode;
    }

    public void setStudyingField(String studyingField) {
        this.studyingField = studyingField;
    }

}

class Book {
    private String title, author, pages, year, borrowerName;
    boolean isBorrowed;

    public Book(String title, String author, String pages, String year) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
        this.isBorrowed = false;
    }

    // getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPages() {
        return pages;
    }

    public String getYear() {
        return year;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    // setter methods (also for edit attributes)
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }
}