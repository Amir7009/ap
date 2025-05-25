package ap.midterm_project.database;

import ap.midterm_project.models.Borrow;
import ap.midterm_project.models.Request;
import ap.midterm_project.models.Book;
import ap.midterm_project.models.Librarian;
import ap.midterm_project.models.LibraryManager;
import ap.midterm_project.models.Student;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private String libraryName;

    public Library(String name) {

        this.libraryName = name;

    }

    // instantiate one manager and two librarians at first
    private ArrayList<LibraryManager> libraryManager = new ArrayList<>(List.of(
            new LibraryManager(
                    "10203040",
                    "Amir Hossein",
                    "Mohebbi",
                    "Diploma"
            )));

    private ArrayList<Librarian> librarians = new ArrayList<>(
//            Arrays.asList(
//            new Librarian("12345678", "Hamid", "Naghiloo"),
//            new Librarian("87654321", "Saeed", "Taghiloo")
    );

    // declare lists of library data
    private ArrayList<Student> libraryStudents = new ArrayList<>();

    private ArrayList<Borrow> loans = new ArrayList<>();

    // declare lists for all types of Books (at first I have declared all in one list)
    private ArrayList<Book> books = new ArrayList<>();
    /* it can be declared like below:
        ArrayList<Book> historicalBooks = new ArrayList<>();
        ArrayList<Book> scientificBooks = new ArrayList<>();
        ArrayList<Book> religiousBooks = new ArrayList<>();
    */

    // lists of loan requests
    ArrayList<Request> loanRequests = new ArrayList<>();
    ArrayList<Request> returnRequests = new ArrayList<>();

    // data getter methods
    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<LibraryManager> getLibraryManager() {
        return libraryManager;
    }

    public ArrayList<Student> getLibraryStudents() {
        return libraryStudents;
    }

    public ArrayList<Librarian> getLibrarians() {
        return librarians;
    }

    public ArrayList<Borrow> getLoans() {
        return loans;
    }

    public ArrayList<Request> getLoanRequests() {
        return loanRequests;
    }

    public ArrayList<Request> getReturnRequests() {
        return returnRequests;
    }

    // data setter methods
    public void setLibrarians(ArrayList<Librarian> librarians) {
        this.librarians = librarians;
    }

    public void setLibraryStudents(ArrayList<Student> libraryStudents) {
        this.libraryStudents = libraryStudents;
    }

    public void setLoans(ArrayList<Borrow> loans) {
        this.loans = loans;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void setLoanRequests(ArrayList<Request> loanRequests) {
        this.loanRequests = loanRequests;
    }

    public void setReturnRequests(ArrayList<Request> returnRequests) {
        this.returnRequests = returnRequests;
    }

}
