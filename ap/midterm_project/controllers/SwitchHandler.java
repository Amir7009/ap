package ap.midterm_project.controllers;

import ap.midterm_project.helpers.Printer;
import ap.midterm_project.services.*;
import ap.midterm_project.constants.*;
import ap.midterm_project.constants.UserRoles;
import ap.midterm_project.database.Library;

public class SwitchHandler {

    MenuHelper menu = new MenuHelper();
    Authentication authentication = new Authentication();
    Library library;
    Printer printer = new Printer();
    SearchBox search = new SearchBox();
    Editor edit = new Editor();
    AddObject add = new AddObject();
    FileManager fileManager = new FileManager();
    BorrowHandler borrowHandler = new BorrowHandler();

    public SwitchHandler(Library library) {
        this.library = library;
    }

    public void handleRoleMenu(UserRoles role) {

        switch (role) {
            case STUDENT -> handleStudentLoginMenu();
            case LIBRARIAN -> {
                int index = authentication.signIn(library.getLibrarians());
                if (index >= 0)
                    handleLibrarianMenu(index);
            }
            case MANAGER -> {
                int index = authentication.signIn(library.getLibraryManager());
                if (index >= 0)
                    handleManagerMenu(index);
            }
            case EXIT -> {
                fileManager.save(library);
                System.exit(0);
            }
            case INVALID_OPTION -> System.out.println("Invalid option!");
        }

    }

    private void handleStudentLoginMenu() {

        boolean whileCondition = true;
        while (whileCondition) {

            StudentLoginMenu option = switch (menu.studentLoginMenu()) {
                case 1 -> StudentLoginMenu.SIGN_IN;
                case 2 -> StudentLoginMenu.SIGN_UP;
                case 3 -> StudentLoginMenu.BACK;
                case -1 -> null;
                default -> StudentLoginMenu.INVALID_OPTION;
            };

            if (option != null) {

                switch (option) {
                    case SIGN_IN -> {
                        int index = authentication.signIn(library.getLibraryStudents());
                        if (index >= 0)
                            handleStudentAccessMenu(index);
                    }
                    case SIGN_UP -> authentication.signUp(library.getLibraryStudents());
                    case BACK -> whileCondition = false;
                    case INVALID_OPTION -> System.out.println("Invalid option!");
                }

            }

        }

    }

    private void handleStudentAccessMenu(int studentIndex) {

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
                case 8 -> StudentAccessMenu.BACK;
                case -1 -> null;
                default -> StudentAccessMenu.INVALID_OPTION;
            };

            if (option != null) {

                switch (option) {
                    case SHOW_LIBRARY_BOOKS -> printer.printObjectInfo(library.getBooks());
                    case SEARCH_A_BOOK -> search.searchBooks(library.getBooks());
                    case REQUEST_TO_BORROW_A_BOOK -> {
                        borrowHandler.makeLoanRequest(library, library.getLibraryStudents().get(studentIndex));
                    }
                    case REQUEST_TO_RETURN_A_BOOK -> {
                        borrowHandler.makeReturnRequest(library, library.getLibraryStudents().get(studentIndex));
                    }
                    case UNRETURNED_BOOKS -> {
                        printer.printUnreturnedBooks(library.getLoans(), library.getLibraryStudents().get(studentIndex));
                    }
                    case SHOW_NOTIFICATIONS -> printer.showStudentNotifications(library.getLibraryStudents().get(studentIndex));
                    case BACK -> whileCondition = false;
                    case INVALID_OPTION -> System.out.println("Invalid option!");
                }

            }

        }

    }

    private void handleLibrarianMenu(int librarianIndex) {

        boolean whileCondition = true;
        while (whileCondition) {

            LibrarianAccessMenu option = switch (menu.librariansAccessMenu()) {
                case 1 -> LibrarianAccessMenu.EDIT_INFO;
                case 2 -> LibrarianAccessMenu.ADD_A_NEW_BOOK;
                case 3 -> LibrarianAccessMenu.BORROW_REQUESTS;
                case 4 -> LibrarianAccessMenu.RETURN_REQUESTS;
                case 5 -> LibrarianAccessMenu.UNRETURNED_BOOKS;
                case 6 -> LibrarianAccessMenu.VIEW_MY_ALL_BOOK_LOAN_HISTORY;
                case 7 -> LibrarianAccessMenu.VIEW_STUDENT_BOOK_LOAN_HISTORY;
                case 8 -> LibrarianAccessMenu.BACK;
                case -1 -> null;
                default -> LibrarianAccessMenu.INVALID_OPTION;
            };

            if (option != null) {

                switch (option) {
                    case EDIT_INFO -> edit.editLibrarianInfo(library.getLibrarians().get(librarianIndex));
                    case ADD_A_NEW_BOOK -> add.addBook(library.getBooks());
                    case BORROW_REQUESTS ->{
                        borrowHandler.acceptRequest(library.getLoanRequests(), library, librarianIndex);
                    }
                    case RETURN_REQUESTS -> {
                        borrowHandler.acceptRequest(library.getReturnRequests(), library, librarianIndex);
                    }
                    case BACK -> whileCondition = false;
                    case INVALID_OPTION -> System.out.println("Invalid option!");
                }

            }

        }

    }

    private void handleManagerMenu(int managerIndex) {

        boolean whileCondition = true;
        while (whileCondition) {

            ManagerAccessMenu option = switch (menu.managerAccessMenu()) {
                case 1 -> ManagerAccessMenu.ADD_A_LIBRARIAN;
                case 2 -> ManagerAccessMenu.SEE_ALL_LATE_BOOKS;
                case 3 -> ManagerAccessMenu.VIEW_A_LIBRARIAN_PERFORMANCE;
                case 4 -> ManagerAccessMenu.VIEW_TOP_TEN_BORROWED_BOOKS_IN_LAST_YEAR;
                case 5 -> ManagerAccessMenu.BACK;
                case -1 -> null;
                default -> ManagerAccessMenu.INVALID_OPTION;
            };

            if (option != null) {

                switch (option) {
                    case ADD_A_LIBRARIAN -> add.addLibrarian(library.getLibrarians());
                    case BACK -> whileCondition = false;
                    case INVALID_OPTION -> System.out.println("Invalid option!");
                }

            }

        }

    }

}
