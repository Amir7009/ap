package ap.trainingCodes.bankAccount;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class BankMain {

    public static void main(String[] args) {

        ArrayList<Account> accounts = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("\n1-Create an account\n2-Login\n3-Recover account information");
            int key1 = input.nextInt(); // for switch on options
            input.nextLine();

            switch (key1) {

                case 1: { // to create an account

                    createAccount(accounts, input);
                    break;

                }

                case 2: { // login

                    login(accounts, input);
                    break;
                }

                case 3: { // Recover account information

                    recoverAccountInformation(accounts, input);
                    break;

                }

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public static void createAccount(ArrayList<Account> accounts, Scanner input) {

        String firstName = null, lastName = null, nationalCode = null, accountNumber = null, password = null;
        double balance = 0;
        DepositType depositType = null;
        boolean s1 = true, s2 = true, s3 = true, s4 = true, s5 = true, s6 = true, s7 = true;
        Random random = new Random();

        System.out.println("Please enter your first name: ");
        while (s1) { // set account owner's first name
            firstName = input.nextLine();
            if (firstName.matches("[a-zA-Z ]+")) {
            s1 = false;
            } else {
                System.out.println("input must be characters only! please try again.");
            }
        }

        System.out.println("Please enter your last name: ");
        while (s2) { // set account owner's last name
            lastName = input.nextLine();
            if (lastName.matches("[a-zA-Z ]+")) {
                s2 = false;
            } else {
                System.out.println("input must be characters only! please try again.");
            }
        }

        System.out.println("Please enter your national code (10 digits): ");
        while (s3) { // set account owner's national code
            nationalCode = input.nextLine();
            if (nationalCode.length() == 10 && nationalCode.matches("\\d+")) {
                s3 = false;
            } else {
                System.out.println("Invalid national code!\nPlease try again!");
            }
        }

        System.out.println("This is your account number. Please note it. ");
        while (s4) { // generate account number
            accountNumber = "40320050" + (random.nextLong(99999999 - 10000000 + 1) + 10000000);
            boolean accountExists = false;
            for (Account account : accounts) {
                if (accountNumber.equals(account.getAccountNumber())) {
                    accountExists = true;
                }
            }
            if (!accountExists) {
                System.out.println(accountNumber);
                s4 = false;
            }
        }
        while (s5) { // generate password
            System.out.println("This is your password. Please note it. ");
            password = "" + (random.nextInt(9999 - 1000 + 1)+1000);
            System.out.println(password);
            s5 = false;
        }
        while (s6) { // choose type of money to deposit
            System.out.println("What type of money do you want to keep in your account? ");
            System.out.println("1-Dollars\n2-Rials");
            int type = input.nextInt();
            if (type == 1) {
                depositType = DepositType.DOLLARS;
                s6 = false;
            } else if (type == 2) {
                depositType = DepositType.RIALS;
                s6 = false;
            } else {
                System.out.println("Incorrect input!\nPlease try again!");
            }
        }
        while (s7) { // set initial amount of money
            System.out.println("please enter your initial amount of money. ");
            balance = input.nextDouble();
            if (balance > 0) {
                s7 = false;
            } else {
                System.out.println("Invalid Amount\nPlease try again!");
            }
        }

        accounts.add(new Account(firstName, lastName, nationalCode, accountNumber, password, balance, depositType, true));

    }

    public static void login(ArrayList<Account> accounts, Scanner input){

        String accountNumber, password;
        System.out.println("Enter your account number: ");
        accountNumber = input.nextLine();
        byte breaker = 0;
        while (breaker == 0) {
            for (Account list : accounts) {
                if (list.getAccountNumber().equals(accountNumber)) {

                    if (list.getIsActive()) {
                        int limit = 0;
                        System.out.println("Enter your password: ");
                        while (limit < 3) {
                            password = input.nextLine();
                            if (list.getPassword().equals(password)) {
                                breaker = accountOptions(list, input);
                                break;
                            } else {
                                System.out.println("incorrect password! please try again.");
                                limit++;
                            }
                        }
                        if (limit == 3) {
                            System.out.println("Your account has been blocked.");
                            list.setUnActive();
                            breaker = -1;
                        }
                    }else{
                        System.out.println("Your account has been blocked.");
                        breaker = -1;
                    }
                }
            }
            if (breaker == 0) {
                System.out.println("Account Not found!");
                breaker = -1;
            } else if (breaker == 2) {
                System.out.println("You have been kicked out of the account.");
            }
        }

    }

    public static byte accountOptions(Account list, Scanner input) {

        while (true) {
            designMenu();
            int key2;
            key2 = input.nextInt();
            switch (key2) {

                case 1: {

                    System.out.println("Enter your current password:");
                    int limit = 0;
                    while (true) {
                        String prevPass = input.next();
                        if (prevPass.equals(list.getPassword())) {
                            System.out.println("Enter your new password:");
                            String newPass = input.next();
                            list.setPassword(newPass);
                            break;
                        }
                        if (limit < 2) {
                            System.out.println("Password does not match! try again.");
                            limit++;
                        } else {
                            System.out.println("3 incorrect attempts!");
                            return 2;
                        }
                    }
                    break;

                }

                case 2: {

                    deposit(list, input);
                    break;

                }

                case 3: {

                    withdraw(list, input);
                    break;

                }

                case 4: {

                    System.out.print("Your current balance is: " + list.getBalance());
                    if (list.getDepositType() == DepositType.DOLLARS) {
                        System.out.println(" dollars");
                        break;
                    } else {
                        System.out.println(" rials");
                        break;
                    }

                }

                case 5: {

                    System.out.println("Thanks for using our Bank system");
                    return 1;

                }

                default:

                    System.out.println("Invalid option");
                    break;
            }
        }

    }

    public static void designMenu() {
        System.out.println("\nPlease enter your option:\n");
        System.out.println("1. Change Password");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Exit\n");
    }

    public static DepositType exchange(Scanner input) {

        System.out.println("Would you like your transaction to be in dollars or rials? ");
        System.out.println("1-Dollars\n2-Rials");
        boolean breaker = true;
        while (true) {
            int type = input.nextInt();
            if (type == 1) {
                return DepositType.DOLLARS;
            } else if (type == 2) {
                return DepositType.RIALS;
            } else {
                System.out.println("invalid option");
            }
        }
    }

    public static void withdraw(Account account, Scanner input) {

        DepositType type = exchange(input);
        System.out.println("Enter amount to withdraw: ");
        double withdraw = input.nextDouble();
        if (withdraw > 0) {
            if (account.getDepositType() == type) {
                if (account.getBalance() >= withdraw) {
                    account.setBalance(account.getBalance() - withdraw);
                    System.out.print("withdraw successful! ");
                    remainingBalance(account);
                } else
                    System.out.println("Insufficient account balance.");
            } else if (type == DepositType.DOLLARS) {
                withdraw = withdraw * getUSDPrice();
                if (account.getBalance() >= withdraw) {
                    account.setBalance(account.getBalance() - withdraw);
                    System.out.print("withdraw successful! ");
                    remainingBalance(account);
                } else
                    System.out.println("Insufficient account balance.");
            } else {
                withdraw = withdraw / getUSDPrice();
                if (account.getBalance() >= withdraw) {
                    account.setBalance(account.getBalance() - withdraw);
                    System.out.print("withdraw successful! ");
                    remainingBalance(account);
                } else
                    System.out.println("Insufficient account balance.");
            }
        } else
            System.out.println("Invalid amount!");

    }

    public static void deposit(Account account, Scanner input) {

        DepositType type = exchange(input);
        System.out.println("Enter amount to deposit: ");
        double deposit = input.nextDouble();
        if (deposit > 0) {
            if (account.getDepositType() == type) {
                account.setBalance(deposit + account.getBalance());
                System.out.print("deposit successful! ");
                remainingBalance(account);
            } else if (type == DepositType.DOLLARS) {
                deposit = deposit * getUSDPrice();
                account.setBalance(deposit + account.getBalance());
                System.out.print("deposit successful! ");
                remainingBalance(account);
            } else {
                deposit = deposit / getUSDPrice();
                account.setBalance(deposit + account.getBalance());
                System.out.print("deposit successful! ");
                remainingBalance(account);
            }
        } else
            System.out.println("Invalid amount!");

    }

    public static void remainingBalance (Account account){

        System.out.print("Remaining account balance:" + account.getBalance());
        if (account.getDepositType() == DepositType.DOLLARS) {
            System.out.println(" dollars");
        } else {
            System.out.println(" rials");
        }

    }

    public static void recoverAccountInformation(ArrayList<Account> accounts, Scanner input){

        System.out.println("Enter your national code: ");
        String temp = input.nextLine();
        boolean checker = true;
        for (Account account : accounts) {
            if (account.getNationalCode().equals(temp)) {
                while (checker) {
                    System.out.println("Enter your first name: ");
                    temp = input.nextLine();
                    if (account.getFirstName().equals(temp)) {
                        while (checker) {
                            System.out.println("Enter your last name: ");
                            temp = input.nextLine();
                            if (account.getLastName().equals(temp)) {
                                System.out.println("your account number:\n" + account.getAccountNumber());
                                System.out.println("your password:\n" + account.getPassword());
                                account.setActive();
                                checker = false;
                            }
                        }
                    }
                }
            }
        }
        if (checker) {
            System.out.println("not found!");
        }

    }

    public static double getUSDPrice() {

        String apiKey = "free2ndoQgj0OUbZOmSXN2m5U6XVEZM0"; // API key
        String urlString = "https://api.navasan.tech/latest/?api_key=" + apiKey;
        double value;

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8")
            );
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonObject = new JSONObject(response.toString());

            // get realtime USD price
            JSONObject usd = jsonObject.getJSONObject("usd");
            value = usd.getDouble("value") * 10;

        } catch (Exception e) {
            e.printStackTrace();
            value = 840000;
        }
        return value;

    }

}