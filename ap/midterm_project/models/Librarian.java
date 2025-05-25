package ap.midterm_project.models;

import java.util.HashMap;
import java.util.Map;

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

    public Librarian(String employeeID, String firstName, String lastName) {

        super(employeeID);
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lendReport = "-";
        this.receiveReport = "-";

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
        this.receiveReport = this.receiveReport.concat(receiveReport);
    }

    public void setLendReport(String lendReport){
        this.lendReport = this.lendReport.concat(lendReport);
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
    public static Librarian fromString(String str) {
        str = str.replace("Librarian{", "")
                .replace("}", "");

        String[] parts = str.split(", ");
        Map<String, String> values = new HashMap<>();

        for (String part : parts) {
            String[] keyValue = part.split("='");
            String key = keyValue[0].trim();
            String value = keyValue[1].substring(0, keyValue[1].length() - 1); // Remove the trailing '
            values.put(key, value);
        }

        Librarian readLibrarian = new Librarian(
                values.get("employeeID"),
                values.get("firstName"),
                values.get("lastName")
        );

        readLibrarian.setNationalID(values.get("nationalID"));
        readLibrarian.setAddress(values.get("Address"));
        readLibrarian.setEducationLevel(values.get("educationLevel"));
        readLibrarian.setPhoneNumber(values.get("phoneNumber"));
        String receive = values.getOrDefault("receiveReport", "");
        readLibrarian.receiveReport = receive == null ? "" : receive;

        String lend = values.getOrDefault("lendReport", "");
        readLibrarian.lendReport = lend == null ? "" : lend;

        return readLibrarian;
    }

}
