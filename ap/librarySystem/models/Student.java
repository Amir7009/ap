package ap.librarySystem.models;

import java.util.HashMap;
import java.util.Map;

public class Student extends User {

    private String
            firstName,
            lastName,
            studyingField,
            studentID,
            membershipDate,
            notifications,
            loanHistory;

    public Student(
            String firstName,
            String lastName,
            String studyingField,
            String studentId,
            String membershipDate,
            String notifications,
            String loanHistory
    ){

        super (studentId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.studyingField = studyingField;
        this.studentID = studentId;
        this.membershipDate = membershipDate;
        this.notifications = notifications;
        this.loanHistory = loanHistory;

    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studyingField='" + studyingField + '\'' +
                ", studentID='" + studentID + '\'' +
                ", membershipDate='" + membershipDate + '\'' +
                ", notifications='" + notifications + '\'' +
                ", loanHistory='" + loanHistory + '\'' +
                '}';
    }

    // fromString method to parse the input string and return a Student object


    public void setNotifications(String newNotification) {
        this.notifications = this.notifications.concat("-" + newNotification);
    }

    public void setHistory(String newAction) {
        this.loanHistory = this.loanHistory.concat("-" + newAction);
    }

    public String getNotifications() {
        return notifications;
    }

    public String getLoanHistory() {
        return loanHistory;
    }
}
