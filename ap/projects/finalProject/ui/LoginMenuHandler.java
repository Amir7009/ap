package ap.projects.finalProject.ui;

import ap.projects.finalProject.*;
import ap.projects.finalProject.service.AuthService;

public class LoginMenuHandler extends Menu{

    private AuthService authentication;

    public LoginMenuHandler(LibrarySystem librarySystem) {
        super(librarySystem);
        authentication = new AuthService(librarySystem);
    }

    /**
     * This method manages all the options available on the user login page.
     */
    public void display() {
        while (true) {
            System.out.println("\n=== University Library Management System ===");
            System.out.println("1. Student Registration");
            System.out.println("2. Student Login");
            System.out.println("3. Enter as a Guest");
            System.out.println("4. Librarian Login");
            System.out.println("5. Manager Login");
            System.out.println("6. Exit");
            System.out.print("Please enter your choice: ");

            int choice = userInput.getIntInput(1, 6);

            switch (choice) {
                case 1:
                    authentication.handleStudentRegistration();
                    break;
                case 2:
                    authentication.handleStudentLogin();
                    break;
                case 3:
                    GuestMenu guestMenu = new GuestMenu(librarySystem);
                    guestMenu.display();
                    break;
                case 4:
                    authentication.handleLibrarianLogin();
                    break;
                case 5:
                    authentication.handleManagerLogin();
                    break;
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println("___________________________");
        }
    }

}
