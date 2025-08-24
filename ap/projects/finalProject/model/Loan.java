package ap.projects.finalProject.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Loan {

    // parameters to save lending info
    private LocalDate
            loanStartDate,
            loanFinishDate,
            actualReturnDate;
    private String borrowerStudentUsername;
    private String borrowedBookISBN;
    private String lenderLibrarianID, reclaimerLibrarianID;

    public Loan(String borrowerStudentUsername,
                String borrowedBookISBN,
                String lenderLibrarianID,
                LocalDate loanStartDate,
                LocalDate loanFinishDate
    ) {

        this.borrowerStudentUsername = borrowerStudentUsername;
        this.borrowedBookISBN = borrowedBookISBN;
        this.lenderLibrarianID = lenderLibrarianID;
        this.loanStartDate = loanStartDate;
        this.loanFinishDate = loanFinishDate;

    }

    public void returnBook(String reclaimerLibrarianID, LocalDate actualReturnDate) {

        this.reclaimerLibrarianID = reclaimerLibrarianID;
        this.actualReturnDate = actualReturnDate;

    }

    public int getDelay() {

        if (ChronoUnit.DAYS.between(loanFinishDate, actualReturnDate) > 0) {
            return (int) ChronoUnit.DAYS.between(loanFinishDate, actualReturnDate);
        } else {
            return 0;
        }

    }

    public boolean isLate(LocalDate now) {
        return now.isAfter(loanFinishDate);
    }

}
