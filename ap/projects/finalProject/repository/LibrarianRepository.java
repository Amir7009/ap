package ap.projects.finalProject.repository;

import ap.projects.finalProject.model.Librarian;

import java.util.LinkedHashMap;

public class LibrarianRepository {

    private LinkedHashMap<String, Librarian> librarians = new LinkedHashMap<>();

    /**
     * A method for add a new librarian to library.
     *
     * @param librarian the new librarian
     */
    public void add(String employeeID, Librarian librarian) {
        librarians.put(employeeID, librarian);
    }

    /**
     * To search a librarian by its employee ID.
     *
     * @param username the employee ID that entered by user
     * @return if librarian exists returns the librarian
     */
    public Librarian findByUsername(String username) {
        return librarians.getOrDefault(username, null);
    }

    public LinkedHashMap<String, Librarian> findAll() {
        return librarians;
    }

    public void setLibrarians(LinkedHashMap<String, Librarian> librarians) {
        this.librarians = librarians;
    }

}
