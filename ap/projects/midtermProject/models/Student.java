package ap.projects.midtermProject.models;

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

    public void setNotifications(String newNotification) {
        this.notifications = this.notifications.concat("-" + newNotification);
    }

    public void setHistory(String newAction) {
        this.loanHistory = this.loanHistory.concat("-" + newAction);
    }

//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public void setStudyingField(String studyingField) {
//        this.studyingField = studyingField;
//    }
//
//    public void setLoanHistory(String loanHistory) {
//        this.loanHistory = loanHistory;
//    }
//
//    public void setStudentID(String studentID) {
//        this.studentID = studentID;
//    }
//
//    public void setMembershipDate(String membershipDate) {
//        this.membershipDate = membershipDate;
//    }

    public String getNotifications() {
        return notifications;
    }

    public String getLoanHistory() {
        return loanHistory;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudyingField() {
        return studyingField;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getMembershipDate() {
        return membershipDate;
    }

    public String tabSplit(){
        return this.firstName + "\t" +
                this.lastName + "\t" +
                this.studyingField + "\t" +
                this.studentID + "\t" +
                this.membershipDate + "\t" +
                this.notifications + "\t" +
                this.loanHistory + "\t";
    }

}
