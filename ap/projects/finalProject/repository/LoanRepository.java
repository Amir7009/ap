package ap.projects.finalProject.repository;

import ap.projects.finalProject.model.Loan;
import ap.projects.finalProject.model.Request;

import java.util.ArrayList;
import java.util.List;

public class LoanRepository {

    private List<Request> loanRequests = new ArrayList<>();
    private List<Request> returnRequests = new ArrayList<>();

    private List<String> allLoansHistory = new ArrayList<>();

    private List<Loan> loans = new ArrayList<>();

    /**
     * a method for create a new loan request in library
     *
     * @param loanRequest The new request by library student
     * @see Request
     */
    public void createLoanRequest(Request loanRequest) {

        loanRequests.add(loanRequest);

    }

    public void createReturnRequest() {

    }

    /**
     * to access all loans in library
     *
     * @return list of all loans
     */
    public List<Loan> getAllLoans() {
        return new ArrayList<>(loans);
    }

    /**
     * to access all loan requests have created in the library
     */
    public List<Request> getAllLoanRequests() {
        return new ArrayList<>(loanRequests);
    }

    /**
     * to access all return requests have created in the library
     */
    public List<Request> getAllReturnRequests() {
        return new ArrayList<>(returnRequests);
    }

}
