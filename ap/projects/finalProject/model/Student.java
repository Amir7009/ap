package ap.projects.finalProject.model;

public class Student extends AppUser {

    private String name;
    private String studentId;
    private boolean active = true;

    private String notifications = "-";
    private String loanHistory = "-";
    private long loansCount = 0;
    private long currentLoansCount = 0;
    private long lateLoansCount = 0;

    public Student(String name, String studentId, String username, String password) {
        super(username, password);
        this.name = name;
        this.studentId = studentId;
    }

    /**
     * Getter methods for student attributes
     *
     * @return student info (String)
     */
    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getUsername() {
        return super.getUsername();
    }

    public String getPassword() {
        return super.getPassword();
    }

    /**
     * For check activity of a student
     *
     * @return the activity status of student
     */
    public boolean isActive() {
        return active;
    }

    /**
     * To set activity status of a student
     *
     * @param active new activity status of the student
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Saves the student notifications split by -
     *
     * @param notifications the new notification for student
     */
    public void setNotifications(String notifications) {

        this.notifications = this.notifications.concat(notifications + "-");

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
    public void setCurrentLoansCount(int newAction) {
        this.currentLoansCount += newAction;
    }

    /**
     * Saves the student loan history split by -
     * It also records the total number of loans taken by this student.
     *
     * @param newAction the new borrow report for student
     */
    public void setLoanHistory(String newAction) {

        this.loanHistory = this.loanHistory.concat(newAction + "-");
        this.loansCount += 1;

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

    public long getCurrentLoansCount() {
        return currentLoansCount;
    }

    public long getLateLoansCount() {
        return lateLoansCount;
    }

    /**
     * Records the number of books that late by this student
     */
    public void setLateLoansCount() {

        this.lateLoansCount += 1;

    }

    /**
     * For print the student info
     *
     * @return the student info as a string in form of
     * Name:  ... | Student ID:  ... | Username: ... | Status: ...
     */
    @Override
    public String toString() {
        return "Name: " + name +
                " | Student ID: " + studentId +
                " | Username: " + super.getUsername() +
                " | Status: " + (active ? "Active" : "Inactive");
    }

}
