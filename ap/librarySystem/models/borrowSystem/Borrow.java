package ap.librarySystem.models.borrowSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Borrow {

    // parameters to save lending info
    private LocalDate
            loanStartDate,
            loanFinishDate,
            actualReturnDate;
    private String borrowerStudentID;
    private String borrowedBookISBN;
    private String lenderLibrarianID, reclaimerLibrarianID;

    public Borrow(String borrowerStudentID,
                  String borrowedBookISBN,
                  String lenderLibrarianID,
                  LocalDate loanStartDate,
                  LocalDate loanFinishDate
    ){

        this.borrowerStudentID = borrowerStudentID;
        this.borrowedBookISBN = borrowedBookISBN;
        this.lenderLibrarianID = lenderLibrarianID;
        this.loanStartDate = loanStartDate;
        this.loanFinishDate = loanFinishDate;

    }

    public void returnBook(String reclaimerLibrarianID, LocalDate actualReturnDate){

        this.reclaimerLibrarianID = reclaimerLibrarianID;
        this.actualReturnDate = actualReturnDate;

    }

    public int getDelay(){

        if (ChronoUnit.DAYS.between(loanFinishDate, actualReturnDate) > 0){
            return (int)ChronoUnit.DAYS.between(loanFinishDate, actualReturnDate);
        }else {
            return 0;
        }

    }

    public boolean isLate(LocalDate now){
        return now.isAfter(loanFinishDate);
    }

    public String getBorrowedBookISBN() {
        return borrowedBookISBN;
    }

    public String getBorrowerStudentID() {
        return borrowerStudentID;
    }

    public LocalDate getLoanStartDate() {
        return loanStartDate;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "loanStartDate=" + loanStartDate +
                ", loanFinishDate=" + loanFinishDate +
                ", actualReturnDate=" + actualReturnDate +
                ", borrowerStudent=" + borrowerStudentID +
                ", borrowedBook=" + borrowedBookISBN +
                ", lenderLibrarian=" + lenderLibrarianID +
                ", reclaimerLibrarian=" + reclaimerLibrarianID +
                '}';
    }

}
