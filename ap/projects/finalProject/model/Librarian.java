package ap.projects.finalProject.model;

public class Librarian extends AppUser {

    // For librarian, I have used both username and employee ID in same meaning.

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

    /**
     * For edit password after registration.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        super.setPassword(password);
    }


    /**
     * Saves the books that added by this librarian split by -.
     * It also records the total number of books that registered by the librarian.
     *
     * @param newAction the new book info
     */
    public void addBooksRegisteredHistory(String newAction) {

        this.booksRegisteredHistory = this.booksRegisteredHistory.concat(newAction + "-");
        this.booksRegisteredCount += 1;

    }

    public void setBooksRegisteredHistory(String booksRegisteredHistory) {
        this.booksRegisteredHistory = booksRegisteredHistory;
    }

    public void setBooksRegisteredCount(long booksRegisteredCount) {
        this.booksRegisteredCount = booksRegisteredCount;
    }

    public String getBooksRegisteredHistory() {
        return booksRegisteredHistory;
    }

    public long getBooksRegisteredCount() {
        return booksRegisteredCount;
    }


    /**
     * Records the number of loans that lent by this librarian.
     */
    public void addLentBooksCount() {

        this.lentBooksCount += 1;

    }

    public void setLentBooksCount(long lentBooksCount) {
        this.lentBooksCount = lentBooksCount;
    }

    public long getLentBooksCount() {
        return lentBooksCount;
    }


    /**
     * Records the number of books that reclaimed by this librarian.
     */
    public void addReclaimedBooksCount() {

        this.reclaimedBooksCont += 1;

    }

    public void setReclaimedBooksCont(long reclaimedBooksCont) {
        this.reclaimedBooksCont = reclaimedBooksCont;
    }

    public long getReclaimedBooksCont() {
        return reclaimedBooksCont;
    }

    public String tabSplit() {
        return super.getUsername() + "\t" +
                super.getPassword() + "\t" +
                this.booksRegisteredHistory + "\t" +
                this.booksRegisteredCount + "\t" +
                this.lentBooksCount + "\t" +
                this.reclaimedBooksCont + "\t";
    }

}
