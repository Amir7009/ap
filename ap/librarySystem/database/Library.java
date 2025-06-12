package ap.librarySystem.database;

import ap.librarySystem.models.borrowSystem.Borrow;
import ap.librarySystem.models.borrowSystem.Request;
import ap.librarySystem.models.Book;
import ap.librarySystem.models.Librarian;
import ap.librarySystem.models.LibraryManager;
import ap.librarySystem.models.Student;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Library {

    private String libraryName;

    public Library(String name) {

        this.libraryName = name;

    }

    // instantiate one manager and two librarians at first
    private LinkedHashMap<String, LibraryManager> libraryManager = new LinkedHashMap<>();

    //    private ArrayList<Librarian> librarians = new ArrayList<>();
    private LinkedHashMap<String, Librarian> librarians = new LinkedHashMap<>();

    // declare lists of library data
    private LinkedHashMap<String, Student> libraryStudents = new LinkedHashMap<>();

    private ArrayList<Borrow> loans = new ArrayList<>();

    // declare lists for all types of Books (at first I have declared all in one list)
    private LinkedHashMap<String, Book> books = new LinkedHashMap<>();
    /* it can be declared like below:
        ArrayList<Book> historicalBooks = new ArrayList<>();
        ArrayList<Book> scientificBooks = new ArrayList<>();
        ArrayList<Book> religiousBooks = new ArrayList<>();
    */

    // lists of loan requests
    ArrayList<Request> loanRequests = new ArrayList<>();
    ArrayList<Request> returnRequests = new ArrayList<>();

    // data getter methods
    public LinkedHashMap<String, Book> getBooks() {
        return books;
    }

    public LinkedHashMap<String, LibraryManager> getLibraryManager() {
        return libraryManager;
    }

    public LinkedHashMap<String, Librarian> getLibrarians() {
        return librarians;
    }

    public LinkedHashMap<String, Student> getLibraryStudents() {
        return libraryStudents;
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
    public void setBooks(LinkedHashMap<String, Book> books) {
        this.books = books;
    }

    public void setLibraryManager(String ID, LibraryManager libraryManager) {
        this.libraryManager.put(ID, libraryManager);
    }

    public void setLibrarians(LinkedHashMap<String, Librarian> librarians) {
        this.librarians = librarians;
    }

    public void setLibraryStudents(LinkedHashMap<String, Student> libraryStudents) {
        this.libraryStudents = libraryStudents;
    }

    public void setLoans(ArrayList<Borrow> loans) {
        this.loans = loans;
    }

    public void setLoanRequests(ArrayList<Request> loanRequests) {
        this.loanRequests = loanRequests;
    }

    public void setReturnRequests(ArrayList<Request> returnRequests) {
        this.returnRequests = returnRequests;
    }

}
