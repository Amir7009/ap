package ap.midterm_project.models;

import java.util.HashMap;
import java.util.Map;

public class Student extends User {

    private String firstName, lastName, studyingField, studentID, membershipDate;

    public Student(String firstName, String lastName, String studyingField, String studentId, String membershipDate){

        super (studentId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.studyingField = studyingField;
        this.studentID = studentId;
        this.membershipDate = membershipDate;

    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studyingField='" + studyingField + '\'' +
                ", studentID='" + studentID + '\'' +
                ", membershipDate='" + membershipDate + '\'' +
                '}';
    }

    // fromString method to parse the input string and return a Student object
    public static Student fromString(String str) {
        str = str.replace("Student{", "")
                .replace("}", "");

        String[] parts = str.split(", ");
        Map<String, String> values = new HashMap<>();

        for (String part : parts) {
            String[] keyValue = part.split("='");
            String key = keyValue[0].trim();
            String value = keyValue[1].substring(0, keyValue[1].length() - 1); // Remove the trailing '
            values.put(key, value);
        }

        return new Student(
                values.get("firstName"),
                values.get("lastName"),
                values.get("studyingField"),
                values.get("studentID"),
                values.get("membershipDate")
        );

    }
}
