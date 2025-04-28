package ap.trainingCodes.bankAccount;

import java.util.ArrayList;
import java.util.Scanner;

public class bankMain {

    public static void main(String[] args) {

        ArrayList<Account> accounts = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\n1-Create an account\n2-Login");
            int key1;
            key1 = input.nextInt();
            input.nextLine();
            switch (key1) {

                case 1: {
                    String accountNumber = null, password = null;
                    double balance = 0;
                    boolean s1 = true, s2 = true, s3 = true;
                    while (s1) {
                        System.out.println("Please enter your account number (16 digits): ");
                        accountNumber = input.nextLine();
                        if (accountNumber.length() == 16 && accountNumber.matches("\\d+")) {
                            for (Account list : accounts) {
                                if (list.getAccountNumber().equals(accountNumber)) {
                                    System.out.println("This account already exists!");
                                    s2 = s3 = false;
                                    break;
                                }
                            }
                            s1 = false;
                        } else {
                            System.out.println("Invalid account number\nPlease try again!");
                        }
                    }
                    while (s2) {
                        System.out.println("please enter your password (4 digits): ");
                        password = input.nextLine();
                        if (password.length() == 4 && password.matches("\\d+")) {
                            s2 = false;
                        } else {
                            System.out.println("Invalid password\nPlease try again!");
                        }
                    }
                    while (s3) {
                        System.out.println("please enter your initial amount of money. ");
                        balance = input.nextDouble();
                        if (balance > 0) {
                            s3 = false;
                        } else {
                            System.out.println("Invalid Amount\nPlease try again!");
                        }
                    }

                    accounts.add(new Account(accountNumber, password, balance));
                    break;
                }

                case 2: {
                    String accountNumber, password;
                    System.out.println("Enter your account number: ");
                    accountNumber = input.nextLine();
                    System.out.println("Enter your password: ");
                    password = input.nextLine();

                    boolean breaker = true;
                    for (Account list : accounts) {
                        if (list.getAccountNumber().equals(accountNumber) && list.getPassword().equals(password)) {

                            boolean s4 = true;
                            while (s4) {
                                designMenu();
                                int key2;
                                key2 = input.nextInt();
                                switch (key2) {

                                    case 1: {
                                        while (true) {
                                            System.out.println("Enter your current password:");
                                            String prevPass = input.next();
                                            if (prevPass.equals(list.getPassword())) {
                                                System.out.println("Enter your new password:");
                                                String newPass = input.next();
                                                list.setPassword(newPass);
                                                break;
                                            } else {
                                                System.out.println("Password does not match");
                                                break;
                                            }
                                        }
                                        break;
                                    }

                                    case 2: {
                                        System.out.println("Enter amount to deposit: ");
                                        double deposit = input.nextDouble();
                                        if (deposit > 0) {
                                            list.setBalance(deposit + list.getBalance());
                                        }else{
                                            System.out.println("Invalid amount!");
                                        }
                                        break;
                                    }

                                    case 3: {
                                        System.out.println("Enter amount to withdraw: ");
                                        double withdraw = input.nextDouble();
                                        if (withdraw > 0)
                                            if (list.getBalance() >= withdraw)
                                                list.setBalance(list.getBalance() - withdraw);
                                            else
                                                System.out.println("Insufficient account balance.");
                                        else
                                            System.out.println("Invalid amount!");
                                        break;
                                    }

                                    case 4: {
                                        System.out.println("Your current balance is: " + list.getBalance());
                                        break;
                                    }

                                    case 5: {
                                        System.out.println("Thanks for using our Bank system");
                                        s4 = false;
                                        breaker = false;
                                        break;
                                    }

                                    default:
                                        System.out.println("Invalid option");
                                        break;
                                }
                            }
                        }
                    }
                    if (breaker) {
                        System.out.println("Account Not found!");
                    }
                    break;
                }
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
}