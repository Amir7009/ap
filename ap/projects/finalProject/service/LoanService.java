package ap.projects.finalProject.service;

import ap.librarySystem.constants.BookStatus;
import ap.projects.finalProject.model.Book;
import ap.projects.finalProject.model.Request;
import ap.projects.finalProject.repository.LoanRepository;
import ap.projects.finalProject.util.UserInput;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class LoanService {

    private final LoanRepository repository;
    private Scanner scanner;
    private UserInput userInput;

    public LoanService(LoanRepository repository) {
        this.repository = repository;
        scanner = new Scanner(System.in);
        userInput = new UserInput();
    }

    /**
     * This method registers a loan request for a student in such a way that
     * the following information is recorded in this request:
     * the ISBN of the borrowed book and the username of the student.
     *
     * @param books           all library books
     * @param studentUsername borrower student
     * @see Request
     */
    public void createLoanRequest(LinkedHashMap<String, Book> books, String studentUsername) {

        System.out.println("Enter the ISBN of book: ");
        String tempISBN = scanner.nextLine();

        if (books.containsKey(tempISBN)) {
            if (books.get(tempISBN).getBookStatus() == BookStatus.NOT_BORROWED) {
                books.get(tempISBN).setBookStatus(BookStatus.IS_RESERVED);
                repository.createLoanRequest(
                        new Request(
                                studentUsername,
                                tempISBN,
                                LocalDate.now()
                        )
                );
                System.out.println("Successful!");
                System.out.println("Your request for borrow book from " +
                        LocalDate.now().plusDays(1) +
                        " to " + LocalDate.now().plusDays(1).plusMonths(1) +
                        " have been registered."
                );
                System.out.println("After the librarian approves the loan request, go to the library to receive the book..");
                return;
            } else
                System.out.println("The book is already borrowed!");
            return;
        }
        System.out.println("ISBN not found!");

    }

}
