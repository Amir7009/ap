package ap.midterm_project.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

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
        this.loanStartDate = loanStartDate;
        this.loanFinishDate = loanFinishDate;

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

    public boolean isLate(LocalDate now){
        return now.isAfter(loanFinishDate);
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public Student getBorrowerStudent() {
        return borrowerStudent;
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
                ", borrowerStudent=" + borrowerStudent +
                ", borrowedBook=" + borrowedBook +
                ", lenderLibrarian=" + lenderLibrarian +
                ", reclaimerLibrarian=" + reclaimerLibrarian +
                '}';
    }

    public static Borrow fromString(String str) {
        str = str.replace("Borrow{", "")
                .replace("}", "");

        String[] parts = str.split(", (?=\\w+=)");
        Map<String, String> values = new HashMap<>();

        for (String part : parts) {
            String[] keyValue = part.split("=", 2);
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            values.put(key, value);
        }

        // Parsing objects using their fromString methods
        Student borrower = Student.fromString(values.get("borrowerStudent"));
        Book book = Book.fromString(values.get("borrowedBook"));
        Librarian lender = Librarian.fromString(values.get("lenderLibrarian"));
        Librarian reclaimer = values.get(
                "reclaimerLibrarian").equals("null") ? null : Librarian.fromString(values.get("reclaimerLibrarian")
        );

        // Parsing LocalDate fields
        LocalDate loanStart = values.get(
                "loanStartDate").equals("null") ? null : LocalDate.parse(values.get("loanStartDate")
        );
        LocalDate loanFinish = values.get(
                "loanFinishDate").equals("null") ? null : LocalDate.parse(values.get("loanFinishDate")
        );
        LocalDate actualReturn = values.get(
                "actualReturnDate").equals("null") ? null : LocalDate.parse(values.get("actualReturnDate")
        );

        // Creating Borrow object
        Borrow borrow = new Borrow(borrower, book, lender, loanStart, loanFinish);
        if (actualReturn != null && reclaimer != null) {
            borrow.returnBook(reclaimer, actualReturn);
        }

        return borrow;
    }

}
