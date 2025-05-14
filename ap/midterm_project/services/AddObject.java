package ap.midterm_project.services;

import ap.midterm_project.constants.ValidateRoles;
import ap.midterm_project.helper.InputHandler;
import ap.midterm_project.models.Book;
import ap.midterm_project.models.Librarian;

import java.util.ArrayList;

public class AddObject {

    ValidateRoles condition = new ValidateRoles(); // for validate conditions
    InputHandler userInput = new InputHandler(); // To get data from input

    public void addBook(ArrayList<Book> books){

        String title, author, pages, year, ISBN;

        // get book info
        System.out.println("Please enter the title: ");
        title = userInput.userInput(
                condition.BOOK_NAME_VALIDATE_CONDITION,
                "You are only allowed to use letters & numbers."
        );

        System.out.println("Please enter the author's name: ");
        author = userInput.userInput(
                condition.NAME_VALIDATE_CONDITION,
                "You are only allowed to use letters."
        );

        System.out.println("Please enter the number of pages: ");
        pages = userInput.userInput(
                condition.USERNAME_VALIDATE_CONDITION,
                "You are only allowed to use numbers."
        );

        System.out.println("Please enter the year of publish: ");
        year = userInput.userInput(
                condition.USERNAME_VALIDATE_CONDITION,
                "You are only allowed to use numbers."
        );

        System.out.println("Please enter the ISBN: ");
        ISBN = userInput.userInput(
                condition.USERNAME_VALIDATE_CONDITION,
                "You are only allowed to use numbers."
        );

        // add book
        books.add(new Book(title, author, pages, year, ISBN));

    }

    public void addLibrarian(ArrayList<Librarian> librarians) {

        String employeeID, firstName, lastName;

        // get librarian info
        System.out.println("Please enter librarian's first name: ");
        firstName = userInput.userInput(
                condition.NAME_VALIDATE_CONDITION,
                "You are only allowed to use letters."
        );

        System.out.println("Please enter librarian's last name: ");
        lastName = userInput.userInput(
                condition.NAME_VALIDATE_CONDITION,
                "You are only allowed to use letters."
        );

        System.out.println("Please enter librarian's employee ID: ");
        employeeID = userInput.userInput(
                condition.USERNAME_VALIDATE_CONDITION,
                "You are only allowed to use numbers."
        );

        // add librarian
        librarians.add(new Librarian(employeeID, firstName, lastName));

    }

}
