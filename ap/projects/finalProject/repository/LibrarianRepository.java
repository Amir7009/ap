package ap.projects.finalProject.repository;

import ap.projects.finalProject.model.Librarian;

import java.util.LinkedHashMap;

public class LibrarianRepository {

    private LinkedHashMap<String, Librarian> librarians = new LinkedHashMap<>();

    /**
     * To search a librarian by its employee ID
     *
     * @param username the employee ID that entered by user
     * @return if librarian exists returns the librarian
     */
    public Librarian findByUsername(String username) {
        return librarians.getOrDefault(username, null);
    }

}
