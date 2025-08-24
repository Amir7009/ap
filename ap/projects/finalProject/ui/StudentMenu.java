package ap.projects.finalProject.ui;

import ap.projects.finalProject.*;
import ap.projects.finalProject.model.Student;
import ap.projects.finalProject.util.UserInput;

public class StudentMenu {
    private Student currentUser;
    private LibrarySystem librarySystem;
    private UserInput userInput;

    public StudentMenu(LibrarySystem librarySystem, Student currentUser) {
        this.librarySystem = librarySystem;
        this.currentUser = currentUser;
        this.userInput = new UserInput();
    }

    /**
     * shows all available options for a student in library
     */
    public void display() {
        while (currentUser != null) {
            System.out.println("\n=== Student Dashboard ===");
            System.out.println("1. View My Information");
            System.out.println("2. Edit My Information");
            System.out.println("3. Search a Book");
            System.out.println("4. Borrow a Book");
            System.out.println("5. Return a Book");
            System.out.println("6. View Available Books");
            System.out.println("7. Logout");
            System.out.print("Please enter your choice: ");

            int choice = userInput.getIntInput(1, 7);

            switch (choice) {
                case 1 -> {
                    System.out.println("\n--- My Information ---");
                    System.out.println(currentUser);
                }

                case 2 -> System.out.println("Feature not implemented yet: Edit Information.");

                case 3 -> librarySystem.getBookService().searchBook();

                case 4 -> librarySystem.getLoanService().createLoanRequest(
                        librarySystem.getBookService().getRepository().findAll(),
                        currentUser.getUsername()
                );

                case 5 -> System.out.println("Feature not implemented yet: Return Book.");

                case 6 -> System.out.println("Feature not implemented yet: Display Available Books.");

                case 7 -> {
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                }

                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }

}
