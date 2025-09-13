package ap.projects.finalProject.model;

public class Librarian extends AppUser {

    // For librarian, I have used both username and employee ID in same meaning

    private String booksRegisteredHistory = "-";
    private long booksRegisteredCount = 0;
    private long lentBooksCount = 0;
    private long reclaimedBooksCont = 0;

    public Librarian(String employeeID, String password) {

        super(employeeID, password);

    }

    public String getEmployeeID() {
        return super.getUsername();
    }

    public String getPassword() {
        return super.getPassword();
    }

    public void setPassword(String password) {
        super.setPassword(password);
    }

    /**
     * Saves the books that added by this librarian split by -
     * It also records the total number of books that registered by the librarian
     *
     * @param newAction the new book info
     */
    public void setBooksRegisteredHistory(String newAction) {

        this.booksRegisteredHistory = this.booksRegisteredHistory.concat(newAction + "-");
        this.booksRegisteredCount += 1;

    }

    /**
     * Records the number of loans that lent by this librarian
     */
    public void setLentBooksCount() {

        this.lentBooksCount += 1;

    }

    /**
     * Records the number of books that reclaimed by this librarian
     */
    public void setReclaimedBooksCount() {

        this.reclaimedBooksCont += 1;

    }

}
