package ap.librarySystem.models;

public class Librarian extends User {

    private String
            employeeID,
            firstName,
            lastName,
            nationalID,
            address,
            educationLevel,
            phoneNumber,
            receiveReport,
            lendReport;

    public Librarian(String employeeID, String firstName, String lastName, String lendReport, String receiveReport) {

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

    public void setLendReport(String lendReport){
        this.lendReport = this.lendReport.concat("-" +lendReport);
    }

    public String getLendReport() {
        return lendReport;
    }

    public String getReceiveReport() {
        return receiveReport;
    }

    // for save librarians' data in file
    @Override
    public String toString() {
        return "Librarian{" +
                "employeeID='" + employeeID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalID='" + nationalID + '\'' +
                ", Address='" + address + '\'' +
                ", educationLevel='" + educationLevel + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", receiveReport='" + receiveReport + '\'' +
                ", lendReport='" + lendReport + '\'' +
                '}';
    }

    // fromString method to parse the input string and return a Librarian object

}
