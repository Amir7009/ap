package ap.projects.finalProject.ui;

import ap.projects.finalProject.LibrarySystem;
import ap.projects.finalProject.util.UserInput;

public class GuestMenu {

    /**
     * shows all available options for a guest user in library
     *
     * @param librarySystem to access library data
     */
    public static void display(LibrarySystem librarySystem) {

        boolean condition = true;
        UserInput userInput = new UserInput();

        while (condition) {
            System.out.println("\n=== Guest Dashboard ===");
            System.out.println("1. View Registered Student Count");
            System.out.println("2. Search a Book by title");
            System.out.println("3. View All Books Count");
            System.out.println("4. View Library Loan Status");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice: ");

            int choice = userInput.getIntInput(1, 5);

            switch (choice) {
                case 1 -> {
                    int studentCount = librarySystem.getStudentService().getRepository().count();
                    System.out.println("\nTotal registered students: " + studentCount);
                }

                case 2 -> System.out.println("Feature not implemented yet: Search a Book by title.");

                case 3 -> System.out.println("Feature not implemented yet: View All Books Count.");

                case 4 -> System.out.println("Feature not implemented yet: View Library Loan Status.");

                case 5 -> condition = false;

                default -> System.out.println("Invalid option! Please try again.");
            }
        }

    }

}
