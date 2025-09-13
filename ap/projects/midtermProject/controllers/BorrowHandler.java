package ap.projects.midtermProject.controllers;

import ap.projects.midtermProject.constants.RequestType;
import ap.projects.midtermProject.models.borrowSystem.Borrow;
import ap.projects.midtermProject.models.borrowSystem.Request;
import ap.projects.midtermProject.constants.BookStatus;
import ap.projects.midtermProject.constants.ValidateRoles;
import ap.projects.midtermProject.database.Library;
import ap.projects.midtermProject.helpers.InputHandler;

import java.time.LocalDate;
import java.util.*;

public class BorrowHandler {

    private InputHandler input = new InputHandler();
    private ValidateRoles condition = new ValidateRoles();

    /**
     * This method registers a loan request for a student in such a way that
       the following information is recorded in this request:
       the ISBN of the borrowed book and the user ID of the staff member (random).
     * @see Request
     */
    public void makeLoanRequest(Library library, String studentID) {

        System.out.println("Enter the ISBN of book: ");
        String tempISBN = input.userInput(
                condition.ISBN_VALIDATE_CONDITION,
                "You are only allowed to use numbers(10 digits)."
        );
        ArrayList<String> librarians = new ArrayList<>(library.getLibrarians().keySet());
        Random random = new Random();

        if (library.getBooks().containsKey(tempISBN)) {
            if (library.getBooks().get(tempISBN).getBookStatus() == BookStatus.NOT_BORROWED) {
                library.getBooks().get(tempISBN).setBookStatus(BookStatus.IS_RESERVED);
                library.getLoanRequests().add(
                        new Request(
                                studentID,
                                tempISBN,
                                RequestType.BORROW,
                                librarians.get(random.nextInt(librarians.size()))
                        )
                );
                System.out.println("Successful!");
                return;
            } else
                System.out.println("The book is already borrowed!");
            return;
        }
        System.out.println("ISBN not found!");

    }

    /**
     * This method registers a return loan request for a student in such a way that
       the following information is recorded in this request:
       the ISBN of the borrowed book and the user ID of the staff member (random).
     * @see Request
     */
    public void makeReturnRequest(Library library, String studentID) {

        System.out.println("Enter the ISBN of book: ");
        String tempISBN = input.userInput(
                condition.ISBN_VALIDATE_CONDITION,
                "You are only allowed to use numbers(10 digits)."
        );
        ArrayList<String> librarians = new ArrayList<>(library.getLibrarians().keySet());
        Random random = new Random();

        if (library.getBooks().containsKey(tempISBN)) {
            if (library.getBooks().get(tempISBN).getBookStatus() == BookStatus.IS_BORROWED) {

                library.getLoanRequests().add(
                        new Request(
                                studentID,
                                tempISBN,
                                RequestType.RETURN,
                                librarians.get(random.nextInt(librarians.size()))
                        )
                );
                System.out.println("Successful!");
                return;
            } else
                System.out.println("The book is already borrowed!");
            return;
        }
        System.out.println("ISBN not found!");

    }

    /**
     * When a request is approved or denied, the loan information is completed, and
       a report is sent to the student. This activity is recorded in the records of
       both the student and the relevant staff member.
     * @see Borrow
     */
    public void acceptRequest(ArrayList<Request> loanRequests, Library library, String librarianID) {


        for (Request loanRequest : loanRequests) {

            String studentID = loanRequest.getBorrowerStudentID();
            if (loanRequest.getRequestType() == RequestType.BORROW && loanRequest.getLibrarianID().equals(librarianID)) {
                System.out.println(loanRequest.getRequestType() + " " + loanRequest.printRequestDetails(library.getStudents()));
                if (acceptBorrowRequest(loanRequest, library)) {
                    library.getStudents().get(studentID).setNotifications(
                            "your request " +
                                    loanRequest.getRequestType() + " " +
                                    loanRequest.getBorrowedBookISBN() +
                                    " accepted."
                    );
                    loanRequests.remove(loanRequest);
                    System.out.println("Successful");
                    return;
                } else {
                    library.getStudents().get(studentID).setNotifications(
                            "your request " +
                                    loanRequest.getRequestType() + " " +
                                    loanRequest.getBorrowedBookISBN() +
                                    " rejected."
                    );
                    library.getBooks().get(loanRequest.getBorrowedBookISBN()).setBookStatus(BookStatus.NOT_BORROWED);
                    loanRequests.remove(loanRequest);
                    System.out.println("Successful");
                    return;
                }
            }
            else if(loanRequest.getLibrarianID().equals(librarianID)) {
                System.out.println(loanRequest.getRequestType() + " " + loanRequest.printRequestDetails(library.getStudents()));
                if (acceptReturnRequest(loanRequest, library)) {
                    library.getStudents().get(studentID).setNotifications(
                            "your request " +
                                    loanRequest.getRequestType() + " " +
                                    loanRequest.getBorrowedBookISBN() +
                                    " accepted."
                    );
                    loanRequests.remove(loanRequest);
                    System.out.println("Successful");
                    return;
                } else {
                    library.getStudents().get(studentID).setNotifications(
                            "your request " +
                                    loanRequest.getRequestType() + " " +
                                    loanRequest.getBorrowedBookISBN() +
                                    " rejected."
                    );
                    library.getBooks().get(loanRequest.getBorrowedBookISBN()).setBookStatus(BookStatus.NOT_BORROWED);
                    loanRequests.remove(loanRequest);
                    System.out.println("Successful");
                    return;

                }
            }

        }
        System.out.println("No items found!");

    }

    private boolean acceptBorrowRequest(Request borrowRequest, Library library) {

        System.out.println("Yes or No?");
        if (input.yesOrNo()) {

            library.getBooks().get(borrowRequest.getBorrowedBookISBN()).setBookStatus(BookStatus.IS_BORROWED);
            library.getBorrows().add(new Borrow(
                    borrowRequest.getBorrowerStudentID(),
                    borrowRequest.getBorrowedBookISBN(),
                    borrowRequest.getLibrarianID(),
                    LocalDate.now(),
                    LocalDate.now().plusMonths(1)
            ));
            library.getLibrarians().get(borrowRequest.getLibrarianID()).setLendReport(
                    "Lend " + LocalDate.now() +
                    " Book > " + borrowRequest.getBorrowedBookISBN()
            );
            library.getStudents().get(borrowRequest.getBorrowerStudentID()).setHistory(
                    "Successful borrow in " + LocalDate.now() +
                    " Book > " + borrowRequest.getBorrowedBookISBN()
            );
            return true;

        }else

            return false;

    }

    private boolean acceptReturnRequest(Request returnRequest, Library library) {

        System.out.println("Yes or No?");
        if (input.yesOrNo()) {

            for (Borrow borrow : library.getBorrows()) {
                if(borrow.getBorrowedBookISBN().equals(returnRequest.getBorrowedBookISBN()) && borrow.getBorrowerStudentID().equals(returnRequest.getBorrowerStudentID())){

                    library.getBooks().get(borrow.getBorrowedBookISBN()).setBookStatus(BookStatus.NOT_BORROWED);
                    borrow.returnBook(
                            returnRequest.getLibrarianID(),
                            LocalDate.now()
                    );
                    library.getLibrarians().get(returnRequest.getLibrarianID()).setReceiveReport(
                            "Receive " + LocalDate.now() +
                            " Book > " + returnRequest.getBorrowedBookISBN()
                    );
                    library.getStudents().get(returnRequest.getBorrowerStudentID()).setHistory(
                            "Successful return in " + LocalDate.now() +
                            " Book > " + returnRequest.getBorrowedBookISBN()
                    );

                }
            }
            return true;

        }else

            return false;

    }

}