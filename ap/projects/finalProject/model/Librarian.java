package ap.projects.finalProject.model;

public class Librarian {

    // for librarian, I have used both username and employee ID
    private String employeeID, password;

    private String booksRegisteredHistory = "-";
    private String lentBooksHistory = "-";
    private String reclaimedBooksHistory = "-";

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
     *
     * @param newAction the new book info
     */
    public void setBooksRegisteredHistory(String newAction) {

        this.booksRegisteredHistory = this.booksRegisteredHistory.concat(newAction + "-");

    }

    /**
     * saves the loans that lent by this librarian split by -
     *
     * @param newAction the new loan info
     */
    public void setLentBooksHistory(String newAction) {

        this.lentBooksHistory = this.lentBooksHistory.concat(newAction + "-");

    }

    /**
     * saves the books that reclaimed by this librarian split by -
     *
     * @param newAction the returned loan info
     */
    public void setReclaimedBooksHistory(String newAction) {

        this.reclaimedBooksHistory = this.reclaimedBooksHistory.concat(newAction + "-");

    }

}
