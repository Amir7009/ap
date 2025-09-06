package ap.projects.finalProject.ui;

import ap.projects.finalProject.LibrarySystem;
import ap.projects.finalProject.model.Librarian;
import ap.projects.finalProject.util.UserInput;

public class LibrarianMenu {

    private Librarian currentUser;
    private LibrarySystem librarySystem;
    private UserInput userInput;

    public LibrarianMenu(LibrarySystem librarySystem, Librarian currentUser) {
        this.librarySystem = librarySystem;
        this.currentUser = currentUser;
        this.userInput = new UserInput();
    }

    /**
     * shows all available options for a librarian in library
     */
    public void display() {
        while (currentUser != null) {
            System.out.println("\n=== Librarian Dashboard ===");
            System.out.println("1. Change My Password");
            System.out.println("2. Register a New Book");
            System.out.println("3. Search a Book");
            System.out.println("4. Edit a Book Info");
            System.out.println("5. Reviewing Student Loan Requests");
            System.out.println("6. View Student Loan History");
            System.out.println("7. Activate or Deactivate a Student");
            System.out.println("8. Reviewing Book Return Requests");
            System.out.println("9. Logout");
            System.out.print("Please enter your choice: ");

            int choice = userInput.getIntInput(1, 9);

            switch (choice) {
                case 1 -> librarySystem.getLibrarianService().changePassword(currentUser);

                case 2 -> librarySystem.getBookService().addBook(currentUser);

                case 3 -> System.out.println("Feature not implemented yet: Search a Book");

                case 4 -> System.out.println("Feature not implemented yet: Edit a Book Info");

                case 5 -> System.out.println("Feature not implemented yet: Reviewing Student Loan Requests");

                case 6 -> System.out.println("Feature not implemented yet: View Student Loan History");

                case 7 -> System.out.println("Feature not implemented yet: Activate or Deactivate a Student");

                case 8 -> System.out.println("Feature not implemented yet: Reviewing Book Return Requests");

                case 9 -> {
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                }

                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }

}
