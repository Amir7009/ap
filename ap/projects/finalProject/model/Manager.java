package ap.projects.finalProject.model;

public class Manager extends AppUser {

    private String firstName, lastName, educationLevel;

    public Manager(String username, String password, String firstName, String lastName, String educationLevel){

        super (username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationLevel = educationLevel;

    }

}
