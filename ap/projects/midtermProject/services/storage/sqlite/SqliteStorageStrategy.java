package ap.projects.midtermProject.services.storage.sqlite;

import ap.projects.midtermProject.constants.fileName.SqliteSaveFileNames;
import ap.projects.midtermProject.database.Library;
import ap.projects.midtermProject.services.storage.StorageStrategy;

public class SqliteStorageStrategy implements StorageStrategy {

    @Override
    public void saveAll(Library library) {

        try {
            SqliteBookIO.save(library.getBooks(), SqliteSaveFileNames.BOOKS_SQLITE);
        } catch (Exception e) {
            System.out.println("Save book to sqlite file ERROR:" + e.getMessage());
        }
        try {
            SqliteStudentIO.save(library.getStudents(), SqliteSaveFileNames.STUDENT_SQLITE);
        } catch (Exception e) {
            System.out.println("Save student to sqlite file ERROR:" + e.getMessage());
        }
        try {
            SqliteLibrarianIO.save(library.getLibrarians(), SqliteSaveFileNames.LIBRARIANS_SQLITE);
        } catch (Exception e) {
            System.out.println("Save librarian to sqlite file ERROR:" + e.getMessage());
        }
        try {
            SqliteBorrowIO.save(library.getBorrows(), SqliteSaveFileNames.BORROWS_SQLITE);
        } catch (Exception e) {
            System.out.println("Save borrow to sqlite file ERROR:" + e.getMessage());
        }
        try {
            SqliteRequestIO.save(library.getLoanRequests(), SqliteSaveFileNames.BORROW_REQUEST_SQLITE);
        } catch (Exception e) {
            System.out.println("Save loan request to sqlite file ERROR:" + e.getMessage());
        }
        try {
            SqliteRequestIO.save(library.getReturnRequests(), SqliteSaveFileNames.RETURN_REQUEST_SQLITE);
        } catch (Exception e) {
            System.out.println("Save return request to sqlite file ERROR:" + e.getMessage());
        }

    }

    @Override
    public void loadAll(Library lib) {

        try {
            lib.setBooks(SqliteBookIO.load(SqliteSaveFileNames.BOOKS_SQLITE));
        } catch (Exception e) {
            System.out.println("Sqlite book file ERROR:" + e.getMessage());
        }
        try {
            lib.setStudents(SqliteStudentIO.load(SqliteSaveFileNames.STUDENT_SQLITE));
        } catch (Exception e) {
            System.out.println("Sqlite student file ERROR:" + e.getMessage());
        }
        try {
            lib.setLibrarians(SqliteLibrarianIO.load(SqliteSaveFileNames.LIBRARIANS_SQLITE));
        } catch (Exception e) {
            System.out.println("Sqlite librarian file ERROR:" + e.getMessage());
        }
        try {
            lib.setBorrows(SqliteBorrowIO.load(SqliteSaveFileNames.BORROWS_SQLITE));
        } catch (Exception e) {
            System.out.println("Sqlite borrow file ERROR:" + e.getMessage());
        }
        try {
            lib.setLoanRequests(SqliteRequestIO.load(SqliteSaveFileNames.BORROW_REQUEST_SQLITE));
        } catch (Exception e) {
            System.out.println("Sqlite loan request file ERROR:" + e.getMessage());
        }
        try {
            lib.setReturnRequests(SqliteRequestIO.load(SqliteSaveFileNames.RETURN_REQUEST_SQLITE));
        } catch (Exception e) {
            System.out.println("Sqlite return request file ERROR:" + e.getMessage());
        }

    }

}
