package ap.projects.finalProject.service;

import ap.projects.finalProject.LibrarySystem;
import ap.projects.finalProject.model.Student;
import ap.projects.finalProject.ui.StudentMenu;

import java.util.Scanner;

public class AuthService {

    private Scanner scanner;
    private LibrarySystem librarySystem;

    public AuthService(LibrarySystem librarySystem){

        scanner = new Scanner(System.in);
        this.librarySystem = librarySystem;

    }

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

        librarySystem.registerStudent(name, studentId, username, password);

    }

    public void handleStudentLogin() {

        System.out.println("\n--- Student Login ---");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        Student currentUser = librarySystem.authenticateStudent(username, password);

        if (currentUser != null) {
            System.out.println("Login successful! Welcome, " + currentUser.getName());
            StudentMenu studentMenu = new StudentMenu(librarySystem, currentUser);
            studentMenu.display();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }

    }

}
