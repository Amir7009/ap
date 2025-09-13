package ap.projects.midtermProject.services.storage.json;

import ap.projects.midtermProject.constants.fileName.JsonSaveFileNames;
import ap.projects.midtermProject.database.Library;
import ap.projects.midtermProject.services.storage.StorageStrategy;

public class JsonStorageStrategy implements StorageStrategy {

    @Override
    public void saveAll(Library library) {

        try {
            JsonBookIO.save(library.getBooks(), JsonSaveFileNames.BOOKS_JSON);
        } catch (Exception e) {
            System.out.println("Save book to Json file ERROR:" + e.getMessage());
        }
        try {
            JsonStudentIO.save(library.getStudents(), JsonSaveFileNames.STUDENT_JSON);
        } catch (Exception e) {
            System.out.println("Save student to Json file ERROR:" + e.getMessage());
        }
        try {
            JsonLibrarianIO.save(library.getLibrarians(), JsonSaveFileNames.LIBRARIANS_JSON);
        } catch (Exception e) {
            System.out.println("Save librarian to Json file ERROR:" + e.getMessage());
        }
        try {
            JsonBorrowIO.save(library.getBorrows(), JsonSaveFileNames.BORROWS_JSON);
        } catch (Exception e) {
            System.out.println("Save borrow to Json file ERROR:" + e.getMessage());
        }
        try {
            JsonRequestIO.save(library.getLoanRequests(), JsonSaveFileNames.BORROW_REQUEST_JSON);
        } catch (Exception e) {
            System.out.println("Save loan request to Json file ERROR:" + e.getMessage());
        }
        try {
            JsonRequestIO.save(library.getReturnRequests(), JsonSaveFileNames.RETURN_REQUEST_JSON);
        } catch (Exception e) {
            System.out.println("Save return request to Json file ERROR:" + e.getMessage());
        }

    }

    @Override
    public void loadAll(Library lib) {

        try {
            lib.setBooks(JsonBookIO.load(JsonSaveFileNames.BOOKS_JSON));
        } catch (Exception e) {
            System.out.println("Json book file ERROR:" + e.getMessage());
        }
        try {
            lib.setStudents(JsonStudentIO.load(JsonSaveFileNames.STUDENT_JSON));
        } catch (Exception e) {
            System.out.println("Json student file ERROR:" + e.getMessage());
        }
        try {
            lib.setLibrarians(JsonLibrarianIO.load(JsonSaveFileNames.LIBRARIANS_JSON));
        } catch (Exception e) {
            System.out.println("Json librarian file ERROR:" + e.getMessage());
        }
        try {
            lib.setBorrows(JsonBorrowIO.load(JsonSaveFileNames.BORROWS_JSON));
        } catch (Exception e) {
            System.out.println("Json borrow file ERROR:" + e.getMessage());
        }
        try {
            lib.setLoanRequests(JsonRequestIO.load(JsonSaveFileNames.BORROW_REQUEST_JSON));
        } catch (Exception e) {
            System.out.println("Json loan request file ERROR:" + e.getMessage());
        }
        try {
            lib.setReturnRequests(JsonRequestIO.load(JsonSaveFileNames.RETURN_REQUEST_JSON));
        } catch (Exception e) {
            System.out.println("Json return request files ERROR:" + e.getMessage());
        }

    }

}