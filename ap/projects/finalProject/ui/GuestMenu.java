package ap.projects.finalProject.ui;

import ap.projects.finalProject.LibrarySystem;
import ap.projects.finalProject.model.Book;
import ap.projects.finalProject.util.UserInput;

import java.util.Scanner;

public class GuestMenu {

    /**
     * shows all available options for a guest user in library
     *
     * @param librarySystem to access library data
     */
    public static void display(LibrarySystem librarySystem) {

        boolean condition = true;
        UserInput userInput = new UserInput();
        Scanner scanner = new Scanner(System.in);

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
                    System.out.println("\nTotal Registered Students: " + studentCount);
                }

                case 2 -> {
                    System.out.println("Enter The Title:");
                    Book book = librarySystem.getBookService().getRepository().findByTitle(scanner.nextLine());
                    if (book != null)
                        System.out.println(book.getBookDetailForGuestUser());
                    else
                        System.out.println("Not Found!");
                }

                case 3 -> {
                    int bookCount = librarySystem.getBookService().getRepository().count();
                    System.out.println("\nTotal Registered Books: " + bookCount);
                }

                case 4 -> {
                    int loanCount = librarySystem.getLoanService().getRepository().currentLoansCount();
                    System.out.println("\nTotal Current Loans: " + loanCount);
                    loanCount += librarySystem.getLoanService().getRepository().pastLoansCount();
                    System.out.println("\nTotal Loans In The Library History: " + loanCount);
                }

                case 5 -> condition = false;

                default -> System.out.println("Invalid option! Please try again.");
            }
        }

    }

}
