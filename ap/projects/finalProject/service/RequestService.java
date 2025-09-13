package ap.projects.finalProject.service;

import ap.projects.midtermProject.constants.BookStatus;
import ap.projects.finalProject.LibrarySystem;
import ap.projects.finalProject.model.Librarian;
import ap.projects.finalProject.model.Loan;
import ap.projects.finalProject.model.Request;
import ap.projects.finalProject.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class RequestService {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * This method allows the librarian to view the content of requests to borrow books and approve or reject them if necessary.
     *
     * @param librarian librarian who reviews requests
     * @return requests that remain untouched
     */
    public ArrayList<Request> handleLoanRequests(Librarian librarian, LibrarySystem librarySystem) {

        ArrayList<Request> requests = librarySystem.getLoanService().getRepository().getAllLoanRequests();
        LinkedHashMap<Integer, Request> requestsList = new LinkedHashMap<>();

        /*
        This loop filters out deposits whose reservation period has expired.
         */
        for (int i = 0; i < requests.size(); i++) {

            Student student = librarySystem.getStudentService()
                    .getRepository().findAll()
                    .get(requests.get(i).getBorrowerStudentUsername());

            if (LocalDate.now().isAfter(requests.get(i).getCreateRequestDate())) {
                librarySystem.getLoanService().getRepository().rejectRequest(requests.get(i), student);
                requests.remove(i);
                i--;
            }

        }

        /*
        This loop groups requests into a map for easier access.
         */
        for (int i = 0; i < requests.size(); i++) {

            requestsList.put(i, requests.get(i));

        }

        System.out.println("\n--- Accept Loan Requests ---\n");

        for (int i = 0; i < requests.size(); i++) {
            Student student = librarySystem.getStudentService()
                    .getRepository().findAll()
                    .get(requestsList.get(i).getBorrowerStudentUsername());
            System.out.println("Do you want to accept this request?\ty/n\n");
            System.out.println(requestsList.get(i));
            System.out.println("\n1-Next");
            System.out.println("0-Exit");
            String input = scanner.nextLine().toLowerCase();
            if (input.contains("y")) {
                librarySystem.getLoanService()
                        .getRepository()
                        .addLoan(requestsList.get(i), librarian, student);
                librarySystem.getBookService()
                        .getRepository()
                        .findByISBN(requestsList.get(i).getBorrowedBookISBN())
                        .setBookStatus(BookStatus.IS_BORROWED);
                requestsList.remove(i);
                System.out.println("Successful!");
            }
            if (input.contains("n")) {
                librarySystem.getLoanService().getRepository()
                        .rejectRequest(requestsList.get(i), librarian, student, "borrow");
                requestsList.remove(i);
                System.out.println("Successful!");
            }
            if (input.contains("0")) {
                return new ArrayList<>(requestsList.values());
            }
        }

        /*
        Requests that remain untouched will be returned.
         */
        return new ArrayList<>(requestsList.values());

    }

    /**
     * This method allows the librarian to view the content of requests to return books and approve or reject them if necessary.
     *
     * @param librarian librarian who reviews requests
     * @return requests that remain untouched
     */
    public ArrayList<Request> handleReturnRequests(Librarian librarian, LibrarySystem librarySystem) {

        ArrayList<Request> requests = librarySystem.getLoanService().getRepository().getAllReturnRequests();
        LinkedHashMap<Integer, Request> requestsList = new LinkedHashMap<>();

        /*
        This loop groups requests into a map for easier access.
         */
        for (int i = 0; i < requests.size(); i++) {

            requestsList.put(i, requests.get(i));

        }

        System.out.println("\n--- Accept Return Requests ---\n");

        for (int i = 0; i < requests.size(); i++) {
            Student student = librarySystem.getStudentService()
                    .getRepository().findAll()
                    .get(requestsList.get(i).getBorrowerStudentUsername());
            System.out.println("Do you want to accept this request?\ty/n\n");
            System.out.println(requestsList.get(i));
            System.out.println("\n1-Next");
            System.out.println("0-Exit");
            String input = scanner.nextLine().toLowerCase();
            if (input.contains("y")) {
                Loan loan = librarySystem.getLoanService()
                        .getRepository()
                        .findLoanByISBN(requestsList.get(i).getBorrowedBookISBN());
                librarySystem.getLoanService()
                        .getRepository()
                        .returnBook(loan, requestsList.get(i), librarian, student);
                librarySystem.getBookService()
                        .getRepository()
                        .findByISBN(requestsList.get(i).getBorrowedBookISBN())
                        .setBookStatus(BookStatus.NOT_BORROWED);
                librarySystem.getLoanService().getRepository().getAllLoans().remove(loan);
                requestsList.remove(i);
                System.out.println("Successful!");
            }
            if (input.contains("n")) {
                librarySystem.getLoanService().getRepository()
                        .rejectRequest(requestsList.get(i), librarian, student, "return");
                requestsList.remove(i);
                System.out.println("Successful!");
            }
            if (input.contains("0")) {
                return new ArrayList<>(requestsList.values());
            }
        }

        /*
        Requests that remain untouched will be returned.
         */
        return new ArrayList<>(requestsList.values());
    }

}
