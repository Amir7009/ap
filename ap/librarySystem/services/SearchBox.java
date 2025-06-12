package ap.librarySystem.services;

import ap.librarySystem.constants.ValidateRoles;
import ap.librarySystem.helpers.InputHandler;
import ap.librarySystem.helpers.Printer;
import ap.librarySystem.models.Book;
import ap.librarySystem.models.Librarian;
import ap.librarySystem.models.Student;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SearchBox {

    ValidateRoles condition = new ValidateRoles(); // for validate conditions
    InputHandler input = new InputHandler(); // To get data from input
    Printer print = new Printer(); // to print object data

    // Search by most matches
    public void searchBooks( LinkedHashMap<String, Book> books) {

        System.out.println("Please enter book name: ");
        String query = input.userInput(
                condition.TEXT_VALIDATE_CONDITION,
                "You are only allowed to use letters & numbers.");

        ArrayList<String> list = new ArrayList<>();
        for (String book : books.keySet()) {
            if (calculateMatchScore(query, book) > 0) {
                list.add(book);
            }
        }
        list.sort((b1, b2) -> Integer.compare(
                calculateMatchScore(query, b2),
                calculateMatchScore(query, b1)
        ));

        print.printObjectInfo(list);

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

    public String searchStudent(LinkedHashMap<String, Student> students){

        System.out.println("Please enter student's ID: ");
        String studentID = input.userInput(
                condition.ID_VALIDATE_CONDITION,
                "You are only allowed to use numbers."
        );

        if (students.containsKey(studentID))
            return studentID;
        System.out.println("Student Not found");
        return null;

    }

    public String searchLibrarian(LinkedHashMap<String, Librarian> librarians){

        System.out.println("Please enter librarian's ID: ");
        String librarianID = input.userInput(
                condition.ID_VALIDATE_CONDITION,
                "You are only allowed to use numbers."
        );

        if (librarians.containsKey(librarianID))
            return librarianID;

        return null;

    }

}
