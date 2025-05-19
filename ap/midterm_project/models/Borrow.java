package ap.midterm_project.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Borrow {

    // parameters to save lending info
    private LocalDate
            loanStartDate,
            loanFinishDate,
            actualReturnDate;
    private Student borrowerStudent;
    private Book borrowedBook;
    private Librarian lenderLibrarian, reclaimerLibrarian;

    public Borrow(Student borrowerStudent,
                  Book borrowedBook,
                  Librarian lenderLibrarian,
                  LocalDate loanStartDate,
                  LocalDate loanFinishDate
    ){

        this.borrowerStudent = borrowerStudent;
        this.borrowedBook = borrowedBook;
        this.lenderLibrarian = lenderLibrarian;

    }

    public void returnBook(Librarian reclaimerLibrarian, LocalDate actualReturnDate){

        this.reclaimerLibrarian = reclaimerLibrarian;
        this.actualReturnDate = actualReturnDate;

    }

    public int getDelay(){

        if (ChronoUnit.DAYS.between(loanFinishDate, actualReturnDate) > 0){
            return (int)ChronoUnit.DAYS.between(loanFinishDate, actualReturnDate);
        }else {
            return 0;
        }

    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public Student getBorrowerStudent() {
        return borrowerStudent;
    }
}
