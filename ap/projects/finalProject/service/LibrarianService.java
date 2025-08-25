package ap.projects.finalProject.service;

import ap.projects.finalProject.model.Librarian;
import ap.projects.finalProject.repository.LibrarianRepository;

public class LibrarianService {

    private final LibrarianRepository repository;

    public LibrarianService(LibrarianRepository repository) {
        this.repository = repository;
    }

    /**
     * compares the input with librarians info
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
     * To exchange the list of librarians
     *
     * @return the librarian repository services
     */
    public LibrarianRepository getRepository() {
        return repository;
    }

}
