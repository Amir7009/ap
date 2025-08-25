package ap.projects.finalProject;

import ap.projects.finalProject.repository.*;
import ap.projects.finalProject.service.*;
import ap.projects.finalProject.ui.MenuHandler;

public class LibrarySystem {

    private final StudentService studentService;
    private final LibrarianService librarianService;
    private final BookService bookService;
    private final LoanService loanService;

    private final MenuHandler menuHandler;

    public LibrarySystem() {

        StudentRepository studentRepository = new StudentRepository();
        this.studentService = new StudentService(studentRepository);

        LibrarianRepository librarianRepository = new LibrarianRepository();
        this.librarianService = new LibrarianService(librarianRepository);

        BookRepository bookRepository = new BookRepository();
        this.bookService = new BookService(bookRepository);

        LoanRepository loanRepository = new LoanRepository();
        this.loanService = new LoanService(loanRepository);

        this.menuHandler = new MenuHandler(this);
    }

    /**
     * just connects the student services with the Library students repository
     *
     * @return the services that student can get from library
     * @see MenuHandler or StudentMenu
     */
    public StudentService getStudentService() {
        return studentService;
    }

    /**
     * just connects the librarian services with the Library librarians repository
     *
     * @return the services that librarian can get from library
     * @see MenuHandler or LibrarianMenu
     */
    public LibrarianService getLibrarianService() {
        return librarianService;
    }

    /**
     * just connects the Book services with the Library books repository
     *
     * @return the services that student can get for library books
     */
    public BookService getBookService() {
        return bookService;
    }

    /**
     * just connects the Loan services with the Library books, students and librarians
     *
     * @return the services that student can get for Borrowing book process
     */
    public LoanService getLoanService() {
        return loanService;
    }

    /**
     * starts the loop of Library System
     */
    public void start() {
        menuHandler.displayMainMenu();
    }
}
