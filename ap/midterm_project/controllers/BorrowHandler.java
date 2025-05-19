package ap.midterm_project.controllers;

import ap.midterm_project.models.Borrow;
import ap.midterm_project.models.Request;
import ap.midterm_project.constants.BookStatus;
import ap.midterm_project.constants.ValidateRoles;
import ap.midterm_project.database.Library;
import ap.midterm_project.helpers.InputHandler;
import ap.midterm_project.models.Book;
import ap.midterm_project.models.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class BorrowHandler {

    private InputHandler input = new InputHandler();
    private ValidateRoles condition = new ValidateRoles();

    public void makeLoanRequest(
            Library library,
            Student student
    ) {

        System.out.println("Enter the ISBN of book: ");
        String tempISBN = input.userInput(
                condition.ISBN_VALIDATE_CONDITION,
                "You are only allowed to use numbers(10 digits)."
        );
        Random random = new Random();

        for (Book book : library.getBooks()) {

            if (tempISBN.equals(book.getISBN())) {
                if(book.getBookStatus() == BookStatus.NOT_BORROWED) {

                    book.setBookStatus(BookStatus.IS_RESERVED);
                    library.getLoanRequests().add(
                            new Request(
                                    student,
                                    book,
                                    "Borrow",
                                    library.getLibrarians().get(random.nextInt(library.getLibrarians().size()))
                            )
                    );
                    System.out.println("Successful!");
                    return;

                }else
                    System.out.println("The book is already borrowed!");
                return;
            }

        }
        System.out.println("ISBN not found!");

    }

    public void makeReturnRequest(
            Library library,
            Student student
    ) {

        System.out.println("Enter the ISBN of book: ");
        String tempISBN = input.userInput(
                condition.ISBN_VALIDATE_CONDITION,
                "You are only allowed to use numbers(10 digits)."
        );
        Random random = new Random();

        for (Book book : library.getBooks()) {

            if (tempISBN.equals(book.getISBN())) {
                if (book.getBookStatus() == BookStatus.IS_BORROWED) {

                    library.getReturnRequests().add(
                            new Request(
                                    student,
                                    book,
                                    "Return",
                                    library.getLibrarians().get(random.nextInt(library.getLibrarians().size()))
                            )
                    );
                    System.out.println("Successful!");
                    return;

                }else
                    System.out.println("The book hasn't borrowed yet!");
                return;

            }

        }
        System.out.println("ISBN not found!");

    }

    public void acceptRequest(ArrayList<Request> loanRequests, Library library, int librarianIndex) {


        for (Request loanRequest : loanRequests) {

            int studentIndex = library.getLibraryStudents().indexOf(loanRequest.getBorrowerStudent());
            if (loanRequest.getRequestType().equals("Borrow") && loanRequest.getLibrarian().equals(library.getLibrarians().get(librarianIndex))) {
                System.out.println(loanRequest.getRequestType() + " " + loanRequest);
                if (acceptBorrowRequest(loanRequest, library.getLoans())) {
                    library.getLibraryStudents().get(studentIndex).setNotifications(
                            "your request " +
                                    loanRequest.getRequestType() + " " +
                                    loanRequest.getBorrowedBook().getISBN() +
                                    " accepted."
                    );
                    loanRequests.remove(loanRequest);
                    System.out.println("Successful");
                    return;
                } else {
                    library.getLibraryStudents().get(studentIndex).setNotifications(
                            "your request " +
                                    loanRequest.getRequestType() + " " +
                                    loanRequest.getBorrowedBook().getISBN() +
                                    " rejected."
                    );
                    loanRequest.getBorrowedBook().setBookStatus(BookStatus.NOT_BORROWED);
                    loanRequests.remove(loanRequest);
                    System.out.println("Successful");
                    return;
                }
            }
            else if(loanRequest.getLibrarian().equals(library.getLibrarians().get(librarianIndex))) {
                System.out.println(loanRequest.getRequestType() + " " + loanRequest);
                if (acceptReturnRequest(loanRequest, library.getLoans())) {
                    library.getLibraryStudents().get(studentIndex).setNotifications(
                            "your request " +
                                    loanRequest.getRequestType() + " " +
                                    loanRequest.getBorrowedBook().getISBN() +
                                    " accepted."
                    );
                    loanRequests.remove(loanRequest);
                    System.out.println("Successful");
                    return;
                } else {
                    library.getLibraryStudents().get(studentIndex).setNotifications(
                            "your request " +
                                    loanRequest.getRequestType() + " " +
                                    loanRequest.getBorrowedBook().getISBN() +
                                    " rejected."
                    );
                    loanRequest.getBorrowedBook().setBookStatus(BookStatus.NOT_BORROWED);
                    loanRequests.remove(loanRequest);
                    System.out.println("Successful");
                    return;

                }
            }

        }
        System.out.println("No items found!");

    }

    private boolean acceptBorrowRequest(Request borrowRequest, ArrayList<Borrow> borrows) {

        System.out.println("Yes or No?");
        if (input.yesOrNo()) {

            borrowRequest.getBorrowedBook().setBookStatus(BookStatus.IS_BORROWED);
            borrows.add(new Borrow(
                    borrowRequest.getBorrowerStudent(),
                    borrowRequest.getBorrowedBook(),
                    borrowRequest.getLibrarian(),
                    LocalDate.now(),
                    LocalDate.now().plusMonths(1)
            ));
            return true;

        }else

            return false;

    }

    private boolean acceptReturnRequest(Request returnRequest, ArrayList<Borrow> borrows) {

        System.out.println("Yes or No?");
        if (input.yesOrNo()) {

            for (Borrow borrow : borrows) {
                if(borrow.getBorrowedBook().equals(returnRequest.getBorrowedBook()) && borrow.getBorrowerStudent().equals(returnRequest.getBorrowerStudent())){

                    borrow.getBorrowedBook().setBookStatus(BookStatus.NOT_BORROWED);
                    borrow.returnBook(
                            returnRequest.getLibrarian(),
                            LocalDate.now()
                    );

                }
            }
            return true;

        }else

            return false;

    }

}

