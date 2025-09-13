package ap.projects.finalProject.repository;

import ap.projects.finalProject.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanRepository {

    private List<Request> loanRequests = new ArrayList<>();
    private List<Request> returnRequests = new ArrayList<>();

    // loans that returned
    private List<String> pastLoansHistory = new ArrayList<>();

    // current loans
    private List<Loan> currentLoans = new ArrayList<>();

    /**
     * Stores the information recorded in the request along with the librarian's information as well as the loan start and end dates.
     *
     * @param acceptedRequest the request that accepted by this librarian
     * @param librarian the librarian that accepted this request
     */
    public void addLoan(Request acceptedRequest, Librarian librarian, Student student) {

        Loan newLoan = new Loan(
                acceptedRequest.getBorrowerStudentUsername(),
                acceptedRequest.getBorrowedBookISBN(),
                librarian.getEmployeeID(),
                acceptedRequest.getCreateRequestDate().plusDays(1),
                acceptedRequest.getCreateRequestDate().plusDays(1).plusMonths(1)
        );

        currentLoans.add(newLoan);

        librarian.setLentBooksCount();

        student.setNotifications(LocalDate.now() + " Your request to borrow Book " + acceptedRequest.getBorrowedBookISBN() +
                " has been approved by Librarian " + librarian.getEmployeeID() + ". Visit the library to get the book."
        );

        student.setCurrentLoansCount(1);

    }

    public void returnBook(Loan loan, Request acceptedRequest, Librarian librarian, Student student) {

        loan.returnBook(librarian.getEmployeeID(), LocalDate.now());

        pastLoansHistory.add(loan.toString());

        librarian.setReclaimedBooksCount();

        student.setNotifications(LocalDate.now() + " Your request to return Book " + acceptedRequest.getBorrowedBookISBN() +
                " has been approved by Librarian " + librarian.getEmployeeID() + ". Visit the library to return the book."
        );

        if (loan.isLate(LocalDate.now()))
            student.setLateLoansCount();

        student.setCurrentLoansCount(-1);

    }

    /**
     * For students, based on the type of request,
     * a notification stating that your request to borrow a certain book was rejected by a certain librarian.
     *
     * @param rejectedRequest request information rejected by librarian
     * @param librarian the librarian who rejected the request
     * @param student a student who receives a rejection notice
     * @param requestType type of request denied by the librarian
     */
    public void rejectRequest(Request rejectedRequest,Librarian librarian, Student student, String requestType) {

        student.setNotifications(LocalDate.now() + "Your request to " + requestType + " Book " + rejectedRequest.getBorrowedBookISBN() +
                " has been approved by Librarian " + librarian.getEmployeeID() + "."
        );

    }

    /**
     * If one day has passed since the student submitted the request and the request is not approved or rejected by the librarian,
     * the system will remove that book from reserve status and reject the request.
     */
    public void rejectRequest(Request rejaectedRequest, Student student) {

        student.setNotifications(LocalDate.now() + "Your request to borrow Book " + rejaectedRequest.getBorrowedBookISBN() +
                " was rejected due to the reservation deadline."
        );

    }

    /**
     * A method for create a new loan request in library
     *
     * @param loanRequest the new request by library student
     * @see Request
     */
    public void createLoanRequest(Request loanRequest) {

        loanRequests.add(loanRequest);

    }

    /**
     * A method for create a new return request in library
     *
     * @param returnRequest the new request by library student
     * @see Request
     */
    public void createReturnRequest(Request returnRequest) {

        returnRequests.add(returnRequest);

    }

    /**
     * To access all loans in library
     *
     * @return list of all loans
     */
    public ArrayList<Loan> getAllLoans() {
        return new ArrayList<>(currentLoans);
    }

    public Loan findLoanByISBN(String ISBN) {
        return currentLoans.stream()
                .filter(s -> s.getBorrowedBookISBN().equals(ISBN))
                .findFirst()
                .orElse(null);
    }

    /**
     * To access all loan requests have created in the library
     */
    public ArrayList<Request> getAllLoanRequests() {
        return new ArrayList<>(loanRequests);
    }

    /**
     * For when the librarian approves or denies a set of requests and returns the rest intact.
     *
     * @param loanRequests requests that remain untouched will be returned.
     */
    public void setLoanRequests(List<Request> loanRequests) {
        this.loanRequests = loanRequests;
    }

    /**
     * To access all return requests have created in the library
     */
    public ArrayList<Request> getAllReturnRequests() {
        return new ArrayList<>(returnRequests);
    }

    /**
     * To access to count of current loans in the library
     *
     * @return the count of current loans
     */
    public int currentLoansCount() {
        return currentLoans.size();
    }

    /**
     * To access to count of returned loans in the library
     *
     * @return the count of returned loans
     */
    public int pastLoansCount() {
        return pastLoansHistory.size();
    }

}
