package ap.projects.finalProject.model;

import java.time.LocalDate;

public class Request {

    private String borrowerStudentUsername;
    private String borrowedBookISBN;
    private LocalDate createRequestDate;

    /**
     * When registering a loan request,
     * the student specifies which book is requested to be borrowed at what time.
     */
    public Request(String borrowerStudentUsername,
                   String borrowedBookISBN,
                   LocalDate createRequestDate
    ) {

        this.borrowerStudentUsername = borrowerStudentUsername;
        this.borrowedBookISBN = borrowedBookISBN;
        this.createRequestDate = createRequestDate;

    }

    /**
     * Print details of a request including the requesting student,
     * ISBN of the requested book, and the date the request was submitted.
     *
     * @return the request details in json form
     */
    public String requestDetails() {

        return "Request{" +
                "borrowerStudent=" + borrowerStudentUsername +
                ", borrowedBook=" + borrowedBookISBN +
                ", createRequestDate=" + createRequestDate +
                '}';

    }

    public String getBorrowerStudentUsername() {
        return borrowerStudentUsername;
    }

    public String getBorrowedBookISBN() {
        return borrowedBookISBN;
    }

    public LocalDate getCreateRequestDate() {
        return createRequestDate;
    }

    public String tabSplit(){
        return this.borrowerStudentUsername + "\t" +
                this.borrowedBookISBN + "\t" +
                this.createRequestDate + "\t";
    }

}
