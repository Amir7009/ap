package ap.projects.midtermProject.services.storage.sqlite;

import ap.projects.midtermProject.constants.RequestType;
import ap.projects.midtermProject.models.borrowSystem.Request;

import java.sql.*;
import java.util.ArrayList;

public class SqliteRequestIO {

    public static void save(ArrayList<Request> requests, String fileName) {
        try (   // create a database connection
                Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileName);
                Statement statement = connection.createStatement();
        ) {
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists requests");
            statement.executeUpdate("create table requests (" +
                    "borrowerStudentID string, " +
                    "borrowedBookISBN string, " +
                    "requestType string, " +
                    "librarianID string)"
            );

            for (Request request : requests) {
                statement.executeUpdate("insert into requests values('" +
                        request.getBorrowerStudentID() + "', '" +
                        request.getBorrowedBookISBN() + "', '" +
                        request.getRequestType() + "', '" +
                        request.getLibrarianID() + "')");
            }

        } catch (SQLException e) {
            System.err.println("Error writing requests to Sqlite: " + e.getMessage());
        }
    }

    public static ArrayList<Request> load(String fileName) {

        try (    // create a database connection
                 Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileName);
                 Statement statement = connection.createStatement();
        ) {
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet rs = statement.executeQuery("select * from requests");
            ArrayList<Request> requests = new ArrayList<>();
            while (rs.next()) {
                Request request = new Request(
                        rs.getString("borrowerStudentID"),
                        rs.getString("borrowedBookISBN"),
                        RequestType.valueOf(rs.getString("requestType")),
                        rs.getString("librarianID")

                );

                requests.add(request);
            }
            return requests;

        } catch (SQLException e) {
            System.err.println("Error reading requests from Sqlite: " + e.getMessage());
            return null;
        }

    }

}
