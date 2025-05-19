package ap.midterm_project.models;

public class Request {

    private Student borrowerStudent;
    private Book borrowedBook;
    private Librarian librarian; // lender or reclaimer librarian
    private String requestType;

    public Request(Student borrowerStudent,
                   Book borrowedBook,
                   String requestType,
                   Librarian librarian
    ){

        this.borrowerStudent = borrowerStudent;
        this.borrowedBook = borrowedBook;
        this.requestType = requestType;
        this.librarian = librarian;

    }

    @Override
    public String toString() {
        return "Request{" +
                "borrowerStudent=" + borrowerStudent.getUsername() +
                ", borrowedBook=" + borrowedBook.getISBN() +
                '}';
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

    public String getRequestType() {
        return requestType;
    }
}
