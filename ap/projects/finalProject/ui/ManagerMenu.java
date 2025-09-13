package ap.projects.finalProject.ui;

import ap.projects.finalProject.LibrarySystem;
import ap.projects.finalProject.model.Manager;

public class ManagerMenu extends Menu{

    private Manager currentUser;

    public ManagerMenu(LibrarySystem librarySystem, Manager currentUser) {
        super(librarySystem);
        this.currentUser = currentUser;
    }

    /**
     * Shows all available options for a Manager in library.
     */
    public void display() {
        while (currentUser != null) {
            System.out.println("\n=== Manager Dashboard ===");
            System.out.println("1. Add a Librarian");
            System.out.println("2. View Librarian Stats");
            System.out.println("3. View Book Stats");
            System.out.println("4. View Student Loan History and Stats");
            System.out.println("5. The Ten Students With The Most Delays In Returning Their Loans");
            System.out.println("6. Logout");
            System.out.print("Please enter your choice: ");

            int choice = userInput.getIntInput(1, 6);

            switch (choice) {
                case 1 -> librarySystem.getLibrarianService().addLibrarian();

                case 2 -> librarySystem.getLibrarianService().printLibrarianStats();

                case 3 -> librarySystem.getLoanService().printLibraryLoanStats();

                case 4 -> librarySystem.getStudentService().printStudentLoanStats();

                case 5 -> librarySystem.getStudentService().printTopTenMostDelayed();

                case 6 -> {
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                }

                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }

}
