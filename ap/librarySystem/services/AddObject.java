package ap.librarySystem.services;

import ap.librarySystem.constants.BookStatus;
import ap.librarySystem.constants.ValidateRoles;
import ap.librarySystem.helpers.InputHandler;
import ap.librarySystem.models.Book;
import ap.librarySystem.models.Librarian;

import java.util.LinkedHashMap;

public class AddObject {

    ValidateRoles condition = new ValidateRoles(); // for validate conditions
    InputHandler userInput = new InputHandler(); // To get data from input

    public void addBook(LinkedHashMap<String, Book> books){

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
                condition.ISBN_VALIDATE_CONDITION,
                "You are only allowed to use numbers(10 digits)."
        );

        // add book
        if (!books.containsKey(ISBN)) {
            books.put(ISBN, new Book(title, author, pages, year, ISBN, BookStatus.NOT_BORROWED));
            System.out.println("Successful");
        }else {
            System.out.println("Failed! ISBN exists.");
        }

    }

    public void addLibrarian(LinkedHashMap<String, Librarian> librarians) {

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
        if (!librarians.containsKey(employeeID)) {
            librarians.put(employeeID, new Librarian(
                    employeeID,
                    firstName,
                    lastName,
                    "Lend History",
                    "Receive History")
            );
            System.out.println("Successful!");
        }else {
            System.out.println("Failed! employeeID exists.");
        }

    }

}
