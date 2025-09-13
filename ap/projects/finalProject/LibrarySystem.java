package ap.projects.finalProject;

import ap.projects.finalProject.repository.*;
import ap.projects.finalProject.service.*;
import ap.projects.finalProject.ui.LoginMenuHandler;

public class LibrarySystem {

    private final StudentService studentService;
    private final LibrarianService librarianService;
    private final BookService bookService;
    private final LoanService loanService;

    private final LoginMenuHandler menuHandler;

    public LibrarySystem() {

        StudentRepository studentRepository = new StudentRepository();
        this.studentService = new StudentService(studentRepository);

        LibrarianRepository librarianRepository = new LibrarianRepository();
        this.librarianService = new LibrarianService(librarianRepository);

        BookRepository bookRepository = new BookRepository();
        this.bookService = new BookService(bookRepository);

        LoanRepository loanRepository = new LoanRepository();
        this.loanService = new LoanService(loanRepository);

        this.menuHandler = new LoginMenuHandler(this);
    }

    /**
     * Just connects the student services with the Library students repository
     *
     * @return the services that student can get from library
     * @see LoginMenuHandler or StudentMenu
     */
    public StudentService getStudentService() {
        return studentService;
    }

    /**
     * Just connects the librarian services with the Library librarians repository
     *
     * @return the services that librarian can get from library
     * @see LoginMenuHandler or LibrarianMenu
     */
    public LibrarianService getLibrarianService() {
        return librarianService;
    }

    /**
     * Just connects the Book services with the Library books repository
     *
     * @return the services that student can get for library books
     */
    public BookService getBookService() {
        return bookService;
    }

    /**
     * Just connects the Loan services with the Library books, students and librarians
     *
     * @return the services that student can get for Borrowing book process
     */
    public LoanService getLoanService() {
        return loanService;
    }

    /**
     * Starts the loop of Library System
     */
    public void start() {
        menuHandler.display();
    }
}
