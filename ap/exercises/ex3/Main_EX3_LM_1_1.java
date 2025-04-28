package ap.exercises.ex3;

import java.util.Scanner;

public class Main_EX3_LM_1_1 {
    public static void main(String[] args) {
        // Book instants
        BooksClass myBook1 = new BooksClass("Namira", "Sadegh Karamyar", 120, 1398);
        BooksClass myBook2 = new BooksClass("Kimiaghar", "Paolo Kuiilo", 90, 2008);

        // Student instants
        StudentsClass student1 = new StudentsClass("Amir Hossein", "Mohebbi", "112233", "Computer" );
        StudentsClass student2 = new StudentsClass("Amir Mohammad", "Najafi", "332211", "Computer" );
    }
}

class StudentsClass{
    private String fName, lName, stCode, studyingField;

    public StudentsClass(String fName, String lName, String stCode, String studyingField ){
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

class BooksClass{
    private String title, author;
    private int pages, year;

    public BooksClass(String title, String author, int pages, int year ){
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
    public int getPages() {
        return pages;
    }
    public int getYear() {
        return year;
    }

    // setter methods (also for edit attributes)
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public void setYear(int year) {
        this.year = year;
    }
}