package ap.midterm_project.models;

import ap.midterm_project.constants.RequestType;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private Student borrowerStudent;
    private Book borrowedBook;
    private Librarian librarian; // lender or reclaimer librarian
    private RequestType requestType;

    public Request(Student borrowerStudent,
                   Book borrowedBook,
                   RequestType requestType,
                   Librarian librarian
    ){

        this.borrowerStudent = borrowerStudent;
        this.borrowedBook = borrowedBook;
        this.requestType = requestType;
        this.librarian = librarian;

    }

    public Student getBorrowerStudent() {
        return borrowerStudent;
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public String printRequestDetails(){

        return "Request{" +
                "borrowerStudent=" + borrowerStudent.getUsername() +
                ", borrowedBook=" + borrowedBook.getISBN() +
                '}';

    }

    // toString method to save Request object as a string
    @Override
    public String toString() {
        return "Request{" +
                "borrowerStudent=" + borrowerStudent +
                ", borrowedBook=" + borrowedBook +
                ", librarian=" + librarian +
                ", requestType=" + requestType +
                '}';
    }

    // fromString method to parse the input string and return a Request object
    public static Request fromString(String str) {
        str = str.replace("Request{", "")
                .replace("}", "");

        String[] parts = str.split(", (?=\\w+=)");
        Map<String, String> values = new HashMap<>();
        for (String part : parts) {
            String[] keyValue = part.split("=", 2);
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            values.put(key, value);
        }

        Student student = Student.fromString(values.get("borrowerStudent"));
        Book book = Book.fromString(values.get("borrowedBook"));
        Librarian librarian = Librarian.fromString(values.get("librarian"));
        RequestType type = RequestType.valueOf(values.get("requestType"));

        return new Request(student, book, type, librarian);
    }

}
