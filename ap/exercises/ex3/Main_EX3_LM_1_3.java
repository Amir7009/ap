package ap.exercises.ex3;

import java.io.*;
import java.util.Scanner;

public class Main_EX3_LM_1_3 {
    public static void main(String[] args) {
        String[][] studentsList = new String[3][4];
        String[][] booksList = new String[4][4];
        int studentsCount=0, booksCount=0;

        // Student instants
        StudentClass student1 = new StudentClass("Amir Hossein", "Mohebbi", "112233", "Computer" );
        studentsCount++;
        saveStudentToArray (student1, studentsList, studentsCount-1);
        StudentClass student2 = new StudentClass("Amir Mohammad", "Najafi", "332211", "Computer" );
        studentsCount++;
        saveStudentToArray (student2, studentsList, studentsCount-1);
        StudentClass student3 = new StudentClass("Hamed", "Jalal Mousavi", "331122", "Electrical" );
        studentsCount++;
        saveStudentToArray (student3, studentsList, studentsCount-1);

        // Book instants
        BookClass myBook1 = new BookClass("Namira", "Sadegh Karamyar", "120", "1398");
        booksCount++;
        saveBookToArray(myBook1, booksList, booksCount-1);
        BookClass myBook2 = new BookClass("Kimiaghar", "Paolo Kuiilo", "90", "2008");
        booksCount++;
        saveBookToArray(myBook2, booksList, booksCount-1);
        BookClass myBook3 = new BookClass("Animal Farm", "George Orvel", "96", "1402");
        booksCount++;
        saveBookToArray(myBook3, booksList, booksCount-1);
        BookClass myBook4 = new BookClass("Otello", "William", "54", "1500");
        booksCount++;
        saveBookToArray(myBook4, booksList, booksCount-1);

        // Create file for save to file
        File file1 = new File("students.txt");
        File file2 = new File("books.txt");
        try { // create backup file
            file1.createNewFile(); // Create backup file.
            file2.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Call method for save data
        saveArraysToFile(studentsList, booksList);

        // Call method for read from files
        String[][] studentReadList = new String[3][4];
        String[][] bookReadList = new String[4][4];
        loadFiles(studentsCount, booksCount, studentReadList, bookReadList);

        // Search a student
        searchStudent(studentsList);
    }

    static void saveArraysToFile (String[][] studentsList, String[][] booksList){
        try { // to empty file
            FileWriter fileWriter = new FileWriter("students.txt", false);
            fileWriter.close();
            FileWriter fileWriter2 = new FileWriter("books.txt", false);
            fileWriter2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try { // to write file
            PrintWriter out = new PrintWriter("students.txt");
            PrintWriter out2 = new PrintWriter("books.txt");

            // write students
            for (String[] row : studentsList){
                for (String i : row) {
                    out.println(i);
                }
            }
            out.close();

            // write books
            for (String[] row : booksList){
                for (String i : row) {
                    out2.println(i);
                }
            }
            out2.close();

        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static void loadFiles(int studentsCount, int booksCount, String[][] studentReadList, String[][] bookReadList){
        // Read from files
        Scanner text1 = null;
        Scanner text2 = null;
        try {
            text1 = new Scanner(new File("students.txt"));
            text2 = new Scanner(new File("books.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Read students
        for (int i=0 ; i < studentsCount ; i++){
            for (int j=0 ; j < 4 ; j++){
                studentReadList[i][j] = text1.nextLine();
            }
        }
        text1.close();

        // Read books
        for (int i=0 ; i < booksCount ; i++){
            for (int j=0 ; j < 4 ; j++){
                bookReadList[i][j] = text2.nextLine();
            }
        }
        text2.close();
    }

    private static void saveStudentToArray(StudentClass student, String[][] studentsList, int index){
        studentsList[index][0] = student.getfName();
        studentsList[index][1] = student.getlName();
        studentsList[index][2] = student.getStCode();
        studentsList[index][3] = student.getStudyingField();
    }

    private static void saveBookToArray(BookClass book, String[][] booksList, int index){
        booksList[index][0] = book.getTitle();
        booksList[index][1] = book.getAuthor();
        booksList[index][2] = book.getPages();
        booksList[index][3] = book.getYear();
    }

    private static void searchStudent (String[][] studentsList){
        System.out.println("Please Enter student's last name: ");
        Scanner input = new Scanner(System.in);
        String tmp = input.nextLine();
        for (int i=0 ; i < studentsList.length ; i++){
            if ( tmp.equalsIgnoreCase(studentsList[i][1])){
                System.out.print("First name: " + studentsList[i][0]);
                System.out.print("\nSt code: " + studentsList[i][2]);
                System.out.print("\nStudying field: " + studentsList[i][3]);
            }
        }
    }
}

class StudentClass{
    private String fName, lName, stCode, studyingField;

    public StudentClass(String fName, String lName, String stCode, String studyingField ){
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

class BookClass{
    private String title, author, pages, year;

    public BookClass(String title, String author, String pages, String year ){
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
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
}