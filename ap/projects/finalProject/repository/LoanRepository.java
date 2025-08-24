package ap.projects.finalProject.repository;

import ap.projects.finalProject.model.Loan;
import ap.projects.finalProject.model.Request;

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
        return new ArrayList<>(currentLoans);
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

    /**
     * to access to count of current loans in the library
     *
     * @return the count of current loans
     */
    public int currentLoansCount() {
        return currentLoans.size();
    }

    /**
     * to access to count of returned loans in the library
     *
     * @return the count of returned loans
     */
    public int pastLoansCount() {
        return pastLoansHistory.size();
    }

}
