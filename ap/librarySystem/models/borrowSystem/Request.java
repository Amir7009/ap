package ap.librarySystem.models.borrowSystem;

import ap.librarySystem.constants.RequestType;
import ap.librarySystem.models.Student;

import java.util.LinkedHashMap;

public class Request {

    private String borrowerStudentID;
    private String borrowedBookISBN;
    private String librarianID; // lender or reclaimer librarian
    private RequestType requestType;

    public Request(String borrowerStudentID,
                   String borrowedBookISBN,
                   RequestType requestType,
                   String librarianID
    ){

        this.borrowerStudentID = borrowerStudentID;
        this.borrowedBookISBN = borrowedBookISBN;
        this.requestType = requestType;
        this.librarianID = librarianID;

    }

    public String getBorrowerStudentID() {
        return borrowerStudentID;
    }

    public String getBorrowedBookISBN() {
        return borrowedBookISBN;
    }

    public String getLibrarianID() {
        return librarianID;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public String printRequestDetails(LinkedHashMap<String, Student> students){

        return "Request{" +
                "borrowerStudent=" + students.get(borrowerStudentID).getUsername() +
                ", borrowedBook=" + borrowedBookISBN +
                '}';

    }

    // toString method to save Request object as a string
    @Override
    public String toString() {
        return "Request{" +
                "borrowerStudent=" + borrowerStudentID +
                ", borrowedBook=" + borrowedBookISBN +
                ", librarian=" + librarianID +
                ", requestType=" + requestType +
                '}';
    }

    // fromString method to parse the input string and return a Request object

}
