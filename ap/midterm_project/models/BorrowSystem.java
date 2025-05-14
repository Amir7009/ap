package ap.midterm_project.models;

public class BorrowSystem {

    // parameters to save lending info
    private String
            loanStartDate,
            loanFinishDate,
            actualReturnDate;
    private Student borrowerStudent;
    private Book borrowedBook;
    private Librarian lenderLibrarian, reclaimerLibrarian;

    public BorrowSystem(String loanStartDate,
                        String loanFinishDate,
                        Student borrowerStudent,
                        Book borrowedBook,
                        Librarian lenderLibrarian
    ){

        this.borrowerStudent = borrowerStudent;
        this.borrowedBook = borrowedBook;
        this.lenderLibrarian = lenderLibrarian;
        this.loanStartDate = loanStartDate;
        this.loanFinishDate = loanFinishDate;

    }

    public void returnBook(Librarian reclaimerLibrarian, String actualReturnDate){

        this.reclaimerLibrarian = reclaimerLibrarian;
        this.actualReturnDate = actualReturnDate;

    }

}
