package ap.projects.finalProject.service;

import ap.projects.finalProject.model.Librarian;
import ap.projects.finalProject.repository.LibrarianRepository;

import java.util.Scanner;

public class LibrarianService {

    private final LibrarianRepository repository;
    private Scanner scanner;

    public LibrarianService(LibrarianRepository repository) {
        this.repository = repository;
        this.scanner = new Scanner(System.in);
    }

    /**
     * A method that the manager can use to add a librarian to the library.
     */
    public void addLibrarian() {

        System.out.println("\n--- Add New Librarian ---");

        System.out.print("Please Enter The Librarian's Employee ID: ");
        String employeeID = scanner.nextLine();

        System.out.print("Please Enter The Librarian's Password: ");
        String password = scanner.nextLine();

        Librarian librarian = new Librarian(employeeID, password);
        repository.add(employeeID, librarian);

        System.out.println("Successful!");

    }

    /**
     * Compares the input with librarians info.
     *
     * @param username the input employee ID of user
     * @param password the input password of user
     * @return the librarian who registered successfully
     */
    public Librarian authenticateLibrarian(String username, String password) {
        Librarian librarian = repository.findByUsername(username);
        if (librarian != null && librarian.getPassword().equals(password)) {
            return librarian;
        }
        return null;
    }

    /**
     * A function for when the librarian wants to change their password.
     *
     * @param librarian the librarian who wants to change password
     */
    public void changePassword(Librarian librarian) {
        System.out.println("Enter Your New Password: ");
        librarian.setPassword(scanner.nextLine());
        System.out.println("Successful!");
    }

    /**
     * View a librarian's stats:
     * Total number of books registered
     * Total number of books lent
     * Total number of books reclaimed
     */
    public void printLibrarianStats() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter The Librarian's Employee ID: ");
        String tempEmployeeID = scanner.nextLine();
        Librarian librarian = this.repository.findByUsername(tempEmployeeID);

        if (librarian == null){
            System.out.println("Librarian Not Found!");
            return;
        }

        System.out.println("\n--- Librarian Stats ---\n");

        System.out.println("All Books Registered: " + librarian.getBooksRegisteredCount());
        System.out.println("All Books Lent: " + librarian.getLentBooksCount());
        System.out.println("All Books Reclaimed: " + librarian.getReclaimedBooksCont());

    }

    /**
     * To exchange the list of librarians.
     *
     * @return the librarian repository services
     */
    public LibrarianRepository getRepository() {
        return repository;
    }

}
