package ap.projects.midtermProject.services.storage.sqlite;

import ap.projects.midtermProject.models.Librarian;

import java.sql.*;
import java.util.LinkedHashMap;

public class SqliteLibrarianIO {

    public static void save(LinkedHashMap<String, Librarian> librarians, String fileName) {
        try (   // create a database connection
                Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileName);
                Statement statement = connection.createStatement();
        ) {
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists librarians");
            statement.executeUpdate("create table librarians (" +
                    "employeeID string, " +
                    "firstName string, " +
                    "lastName string, " +
                    "lendReport string, " +
                    "receiveReport string, " +
                    "nationalID string, " +
                    "address string, " +
                    "educationLevel string, " +
                    "phoneNumber string)"
            );

            for (Librarian librarian : librarians.values()) {
                statement.executeUpdate("insert into librarians values('" +
                        librarian.getEmployeeID() + "', '" +
                        librarian.getFirstName() + "', '" +
                        librarian.getLastName() + "', '" +
                        librarian.getLendReport() + "', '" +
                        librarian.getReceiveReport() + "', '" +
                        librarian.getNationalID() + "', '" +
                        librarian.getAddress() + "', '" +
                        librarian.getEducationLevel() + "', '" +
                        librarian.getPhoneNumber() + "')");
            }

        } catch (SQLException e) {
            System.err.println("Error writing librarians to Sqlite: " + e.getMessage());
        }
    }

    public static LinkedHashMap<String, Librarian> load(String fileName) {

        try (    // create a database connection
                 Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileName);
                 Statement statement = connection.createStatement();
        ) {
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet rs = statement.executeQuery("select * from librarians");
            LinkedHashMap<String, Librarian> librarians = new LinkedHashMap<>();
            while (rs.next()) {
                Librarian librarian = new Librarian(
                        rs.getString("employeeID"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("lendReport"),
                        rs.getString("receiveReport")
                );
                librarian.setNationalID(rs.getString("nationalID"));
                librarian.setAddress(rs.getString("address"));
                librarian.setEducationLevel(rs.getString("educationLevel"));
                librarian.setPhoneNumber(rs.getString("phoneNumber"));

                librarians.put(librarian.getEmployeeID(), librarian);
            }
            return librarians;

        } catch (SQLException e) {
            System.err.println("Error reading librarians from Sqlite: " + e.getMessage());
            return null;
        }

    }

}
