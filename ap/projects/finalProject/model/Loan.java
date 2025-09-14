package ap.projects.finalProject.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Loan {

    // Parameters to save lending info
    private LocalDate
            loanStartDate,
            loanFinishDate,
            actualReturnDate;
    private String borrowerStudentUsername;
    private String borrowedBookISBN;
    private String lenderLibrarianID, reclaimerLibrarianID;

    /**
     * When a book is loaned, a loan class is created in which information
     * such as the username of the borrowing student,
     * the personal number of the lending librarian,
     * and the number of the book borrowed are stored,
     * and the loan start and end dates are stored.
     */
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

    /**
     * When returning a book,
     * the return date and the returning librarian are recorded in the loan information.
     */
    public void returnBook(String reclaimerLibrarianID, LocalDate actualReturnDate) {

        this.reclaimerLibrarianID = reclaimerLibrarianID;
        this.actualReturnDate = actualReturnDate;

    }

    /**
     * Calculates the amount of late return of the book from the date set for the end of the loan period.
     *
     * @return the count of delayed days
     */
    public int getDelay() {

        if (ChronoUnit.DAYS.between(loanFinishDate, actualReturnDate) > 0) {
            return (int) ChronoUnit.DAYS.between(loanFinishDate, actualReturnDate);
        } else {
            return 0;
        }

    }

    /**
     * It only checks whether the book has passed the due date for the end of the loan.
     *
     * @param now date of the checking moment
     * @return is late? (y or n)
     */
    public boolean isLate(LocalDate now) {
        return now.isAfter(loanFinishDate);
    }

    /**
     * Function to calculate how long a book has been on loan.
     *
     * @return number of days the book has been on loan
     */
    public int loanDuration() {
        return (int) ChronoUnit.DAYS.between(loanStartDate, actualReturnDate);
    }

    /**
     * Returns the ISBN of the book on loan.
     */
    public String getBorrowedBookISBN() {
        return borrowedBookISBN;
    }

    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public void setReclaimerLibrarianID(String reclaimerLibrarianID) {
        this.reclaimerLibrarianID = reclaimerLibrarianID;
    }

    /**
     * For log the loan info.
     */
    @Override
    public String toString() {
        return "Loan{" +
                "loanStartDate=" + loanStartDate +
                ", loanFinishDate=" + loanFinishDate +
                ", actualReturnDate=" + actualReturnDate +
                ", borrowerStudentUsername='" + borrowerStudentUsername + '\'' +
                ", borrowedBookISBN='" + borrowedBookISBN + '\'' +
                ", lenderLibrarianID='" + lenderLibrarianID + '\'' +
                ", reclaimerLibrarianID='" + reclaimerLibrarianID + '\'' +
                '}';
    }

    public String tabSplit(){
        return this.borrowerStudentUsername + "\t" +
                this.borrowedBookISBN + "\t" +
                this.lenderLibrarianID + "\t" +
                this.loanStartDate + "\t" +
                this.loanFinishDate + "\t" +
                this.actualReturnDate + "\t" +
                this.reclaimerLibrarianID + "\t";
    }

}
