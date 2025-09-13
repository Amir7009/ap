package ap.projects.finalProject.service;

import ap.projects.finalProject.LibrarySystem;
import ap.projects.finalProject.model.Librarian;
import ap.projects.finalProject.model.Manager;
import ap.projects.finalProject.model.Student;
import ap.projects.finalProject.ui.LibrarianMenu;
import ap.projects.finalProject.ui.ManagerMenu;
import ap.projects.finalProject.ui.StudentMenu;

import java.util.Scanner;

public class AuthService {

    private Scanner scanner;
    private LibrarySystem librarySystem;
    private StudentService studentService;
    private LibrarianService librarianService;

    public AuthService(LibrarySystem librarySystem) {

        scanner = new Scanner(System.in);
        this.librarySystem = librarySystem;

        studentService = librarySystem.getStudentService();
        librarianService = librarySystem.getLibrarianService();

    }

    /**
     * Gets the student info from user and instantiates a new registered student in the library.
     *
     * @see StudentService
     */
    public void handleStudentRegistration() {

        System.out.println("\n--- New Student Registration ---");

        System.out.print("Student name: ");
        String name = scanner.nextLine();

        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        studentService.registerStudent(name, studentId, username, password);

    }

    /**
     * Gets the student info from user and searches the input username among the all students;
     * If the username exists, checks the password.
     */
    public void handleStudentLogin() {

        System.out.println("\n--- Student Login ---");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        Student currentUser = studentService.authenticateStudent(username, password);

        if (currentUser != null) {
            System.out.println("Login successful! Welcome, " + currentUser.getName());
            StudentMenu studentMenu = new StudentMenu(librarySystem, currentUser);
            studentMenu.display();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }

    }

    /**
     * Gets the librarian info from user and searches the input username among the all librarians;
     * If the username exists, checks the password.
     */
    public void handleLibrarianLogin() {

        System.out.println("\n--- Librarian Login ---");

        System.out.print("Employee ID: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        Librarian currentUser = librarianService.authenticateLibrarian(username, password);

        if (currentUser != null) {
            System.out.println("Login successful! Welcome, " + currentUser.getEmployeeID());
            LibrarianMenu librarianMenu = new LibrarianMenu(librarySystem, currentUser);
            librarianMenu.display();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }

    }

    /**
     * Gets the library manager info from user and searches the input username and password
     * with library manager info.
     */
    public void handleManagerLogin(Manager libraryManager) {

        System.out.println("\n--- Manager Login ---");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        if(libraryManager.getUsername().equals(username) && libraryManager.getPassword().equals(password)) {
            System.out.println("Login successful! Welcome, " + librarySystem.getLibraryManager().getUsername());
            ManagerMenu managerMenu = new ManagerMenu(librarySystem, libraryManager);
            managerMenu.display();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }

    }

}
