package ap.projects.midtermProject.helpers;


public class MenuHelper {

    InputHandler input = new InputHandler();

    public byte userSelectionMenu() {

        System.out.println("""
                
                1-I am a student
                2-Librarian login
                3-Library manager login
                0-Exit
                """);

        return input.switcher();

    }

    public byte studentLoginMenu() {

        System.out.println("""
                
                1-Sign in
                2-Sign up
                0-Go back
                """);

        return input.switcher();

    }

    public byte studentAccessMenu() {

        System.out.println("""
                
                1-Show Library books
                2-Search a book
                3-Request to borrow a book
                4-Request to return a book
                5-Unreturned books
                6-View my book loan history
                7-Show notifications
                0-Go back
                """);

        return input.switcher();

    }

    public byte librariansAccessMenu() {

        System.out.println("""
                
                1-Edit info
                2-Add a new book
                3-Borrow requests
                4-Return requests
                5-Unreturned books
                6-View my all book lend history
                7-View my all book reclaim history
                8-View student book loan history
                0-Go back
                """);

        return input.switcher();

    }

    public byte managerAccessMenu() {

        System.out.println("""
                
                1-Add a librarian
                2-See all late books
                3-View a librarian performance
                4-View top ten borrowed books in last year
                0-Go back
                """);

        return input.switcher();

    }

    public byte saveTypeMenu() {

        System.out.println("""
                
                1-json
                2-tab_split
                3-sqlite
                """);

        return input.switcher();

    }

}