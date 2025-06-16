package ap.librarySystem.controllers;

import ap.librarySystem.helpers.MenuHelper;
import ap.librarySystem.constants.SaveDataRoles;
import ap.librarySystem.constants.accessMenuRoles.LibrarianAccessMenu;
import ap.librarySystem.constants.accessMenuRoles.ManagerAccessMenu;
import ap.librarySystem.constants.accessMenuRoles.StudentAccessMenu;
import ap.librarySystem.constants.accessMenuRoles.StudentLoginMenu;
import ap.librarySystem.helpers.Printer;
import ap.librarySystem.services.*;
import ap.librarySystem.constants.UserRoles;
import ap.librarySystem.database.Library;
import ap.librarySystem.services.storage.FileManager;
import ap.librarySystem.services.storage.config.ConfigReader;
import ap.librarySystem.services.storage.config.ConfigWriter;

import java.util.ArrayList;

public class SwitchHandler {

    Library library;
    FileManager fileManager;
    Printer printer = new Printer();
    MenuHelper menu = new MenuHelper();
    BorrowHandler borrowHandler = new BorrowHandler();
    Authentication authentication = new Authentication();
    SearchBox search = new SearchBox();
    AddObject add = new AddObject();
    Editor edit = new Editor();

    /**
     * Create a command line for managing library tasks.
     * @param library has instantiated in MainLibrary and all changes applies on it.
     */
    public SwitchHandler(Library library) {
        this.library = library;
        fileManager = new FileManager();
    }

    /**
     * for select user role.
     * @param role the role that selected by user in MainLibrary class
     */
    public void handleRoleMenu(UserRoles role) {

        switch (role) {
            case STUDENT -> handleStudentLoginMenu();
            case LIBRARIAN -> {
                String librarianID = authentication.signIn(library.getLibrarians());
                if (librarianID != null)
                    handleLibrarianMenu(librarianID);
            }
            case MANAGER -> {
                String managerID = authentication.signIn(library.getLibraryManager());
                if (managerID != null)
                    handleManagerMenu(managerID);
            }
            case EXIT -> System.exit(0);


            case INVALID_OPTION -> System.out.println("Invalid option!");
        }

    }

    /**
     * students can sign in or sign up if they didn't sign up yet.
     * @see Authentication
     */
    private void handleStudentLoginMenu() {

        boolean whileCondition = true;
        while (whileCondition) {

            StudentLoginMenu option = switch (menu.studentLoginMenu()) {
                case 1 -> StudentLoginMenu.SIGN_IN;
                case 2 -> StudentLoginMenu.SIGN_UP;
                case 0 -> StudentLoginMenu.BACK;
                case -1 -> null;
                default -> StudentLoginMenu.INVALID_OPTION;
            };

            if (option != null) {

                switch (option) {

                    case SIGN_IN -> {
                        String studentID = authentication.signIn(library.getStudents());
                        if (studentID != null)
                            handleStudentAccessMenu(studentID);
                    }
                    case SIGN_UP -> authentication.signUp(library.getStudents());
                    case BACK -> whileCondition = false;
                    case INVALID_OPTION -> System.out.println("Invalid option!");

                }

            }

        }

    }

    /**
     * Provide all the access and options that a student has.
     * @param studentID has used To monitor and record the activities that the student has performed.
     */
    private void handleStudentAccessMenu(String studentID) {

        boolean whileCondition = true;
        while (whileCondition) {

            StudentAccessMenu option = switch (menu.studentAccessMenu()) {
                case 1 -> StudentAccessMenu.SHOW_LIBRARY_BOOKS;
                case 2 -> StudentAccessMenu.SEARCH_A_BOOK;
                case 3 -> StudentAccessMenu.REQUEST_TO_BORROW_A_BOOK;
                case 4 -> StudentAccessMenu.REQUEST_TO_RETURN_A_BOOK;
                case 5 -> StudentAccessMenu.UNRETURNED_BOOKS;
                case 6 -> StudentAccessMenu.VIEW_MY_BOOK_LOAN_HISTORY;
                case 7 -> StudentAccessMenu.SHOW_NOTIFICATIONS;
                case 0 -> StudentAccessMenu.BACK;
                case -1 -> null;
                default -> StudentAccessMenu.INVALID_OPTION;
            };

            if (option != null) {

                switch (option) {
                    case SHOW_LIBRARY_BOOKS ->
                            printer.printObjectInfo(new ArrayList<>(library.getBooks().values()));
                    case SEARCH_A_BOOK ->
                            search.searchBooks(library.getBooks());
                    case REQUEST_TO_BORROW_A_BOOK ->
                            borrowHandler.makeLoanRequest(library, studentID);
                    case REQUEST_TO_RETURN_A_BOOK ->
                            borrowHandler.makeReturnRequest(library, studentID);
                    case UNRETURNED_BOOKS ->
                            printer.printStudentUnreturnedBooks(library, studentID);
                    case VIEW_MY_BOOK_LOAN_HISTORY ->
                            printer.printStudentHistory(library.getStudents().get(studentID));
                    case SHOW_NOTIFICATIONS ->
                            printer.showStudentNotifications(library.getStudents().get(studentID));
                    case BACK -> whileCondition = false;
                    case INVALID_OPTION -> System.out.println("Invalid option!");
                }

            }

        }

    }

    /**
     * Provide all the access and options that a librarian has.
     * @param librarianID has used To monitor and record the activities that the librarian has performed.
     */
    private void handleLibrarianMenu(String librarianID) {

        boolean whileCondition = true;
        while (whileCondition) {

            LibrarianAccessMenu option = switch (menu.librariansAccessMenu()) {
                case 1 -> LibrarianAccessMenu.EDIT_INFO;
                case 2 -> LibrarianAccessMenu.ADD_A_NEW_BOOK;
                case 3 -> LibrarianAccessMenu.BORROW_REQUESTS;
                case 4 -> LibrarianAccessMenu.RETURN_REQUESTS;
                case 5 -> LibrarianAccessMenu.UNRETURNED_BOOKS;
                case 6 -> LibrarianAccessMenu.VIEW_MY_ALL_BOOK_LEND_HISTORY;
                case 7 -> LibrarianAccessMenu.VIEW_MY_ALL_BOOK_RECLAIM_HISTORY;
                case 8 -> LibrarianAccessMenu.VIEW_STUDENT_BOOK_LOAN_HISTORY;
                case 0 -> LibrarianAccessMenu.BACK;
                case -1 -> null;
                default -> LibrarianAccessMenu.INVALID_OPTION;
            };

            if (option != null) {

                switch (option) {
                    case EDIT_INFO ->
                            edit.editLibrarianInfo(library.getLibrarians().get(librarianID));
                    case ADD_A_NEW_BOOK ->
                            add.addBook(library.getBooks());
                    case BORROW_REQUESTS ->
                            borrowHandler.acceptRequest(library.getLoanRequests(), library, librarianID);
                    case RETURN_REQUESTS ->
                            borrowHandler.acceptRequest(library.getReturnRequests(), library, librarianID);
                    case UNRETURNED_BOOKS ->
                            printer.printUnreturnedBooks(library);
                    case VIEW_MY_ALL_BOOK_LEND_HISTORY ->
                            printer.printLibrarianHistory(library.getLibrarians().get(librarianID).getLendReport());
                    case VIEW_MY_ALL_BOOK_RECLAIM_HISTORY ->
                            printer.printLibrarianHistory(library.getLibrarians().get(librarianID).getReceiveReport());
                    case VIEW_STUDENT_BOOK_LOAN_HISTORY -> {
                        String studentID = search.searchStudent(library.getStudents());
                        if (studentID != null)
                            printer.printStudentHistory(library.getStudents().get(studentID));
                    }
                    case BACK -> whileCondition = false;
                    case INVALID_OPTION -> System.out.println("Invalid option!");
                }

            }

        }

    }

    /**
     * To monitor and record the activities that the library manager has performed.
     * @param managerID is unused because we have one, but we may have more in the future.
     */
    private void handleManagerMenu(String managerID) {

        boolean whileCondition = true;
        while (whileCondition) {

            ManagerAccessMenu option = switch (menu.managerAccessMenu()) {
                case 1 -> ManagerAccessMenu.ADD_A_LIBRARIAN;
                case 2 -> ManagerAccessMenu.SEE_ALL_LATE_BOOKS;
                case 3 -> ManagerAccessMenu.VIEW_A_LIBRARIAN_PERFORMANCE;
                case 4 -> ManagerAccessMenu.VIEW_TOP_TEN_BORROWED_BOOKS_IN_LAST_YEAR;
                case 0 -> ManagerAccessMenu.BACK;
                case -1 -> null;
                default -> ManagerAccessMenu.INVALID_OPTION;
            };

            if (option != null) {

                switch (option) {
                    case ADD_A_LIBRARIAN -> add.addLibrarian(library.getLibrarians());
                    case SEE_ALL_LATE_BOOKS -> printer.printLateBooks(library.getBorrows());
                    case VIEW_A_LIBRARIAN_PERFORMANCE -> {
                        String librarianID = search.searchLibrarian(library.getLibrarians());
                        if (librarianID != null) {
                            printer.printLibrarianHistory(library.getLibrarians().get(librarianID).getLendReport());
                            System.out.println("\n---\n");
                            printer.printLibrarianHistory(library.getLibrarians().get(librarianID).getReceiveReport());
                        } else
                            System.out.println("Librarian not found!");
                    }
                    case VIEW_TOP_TEN_BORROWED_BOOKS_IN_LAST_YEAR -> printer.printTopTenBook(library.getBorrows());
                    case BACK -> whileCondition = false;
                    case INVALID_OPTION -> System.out.println("Invalid option!");
                }

            }

        }

    }

    /**
     * To choose the method and type of data storage and how to read it in the next execution.
     * @see ConfigReader
     * @see ConfigWriter
     */
    public void handSaveDataTypeMenu() {

        boolean whileCondition = true;
        while (whileCondition) {

            SaveDataRoles option = switch (menu.saveTypeMenu()) {
                case 1 -> SaveDataRoles.JSON;
                case 2 -> SaveDataRoles.TAB_SPLIT;
                case 3 -> SaveDataRoles.SQLITE;
                case -1 -> null;
                default -> SaveDataRoles.INVALID_OPTION;
            };

            if (option != null) {

                switch (option) {

                    case JSON -> {
                        ConfigWriter.writeStorageType("json");
                        fileManager.saveLibraryToJson(library);
                        whileCondition = false;
                    }
                    case TAB_SPLIT -> {
                        ConfigWriter.writeStorageType("tabsplit");
                        fileManager.saveLibraryToTabSplit(library);
                        whileCondition = false;
                    }
                    case SQLITE -> {
                        ConfigWriter.writeStorageType("sqlite");
                        fileManager.saveLibraryToSqlite(library);
                        whileCondition = false;
                    }
                    case INVALID_OPTION -> System.out.println("Invalid option!");

                }

            }

        }

    }

}
