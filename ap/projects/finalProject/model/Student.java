package ap.projects.finalProject.model;

public class Student extends AppUser {

    private String name;
    private String studentID;
    private boolean active = true;

    private String notifications = "-";
    private String loanHistory = "-";
    private long loansCount = 0;
    private long currentLoansCount = 0;
    private long lateLoansCount = 0;

    public Student(String name, String studentId, String username, String password) {
        super(username, password);
        this.name = name;
        this.studentID = studentId;
    }

    /**
     * Getter methods for student attributes.
     *
     * @return student info (String)
     */
    public String getName() {
        return name;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getUsername() {
        return super.getUsername();
    }

    public String getPassword() {
        return super.getPassword();
    }


    /**
     * To set activity status of a student.
     *
     * @param active new activity status of the student
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * For check activity of a student.
     *
     * @return the activity status of student
     */
    public boolean isActive() {
        return active;
    }


    /**
     * Saves the student notifications split by -.
     *
     * @param notifications the new notification for student
     */
    public void addNotifications(String notifications) {

        this.notifications = this.notifications.concat(notifications + "-");

    }

    public void setNotifications(String notifications) {
        this.notifications = notifications;
    }

    /**
     * Returns all announcements for printing.
     */
    public String getNotifications() {
        return notifications;
    }


    /**
     * If the user borrows, the number increases and if they return it, the number decreases.
     */
    public void addCurrentLoansCount(int newAction) {
        this.currentLoansCount += newAction;
    }

    public void setCurrentLoansCount(long currentLoansCount) {
        this.currentLoansCount = currentLoansCount;
    }

    public long getCurrentLoansCount() {
        return currentLoansCount;
    }


    /**
     * Saves the student loan history split by -
     * It also records the total number of loans taken by this student.
     *
     * @param newAction the new borrow report for student
     */
    public void addLoanHistory(String newAction) {

        this.loanHistory = this.loanHistory.concat(newAction + "-");
        this.loansCount += 1;

    }

    public void setLoanHistory(String loanHistory) {
        this.loanHistory = loanHistory;
    }

    public void setLoansCount(long loansCount) {
        this.loansCount = loansCount;
    }

    /**
     * Returns the history of all completed parcels.
     */
    public String getLoanHistory() {
        return loanHistory;
    }

    public long getLoansCount() {
        return loansCount;
    }


    /**
     * Records the number of books that late by this student.
     */
    public void addLateLoansCount() {

        this.lateLoansCount += 1;

    }

    public void setLateLoansCount(long lateLoansCount) {
        this.lateLoansCount = lateLoansCount;
    }

    public long getLateLoansCount() {
        return lateLoansCount;
    }


    /**
     * For print the student info.
     *
     * @return the student info as a string in form of
     * Name:  ... | Student ID:  ... | Username: ... | Status: ...
     */
    @Override
    public String toString() {
        return "Name: " + name +
                " | Student ID: " + studentID +
                " | Username: " + super.getUsername() +
                " | Status: " + (active ? "Active" : "Inactive");
    }

    public String tabSplit(){
        return this.name + "\t" +
                this.studentID + "\t" +
                this.getUsername() + "\t" +
                this.getPassword() + "\t" +
                this.isActive() + "\t" +
                this.notifications + "\t" +
                this.loanHistory + "\t" +
                this.loansCount + "\t" +
                this.currentLoansCount + "\t" +
                this.lateLoansCount + "\t";
    }

}
