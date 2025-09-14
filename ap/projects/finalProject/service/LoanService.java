package ap.projects.finalProject.service;

import ap.projects.finalProject.model.enums.BookStatus;
import ap.projects.finalProject.model.Book;
import ap.projects.finalProject.model.Request;
import ap.projects.finalProject.model.Student;
import ap.projects.finalProject.repository.LoanRepository;
import ap.projects.finalProject.util.UserInput;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

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
     * The ISBN of the borrowed book and the username of the student.
     *
     * @param books   all library books
     * @param student borrower student
     * @see Request
     */
    public void createLoanRequest(LinkedHashMap<String, Book> books, Student student) {

        if (!student.isActive()) {
            System.out.println("Your access has been revoked by the librarian, please visit the library in person.");
            return;
        }

        System.out.println("Enter the ISBN of book: ");
        String tempISBN = scanner.nextLine();

        if (books.containsKey(tempISBN)) {
            if (books.get(tempISBN).getBookStatus() == BookStatus.NOT_BORROWED) {
                books.get(tempISBN).setBookStatus(BookStatus.IS_RESERVED);
                repository.createLoanRequest(
                        new Request(
                                student.getUsername(),
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
                System.out.println("After the librarian approves the loan request, go to the library to receive the book.");
                return;
            } else
                System.out.println("The book is already borrowed!");
            return;
        }
        System.out.println("ISBN not found!");

    }

    public void createReturnRequest(LinkedHashMap<String, Book> books, Student student) {

        System.out.println("Enter the ISBN of book: ");
        String tempISBN = scanner.nextLine();

        if (books.containsKey(tempISBN)) {
            if (books.get(tempISBN).getBookStatus() == BookStatus.IS_BORROWED) {

                repository.createReturnRequest(
                        new Request(
                                student.getUsername(),
                                tempISBN,
                                LocalDate.now()
                        )
                );
                System.out.println("Successful!");
                System.out.println("Your request for return book have been registered.");
                System.out.println("After the librarian approves the return request, go to the library to return the book.");
                return;
            } else
                System.out.println("The book is not borrowed!");
            return;
        }
        System.out.println("ISBN not found!");

    }

    /**
     * View library loan stats:
     * Total number of books borrowed
     * Total number of borrow requests
     * Average of loan during time
     */
    public void printLibraryLoanStats() {

        Double average = repository.getAllPastLoansDuringTime().stream().collect(Collectors.averagingInt(Integer::intValue));

        System.out.println("\n--- Library Stats ---\n");

        System.out.println("All Books Borrowed: " + (repository.getPastLoansCount() + repository.getCurrentLoansCount()));
        System.out.println("All Borrow Requests: " + repository.getAllBorrowRequestsCount());
        System.out.println("Average Of Loan During Time: " + average);

    }

    /**
     * To exchange the list of loans in library.
     *
     * @return the loan repository services
     */
    public LoanRepository getRepository() {
        return repository;
    }

}
