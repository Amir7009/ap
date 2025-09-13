package ap.projects.finalProject.ui;

import ap.projects.finalProject.*;
import ap.projects.finalProject.model.Student;

public class StudentMenu extends Menu {

    private Student currentUser;

    public StudentMenu(LibrarySystem librarySystem, Student currentUser) {
        super(librarySystem);
        this.currentUser = currentUser;
    }

    /**
     * Shows all available options for a student in library
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
            System.out.println("7. View My Notifications");
            System.out.println("8. Logout");
            System.out.print("Please enter your choice: ");

            int choice = userInput.getIntInput(1, 8);

            switch (choice) {
                case 1 -> {
                    System.out.println("\n--- My Information ---");
                    System.out.println(currentUser);
                }

                case 2 -> System.out.println("Feature not implemented yet: Edit Information.");

                case 3 -> librarySystem.getBookService().searchBook();

                case 4 -> librarySystem.getLoanService().createLoanRequest(
                        librarySystem.getBookService().getRepository().findAll(),
                        currentUser
                );

                case 5 -> librarySystem.getLoanService().createReturnRequest(
                        librarySystem.getBookService().getRepository().findAll(),
                        currentUser
                );

                case 6 -> System.out.println("Feature not implemented yet: Display Available Books.");

                case 7 -> librarySystem.getStudentService().printNotifications(currentUser);

                case 8 -> {
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                }

                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }

}
