package ap.projects.finalProject.ui;

import ap.projects.finalProject.LibrarySystem;
import ap.projects.finalProject.util.UserInput;

public abstract class Menu {

    protected LibrarySystem librarySystem;
    protected UserInput userInput;

    public Menu(LibrarySystem librarySystem) {

        this.librarySystem = librarySystem;
        this.userInput = new UserInput();

    }

    public abstract void display();

}
