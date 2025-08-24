package ap.projects.finalProject.model;

public class Student {

    private String name;
    private String studentId;
    private String username;
    private String password;
    private boolean active = true;

    private String notifications = "-";
    private String LoanHistory = "-";

    public Student(String name, String studentId, String username, String password) {
        this.name = name;
        this.studentId = studentId;
        this.username = username;
        this.password = password;
    }

    /**
     * getter methods for student attributes
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
        return username;
    }

    public String getPassword() {
        return password;
    }

    /**
     * for check activity of a student
     *
     * @return the activity status of student
     */
    public boolean isActive() {
        return active;
    }

    /**
     * to set activity status of a student
     *
     * @param active new activity status of the student
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * saves the student notifications split by -
     *
     * @param notifications the new notification for student
     */
    public void setNotifications(String notifications) {

        this.notifications = this.notifications.concat(notifications + "-");

    }

    public String getNotifications() {

        return notifications;

    }

    /**
     * for print the student info
     *
     * @return the student info as a string in form of
     * Name:  ... | Student ID:  ... | Username: ... | Status: ...
     */
    @Override
    public String toString() {
        return "Name: " + name +
                " | Student ID: " + studentId +
                " | Username: " + username +
                " | Status: " + (active ? "Active" : "Inactive");
    }

}
