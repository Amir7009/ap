package ap.projects.midtermProject.services.storage.sqlite;

import ap.projects.midtermProject.models.Student;

import java.sql.*;
import java.util.LinkedHashMap;

public class SqliteStudentIO {

    public static void save(LinkedHashMap<String, Student> students, String fileName) {
        try (   // create a database connection
                Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileName);
                Statement statement = connection.createStatement();
        ) {
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists students");
            statement.executeUpdate("create table students (" +
                    "firstName string, " +
                    "lastName string, " +
                    "studyingField string, " +
                    "studentId string, " +
                    "membershipDate string, " +
                    "notifications string, " +
                    "loanHistory string)"
            );

            for (Student student : students.values()) {
                statement.executeUpdate("insert into students values('" +
                        student.getFirstName() + "', '" +
                        student.getLastName() + "', '" +
                        student.getStudyingField() + "', '" +
                        student.getStudentID() + "', '" +
                        student.getMembershipDate() + "', '" +
                        student.getNotifications() + "', '" +
                        student.getLoanHistory() + "')");
            }

        } catch (SQLException e) {
            System.err.println("Error writing students to Sqlite: " + e.getMessage());
        }
    }

    public static LinkedHashMap<String, Student> load(String fileName) {

        try (    // create a database connection
                 Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileName);
                 Statement statement = connection.createStatement();
        ) {
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet rs = statement.executeQuery("select * from students");
            LinkedHashMap<String, Student> students = new LinkedHashMap<>();
            while (rs.next()) {
                Student student = new Student(
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("studyingField"),
                        rs.getString("studentId"),
                        rs.getString("membershipDate"),
                        rs.getString("notifications"),
                        rs.getString("loanHistory")
                );
                students.put(student.getStudentID(), student);
            }
            return students;

        } catch (SQLException e) {
            System.err.println("Error reading students from Sqlite: " + e.getMessage());
            return null;
        }

    }

}
