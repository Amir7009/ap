package ap.projects.midtermProject.database;

import ap.projects.midtermProject.models.borrowSystem.Borrow;
import ap.projects.midtermProject.models.borrowSystem.Request;
import ap.projects.midtermProject.models.Book;
import ap.projects.midtermProject.models.Librarian;
import ap.projects.midtermProject.models.LibraryManager;
import ap.projects.midtermProject.models.Student;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Library {

    private String libraryName;

    public Library(String name) {

        this.libraryName = name;

    }

    /**
     * Definition of all fields related to the library.
     */
    private LinkedHashMap<String, LibraryManager> libraryManager = new LinkedHashMap<>();
    private LinkedHashMap<String, Book> books = new LinkedHashMap<>();
    private LinkedHashMap<String, Student> students = new LinkedHashMap<>();
    private LinkedHashMap<String, Librarian> librarians = new LinkedHashMap<>();
    private ArrayList<Borrow> borrows = new ArrayList<>();
    private ArrayList<Request> loanRequests = new ArrayList<>();
    private ArrayList<Request> returnRequests = new ArrayList<>();

    public LinkedHashMap<String, LibraryManager> getLibraryManager() {
        return libraryManager;
    }

    public void setLibraryManager(String ID, LibraryManager libraryManager) {
        this.libraryManager.put(ID, libraryManager);
    }

    public LinkedHashMap<String, Book> getBooks() {
        return books;
    }

    public void setBooks(LinkedHashMap<String, Book> books) {
        this.books = books;
    }

    public LinkedHashMap<String, Student> getStudents() {
        return students;
    }

    public void setStudents(LinkedHashMap<String, Student> students) {
        this.students = students;
    }

    public LinkedHashMap<String, Librarian> getLibrarians() {
        return librarians;
    }

    public void setLibrarians(LinkedHashMap<String, Librarian> librarians) {
        this.librarians = librarians;
    }

    public ArrayList<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(ArrayList<Borrow> borrows) {
        this.borrows = borrows;
    }

    public ArrayList<Request> getLoanRequests() {
        return loanRequests;
    }

    public void setLoanRequests(ArrayList<Request> loanRequests) {
        this.loanRequests = loanRequests;
    }

    public ArrayList<Request> getReturnRequests() {
        return returnRequests;
    }

    public void setReturnRequests(ArrayList<Request> returnRequests) {
        this.returnRequests = returnRequests;
    }

}
