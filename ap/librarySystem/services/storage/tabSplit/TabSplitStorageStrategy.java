package ap.librarySystem.services.storage.tabSplit;

import ap.librarySystem.constants.fileName.TabSplitSaveFileNames;
import ap.librarySystem.database.Library;
import ap.librarySystem.services.storage.StorageStrategy;

public class TabSplitStorageStrategy implements StorageStrategy {

    @Override
    public void saveAll(Library library) {

        try {
            TabSplitBookIO.save(library.getBooks(), TabSplitSaveFileNames.BOOKS_TAB_SPLIT);
        } catch (Exception e) {
            System.out.println("Save book to tab-split file ERROR:" + e.getMessage());
        }
        try {
            TabSplitStudentIO.save(library.getStudents(), TabSplitSaveFileNames.STUDENT_TAB_SPLIT);
        } catch (Exception e) {
            System.out.println("Save student to tab-split file ERROR:" + e.getMessage());
        }
        try {
            TabSplitLibrarianIO.save(library.getLibrarians(), TabSplitSaveFileNames.LIBRARIANS_TAB_SPLIT);
        } catch (Exception e) {
            System.out.println("Save librarian to tab-split file ERROR:" + e.getMessage());
        }
        try {
            TabSplitBorrowIO.save(library.getBorrows(), TabSplitSaveFileNames.BORROWS_TAB_SPLIT);
        } catch (Exception e) {
            System.out.println("Save borrow to tab-split file ERROR:" + e.getMessage());
        }
        try {
            TabSplitRequestIO.save(library.getLoanRequests(), TabSplitSaveFileNames.BORROW_REQUEST_TAB_SPLIT);
        } catch (Exception e) {
            System.out.println("Save loan request to tab-split file ERROR:" + e.getMessage());
        }
        try {
            TabSplitRequestIO.save(library.getReturnRequests(), TabSplitSaveFileNames.RETURN_REQUEST_TAB_SPLIT);
        } catch (Exception e) {
            System.out.println("Save return request to tab-split file ERROR:" + e.getMessage());
        }

    }

    @Override
    public void loadAll(Library lib) {

        try {
            lib.setBooks(TabSplitBookIO.load(TabSplitSaveFileNames.BOOKS_TAB_SPLIT));
        } catch (Exception e) {
            System.out.println("TabSplit book file ERROR:" + e.getMessage());
        }
        try {
            lib.setStudents(TabSplitStudentIO.load(TabSplitSaveFileNames.STUDENT_TAB_SPLIT));
        } catch (Exception e) {
            System.out.println("TabSplit student file ERROR:" + e.getMessage());
        }
        try {
            lib.setLibrarians(TabSplitLibrarianIO.load(TabSplitSaveFileNames.LIBRARIANS_TAB_SPLIT));
        } catch (Exception e) {
            System.out.println("TabSplit librarian file ERROR:" + e.getMessage());
        }
        try {
            lib.setBorrows(TabSplitBorrowIO.load(TabSplitSaveFileNames.BORROWS_TAB_SPLIT));
        } catch (Exception e) {
            System.out.println("TabSplit borrow file ERROR:" + e.getMessage());
        }
        try {
            lib.setLoanRequests(TabSplitRequestIO.load(TabSplitSaveFileNames.BORROW_REQUEST_TAB_SPLIT));
        } catch (Exception e) {
            System.out.println("TabSplit loan request file ERROR:" + e.getMessage());
        }
        try {
            lib.setReturnRequests(TabSplitRequestIO.load(TabSplitSaveFileNames.RETURN_REQUEST_TAB_SPLIT));
        } catch (Exception e) {
            System.out.println("TabSplit return request file ERROR:" + e.getMessage());
        }

    }

}
