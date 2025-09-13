package ap.projects.midtermProject.services.storage.sqlite;

import ap.projects.midtermProject.models.borrowSystem.Borrow;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SqliteBorrowIO {

    public static void save(ArrayList<Borrow> borrows, String fileName) {
        try (   // create a database connection
                Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileName);
                Statement statement = connection.createStatement();
        ) {
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists borrows");
            statement.executeUpdate("create table borrows (" +
                    "borrowerStudentID string, " +
                    "borrowedBookISBN string, " +
                    "lenderLibrarianID string, " +
                    "loanStartDate, " +
                    "loanFinishDate string, " +
                    "reclaimerLibrarianID string, " +
                    "actualReturnDate string)"
            );

            for (Borrow borrow : borrows) {
                statement.executeUpdate("insert into borrows values('" +
                        borrow.getBorrowerStudentID() + "', '" +
                        borrow.getBorrowedBookISBN() + "', '" +
                        borrow.getLenderLibrarianID() + "', '" +
                        borrow.getLoanStartDate() + "', '" +
                        borrow.getLoanFinishDate() + "', '" +
                        borrow.getReclaimerLibrarianID() + "', '" +
                        borrow.getReclaimerLibrarianID() + "')");
            }

        } catch (SQLException e) {
            System.err.println("Error writing borrows to Sqlite: " + e.getMessage());
        }
    }

    public static ArrayList<Borrow> load(String fileName) {

        try (    // create a database connection
                 Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileName);
                 Statement statement = connection.createStatement();
        ) {
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet rs = statement.executeQuery("select * from borrows");
            ArrayList<Borrow> borrows = new ArrayList<>();
            while (rs.next()) {
                Borrow borrow = new Borrow(
                        rs.getString("borrowerStudentID"),
                        rs.getString("borrowedBookISBN"),
                        rs.getString("lenderLibrarianID"),
                        LocalDate.parse(rs.getString("loanStartDate")),
                        LocalDate.parse(rs.getString("loanFinishDate"))

                );
                borrow.setReclaimerLibrarianID(rs.getString("reclaimerLibrarianID"));
                borrow.setActualReturnDate(LocalDate.parse(rs.getString("actualReturnDate")));

                borrows.add(borrow);
            }
            return borrows;

        } catch (SQLException e) {
            System.err.println("Error reading borrows from Sqlite: " + e.getMessage());
            return null;
        }

    }

}
