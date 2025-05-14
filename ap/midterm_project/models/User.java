package ap.midterm_project.models;

public abstract class User implements UsernameInterface {

    private String username;

    public User(String username){

        this.username = username;

    }

    public String getUsername(){
        return this.username;
    }

}
