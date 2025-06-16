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

    public String getLenderLibrarianID() {
        return lenderLibrarianID;
    }

    public String getReclaimerLibrarianID() {
        return reclaimerLibrarianID;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public LocalDate getLoanFinishDate() {
        return loanFinishDate;
    }

    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public void setReclaimerLibrarianID(String reclaimerLibrarianID) {
        this.reclaimerLibrarianID = reclaimerLibrarianID;
    }

//    public void setLoanStartDate(LocalDate loanStartDate) {
//        this.loanStartDate = loanStartDate;
//    }
//
//    public void setLoanFinishDate(LocalDate loanFinishDate) {
//        this.loanFinishDate = loanFinishDate;
//    }
//
//    public void setBorrowerStudentID(String borrowerStudentID) {
//        this.borrowerStudentID = borrowerStudentID;
//    }
//
//    public void setBorrowedBookISBN(String borrowedBookISBN) {
//        this.borrowedBookISBN = borrowedBookISBN;
//    }
//
//    public void setLenderLibrarianID(String lenderLibrarianID) {
//        this.lenderLibrarianID = lenderLibrarianID;
//    }

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

    public String tabSplit(){
        return this.borrowerStudentID + "\t" +
                this.borrowedBookISBN + "\t" +
                this.lenderLibrarianID + "\t" +
                this.loanStartDate + "\t" +
                this.loanFinishDate + "\t" +
                this.actualReturnDate + "\t" +
                this.reclaimerLibrarianID + "\t";
    }

}
