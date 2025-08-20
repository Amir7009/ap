package ap.projects.finalProject.ui;

import ap.projects.finalProject.*;
import ap.projects.finalProject.model.Student;
import ap.projects.finalProject.util.UserInput;

import java.util.Scanner;

public class MenuHandler {

    private LibrarySystem librarySystem;
    private UserInput userInput;
    private Scanner scanner;

    public MenuHandler(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        this.userInput = new UserInput();
        this.scanner = new Scanner(System.in);
    }

    // this method will be developed when admin & manager have been added
    public void displayMainMenu() {
        while (true) {
            System.out.println("\n=== University Library Management System ===");
            System.out.println("1. Student Registration");
            System.out.println("2. Student Login");
            System.out.println("3. View Registered Student Count");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");

            int choice = userInput.getIntInput(1, 4);

            switch (choice) {
                case 1:
                    handleStudentRegistration();
                    break;
                case 2:
                    handleStudentLogin();
                    break;
                case 3:
                    displayStudentCount();
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println("___________________________");
        }
    }

    private void displayStudentCount() {
        int studentCount = librarySystem.getStudentCount();
        System.out.println("\nTotal registered students: " + studentCount);
    }

    private void handleStudentRegistration() {
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

    private void handleStudentLogin() {
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
