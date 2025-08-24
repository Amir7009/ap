package ap.projects.finalProject.model;

import java.time.LocalDate;
import java.util.LinkedHashMap;

public class Request {

    private String borrowerStudentUsername;
    private String borrowedBookISBN;
    private LocalDate createRequestDate;

    public Request(String borrowerStudentUsername,
                   String borrowedBookISBN,
                   LocalDate createRequestDate
    ) {

        this.borrowerStudentUsername = borrowerStudentUsername;
        this.borrowedBookISBN = borrowedBookISBN;
        this.createRequestDate = createRequestDate;

    }

    public String printRequestDetails(LinkedHashMap<String, Student> students) {

        return "Request{" +
                "borrowerStudent=" + students.get(borrowerStudentUsername).getUsername() +
                ", borrowedBook=" + borrowedBookISBN +
                ", createRequestDate=" + createRequestDate +
                '}';

    }

}
