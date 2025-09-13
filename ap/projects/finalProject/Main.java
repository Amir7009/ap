package ap.projects.finalProject;

import ap.projects.finalProject.model.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Manager libraryManager = new Manager(
                "znu",
                "1234",
                "AmirHossein",
                "Mohebbi",
                "Diploma"
        );

        new LibrarySystem(libraryManager).start();

    }

    // for backup
    private LinkedHashMap<String, Book> books = new LinkedHashMap<>();
    private LinkedHashMap<String, Librarian> librarians = new LinkedHashMap<>();
    private ArrayList<Request> loanRequests = new ArrayList<>();
    private ArrayList<Request> returnRequests = new ArrayList<>();
    private ArrayList<String> pastLoansHistory = new ArrayList<>();
    private ArrayList<Loan> currentLoans = new ArrayList<>();
    private LinkedHashMap<String, Student> students = new LinkedHashMap<>();
    private TreeMap<Integer, String> mostLateStudents = new TreeMap<>();

}
