import java.util.ArrayList;
import java.util.Scanner;

public class BankManager {

    private ArrayList<BankAccount> accounts;

    public BankManager() {
        accounts = FileManager.loadAccounts();
    }

    // Create Account
    public void createAccount(int accountNumber, Customer customer, double balance) {

        BankAccount account = new BankAccount(accountNumber, customer, balance);

        accounts.add(account);

        FileManager.saveAllAccounts(accounts);

        System.out.println("Account created successfully.");
    }

    // View Accounts
    public void viewAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (BankAccount account : accounts) {
                account.displayAccount();
                System.out.println("-----------------------");
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
            FileManager.saveAllAccounts(accounts);
            System.out.println("Current balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw Money
    public void withdrawMoney(int accountNumber, double amount) {

        BankAccount account = searchAccount(accountNumber);

        if (account != null) {
            account.withdraw(amount);
            FileManager.saveAllAccounts(accounts);
            System.out.println("Current balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Delete Account
    public void deleteAccount(int accountNumber) {

        BankAccount account = searchAccount(accountNumber);

        if (account != null) {
            accounts.remove(account);
            FileManager.saveAllAccounts(accounts);
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
    public void transferMoney(int fromAccount,
                          int toAccount,
                          double amount) {

    BankAccount sender = searchAccount(fromAccount);
    BankAccount receiver = searchAccount(toAccount);

    if (sender == null) {
        System.out.println("Sender account not found.");
        return;
    }

    if (receiver == null) {
        System.out.println("Receiver account not found.");
        return;
    }

    if (sender.getBalance() < amount) {
        System.out.println("Insufficient funds.");
        return;
    }

    sender.withdraw(amount);
    receiver.deposit(amount);

    System.out.println("Transfer completed successfully.");
 }
}
