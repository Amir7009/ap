package ap.midterm_project.services;

import ap.midterm_project.helpers.InputHandler;

public class MenuHelper {

    InputHandler input = new InputHandler();

    public byte userSelectionMenu() {

        System.out.println("""
                
                1-I am a student
                2-Librarian login
                3-Library manager login
                4-Exit
                """);

        return input.switcher();

    }

    public byte studentLoginMenu() {

        System.out.println("""
                
                1-Sign in
                2-Sign up
                3-Go back
                """);

        return input.switcher();

    }

    public byte studentAccessMenu() {

        System.out.println("""
                
                1-Show Library books
                2-Search a book
                3-Request to borrow a book // off
                4-Request to return a book // off
                5-Unreturned books // off
                6-View my book loan history // off
                7-Go back
                """);

        return input.switcher();

    }

    public byte librariansAccessMenu() {

        System.out.println("""
                
                1-Edit info
                2-Add a new book
                3-Borrow requests // off
                4-Return requests // off
                5-Unreturned books // off
                6-View my all book loan history // off
                7-View student book loan history // off
                8-Go back
                """);

        return input.switcher();

    }

    public byte managerAccessMenu() {

        System.out.println("""
                
                1-Add a librarian
                2-See all late books // off
                3-View a librarian performance // off
                4-View top ten borrowed books in last year // off
                5-Go back
                """);

        return input.switcher();

    }

}