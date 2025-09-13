package ap.projects.midtermProject.models.borrowSystem;

import ap.projects.midtermProject.constants.RequestType;
import ap.projects.midtermProject.models.Student;

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

//    public void setBorrowedBookISBN(String borrowedBookISBN) {
//        this.borrowedBookISBN = borrowedBookISBN;
//    }
//
//    public void setBorrowerStudentID(String borrowerStudentID) {
//        this.borrowerStudentID = borrowerStudentID;
//    }
//
//    public void setLibrarianID(String librarianID) {
//        this.librarianID = librarianID;
//    }
//
//    public void setRequestType(RequestType requestType) {
//        this.requestType = requestType;
//    }

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

    public String tabSplit(){
        return this.borrowerStudentID + "\t" +
                this.borrowedBookISBN + "\t" +
                this.requestType + "\t" +
                this.librarianID + "\t";
    }

}
