package ap.midterm_project.models;

public class LibraryManager extends User {

    private String firstName, lastName, educationLevel;

    public LibraryManager(String username, String firstName, String lastName, String educationLevel){

        super (username);
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationLevel = educationLevel;

    }

}
