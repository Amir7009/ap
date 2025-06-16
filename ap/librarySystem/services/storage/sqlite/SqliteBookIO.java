package ap.librarySystem.services.storage.sqlite;

import ap.librarySystem.constants.BookStatus;
import ap.librarySystem.models.Book;

import java.sql.*;
import java.util.LinkedHashMap;

public class SqliteBookIO {

    public static void save(LinkedHashMap<String, Book> books, String fileName) {
        try (   // create a database connection
                Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileName);
                Statement statement = connection.createStatement();
        ) {
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists books");
            statement.executeUpdate("create table books (" +
                    "title string, " +
                    "author string, " +
                    "page string, " +
                    "year string, " +
                    "ISBN string, " +
                    "bookStatus string)"
            );

            for (Book book : books.values()) {
                statement.executeUpdate("insert into books values('" +
                        book.getTitle() + "', '" +
                        book.getAuthor() + "', '" +
                        book.getPages() + "', '" +
                        book.getYear() + "', '" +
                        book.getISBN() + "', '" +
                        book.getBookStatus() + "')");
            }

        } catch (SQLException e) {
            System.err.println("Error writing books to Sqlite: " + e.getMessage());
        }
    }

    public static LinkedHashMap<String, Book> load(String fileName) {

        try (    // create a database connection
                 Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileName);
                 Statement statement = connection.createStatement();
        ) {
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet rs = statement.executeQuery("select * from books");
            LinkedHashMap<String, Book> books = new LinkedHashMap<>();
            while (rs.next()) {
                Book book = new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("page"),
                        rs.getString("year"),
                        rs.getString("ISBN"),
                        BookStatus.valueOf(rs.getString("bookStatus"))
                );
                books.put(book.getISBN(), book);
            }
            return books;

        } catch (SQLException e) {
            System.err.println("Error reading books from Sqlite: " + e.getMessage());
            return null;
        }

    }

}
