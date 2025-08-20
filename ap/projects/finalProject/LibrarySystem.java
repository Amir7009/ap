package ap.projects.finalProject;

import ap.projects.finalProject.repository.StudentRepository;
import ap.projects.finalProject.service.StudentService;
import ap.projects.finalProject.model.Student;
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

    public boolean registerStudent(String name, String studentId, String username, String password) {
        return studentService.registerStudent(name, studentId, username, password);
    }

    public Student authenticateStudent(String username, String password) {
        return studentService.authenticateStudent(username, password);
    }

    public void start() {
        menuHandler.displayMainMenu();
    }
}
