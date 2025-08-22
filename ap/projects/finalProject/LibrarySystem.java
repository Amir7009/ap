package ap.projects.finalProject;

import ap.projects.finalProject.repository.StudentRepository;
import ap.projects.finalProject.service.StudentService;
import ap.projects.finalProject.ui.MenuHandler;

public class LibrarySystem {

    private final StudentService studentService;
    private final MenuHandler menuHandler;

    public LibrarySystem() {

        StudentRepository repository = new StudentRepository();
        this.studentService = new StudentService(repository);

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
     * starts the loop of Library System
     */
    public void start() {
        menuHandler.displayMainMenu();
    }
}
