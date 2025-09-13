package ap.projects.finalProject.service;

import ap.projects.finalProject.model.Book;
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
     * Compares the input with librarians info
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
     * A function for when the librarian wants to change their password
     *
     * @param librarian the librarian who wants to change password
     */
    public void changePassword(Librarian librarian) {
        System.out.println("Enter Your New Password: ");
        librarian.setPassword(scanner.nextLine());
        System.out.println("Successful!");
    }

    /**
     * To exchange the list of librarians
     *
     * @return the librarian repository services
     */
    public LibrarianRepository getRepository() {
        return repository;
    }

}
