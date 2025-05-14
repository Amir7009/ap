package ap.midterm_project.services;

import ap.midterm_project.constants.ValidateRoles;
import ap.midterm_project.helpers.InputHandler;
import ap.midterm_project.helpers.Printer;
import ap.midterm_project.models.Book;

import java.util.ArrayList;

public class SearchBox {

    ValidateRoles condition = new ValidateRoles(); // for validate conditions
    InputHandler input = new InputHandler(); // To get data from input
    Printer print = new Printer(); // to print object data

    // Search by most matches
    public void searchBooks( ArrayList<Book> books) {

        System.out.println("Please enter book name: ");
        String query = input.userInput(
                condition.TEXT_VALIDATE_CONDITION,
                "You are only allowed to use letters & numbers.");

        ArrayList<Book> matchBooks = (ArrayList<Book>) books.stream()
                .filter(book -> calculateMatchScore(query, book.getTitle()) > 0)
                .sorted((b1, b2) -> Integer.compare(
                        calculateMatchScore(query, b2.getTitle()),
                        calculateMatchScore(query, b1.getTitle())
                ))
                .toList();

        print.printObjectInfo(matchBooks);

    }
    private int calculateMatchScore(String query, String target) {
        query = normalize(query);
        target = normalize(target);

        if (target.equals(query)) return 3;       // Perfect match
        if (target.contains(query)) return 2;     // Partial match
        if (query.contains(target)) return 1;     // Reverse matching
        return 0;                                 // No match
    }

    private String normalize(String input) {
        return input.toLowerCase().trim();
    }




}
