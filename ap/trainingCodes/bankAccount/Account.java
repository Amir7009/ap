package ap.trainingCodes.bankAccount;

public class Account {

    private DepositType depositType;
    private String firstName, lastName, nationalCode;
    private String accountNumber, password;
    private double balance = 0;
    private boolean isActive;

    public Account(String firstName, String lastName, String nationalCode, String accountNumber, String password, double balance, DepositType depositType, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.depositType = depositType;
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = balance;
        this.isActive = isActive;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public DepositType getDepositType() {
        return depositType;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setActive() {
        isActive = true;
    }

    public void setUnActive() {
        isActive = false;
    }

    public boolean getIsActive() {
        return isActive;
    }

}