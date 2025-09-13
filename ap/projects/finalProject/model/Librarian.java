package ap.projects.finalProject.model;

public class Librarian {

    // for librarian, I have used both username and employee ID in same meaning
    private String employeeID, password;

    private String booksRegisteredHistory = "-";
    private long booksRegisteredCount = 0;
    private long lentBooksCount = 0;
    private long reclaimedBooksCont = 0;

    public Librarian(String employeeID, String password) {

        this.employeeID = employeeID;
        this.password = password;

    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * saves the books that added by this librarian split by -
     * It also records the total number of books that registered by the librarian
     *
     * @param newAction the new book info
     */
    public void setBooksRegisteredHistory(String newAction) {

        this.booksRegisteredHistory = this.booksRegisteredHistory.concat(newAction + "-");
        this.booksRegisteredCount += 1;

    }

    /**
     * records the number of loans that lent by this librarian
     */
    public void setLentBooksCount() {

        this.lentBooksCount += 1;

    }

    /**
     * records the number of books that reclaimed by this librarian
     */
    public void setReclaimedBooksCount() {

        this.reclaimedBooksCont += 1;

    }

}
