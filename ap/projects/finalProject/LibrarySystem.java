package ap.projects.finalProject;

import ap.projects.finalProject.repository.*;
import ap.projects.finalProject.service.*;
import ap.projects.finalProject.ui.MenuHandler;

public class LibrarySystem {

    private final StudentService studentService;
    private final BookService bookService;
    private final MenuHandler menuHandler;

    public LibrarySystem() {

        StudentRepository studentRepository = new StudentRepository();
        this.studentService = new StudentService(studentRepository);

        BookRepository bookRepository = new BookRepository();
        this.bookService = new BookService(bookRepository);

        this.menuHandler = new MenuHandler(this);
    }

    public int getStudentCount() {
        return studentService.getStudentCount();
    }

    /**
     * just connects the student services with the Library students repository
     * @return the services that student can get from library
     * @see MenuHandler or StudentMenu
     */
    public StudentService getStudentService() {
        return studentService;
    }

    /**
     * just connects the Book services with the Library books repository
     * @return the services that student can get for library books
     */
    public BookService getBookService() {
        return bookService;
    }

    /**
     * starts the loop of Library System
     */
    public void start() {
        menuHandler.displayMainMenu();
    }
}
