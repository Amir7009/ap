package ap.librarySystem.models;

public class Librarian extends User {

    private String
            employeeID,
            firstName,
            lastName,
            lendReport,
            receiveReport,
            nationalID,
            address,
            educationLevel,
            phoneNumber;

    public Librarian(
            String employeeID,
            String firstName,
            String lastName,
            String lendReport,
            String receiveReport
    ){

        super(employeeID);
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lendReport = lendReport;
        this.receiveReport = receiveReport;

    }

    // setter method for edit librarian's info
    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setReceiveReport(String receiveReport) {
        this.receiveReport = this.receiveReport.concat("-" + receiveReport);
    }

    public void setLendReport(String lendReport) {
        this.lendReport = this.lendReport.concat("-" + lendReport);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getLendReport() {
        return lendReport;
    }

    public String getReceiveReport() {
        return receiveReport;
    }

    public String tabSplit() {
        return this.employeeID + "\t" +
                this.firstName + "\t" +
                this.lastName + "\t" +
                this.lendReport + "\t" +
                this.receiveReport + "\t" +
                this.nationalID + "\t" +
                this.address + "\t" +
                this.educationLevel + "\t" +
                this.phoneNumber + "\t";
    }

}
