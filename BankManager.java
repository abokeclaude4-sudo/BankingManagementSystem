import java.util.ArrayList;
import java.util.Scanner;

public class BankManager {

    private ArrayList<BankAccount> accounts = new ArrayList<>();

    // Create Account
    public void createAccount(int accountNumber, String name, double balance) {

        BankAccount account = new BankAccount(accountNumber, name, balance);

        accounts.add(account);

        System.out.println("Account created successfully.");
    }

    // View Accounts
    public void viewAccounts() {

        if (accounts.isEmpty()) {

            System.out.println("No accounts found.");

        } else {

            for (BankAccount account : accounts) {

                System.out.println(account);
            }
        }
    }

    // Search Account
    public BankAccount searchAccount(int accountNumber) {

        for (BankAccount account : accounts) {

            if (account.getAccountNumber() == accountNumber) {

                return account;
            }
        }

        return null;
    }

    // Deposit Money
    public void depositMoney(int accountNumber, double amount) {

        BankAccount account = searchAccount(accountNumber);

        if (account != null) {

            account.deposit(amount);
            account.displayBalance();

        } else {

            System.out.println("Account not found.");
        }
    }

    // Withdraw Money
    public void withdrawMoney(int accountNumber, double amount) {

        BankAccount account = searchAccount(accountNumber);

        if (account != null) {

            account.withdraw(amount);
            account.displayBalance();

        } else {

            System.out.println("Account not found.");
        }
    }

    // Delete Account
    public void deleteAccount(int accountNumber) {

        BankAccount account = searchAccount(accountNumber);

        if (account != null) {

            accounts.remove(account);

            System.out.println("Account deleted successfully.");

        } else {

            System.out.println("Account not found.");
        }
    }

    // View Transactions
    public void viewTransactions() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        int accountNumber = input.nextInt();

        BankAccount account = searchAccount(accountNumber);

        if (account != null) {

            account.displayTransactions();

        } else {

            System.out.println("Account not found.");
        }
    }
}