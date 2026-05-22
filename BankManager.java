import java.util.ArrayList;

public class BankManager {

    // ArrayList to store bank accounts
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    // ArrayList to store transactions
    private ArrayList<Transaction> transactions = new ArrayList<>();

    // Transaction ID counter
    private int nextTransactionId = 1;

    // Create Account
    public void createAccount(int accountNumber, String accountHolder, double balance) {

        BankAccount newAccount =
                new BankAccount(accountNumber, accountHolder, balance);

        accounts.add(newAccount);

        System.out.println("Account created successfully.");
    }

    // View All Accounts
    public void viewAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        for (BankAccount account : accounts) {
            account.displayAccount();
            System.out.println("------------------");
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

            transactions.add(
                    new Transaction(
                            nextTransactionId++,
                            account.getAccountNumber(),
                            "Deposit",
                            amount,
                            java.time.LocalDate.now().toString()
                    )
            );

        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw Money
    public void withdrawMoney(int accountNumber, double amount) {

        BankAccount account = searchAccount(accountNumber);

        if (account != null) {

            account.withdraw(amount);

            transactions.add(
                    new Transaction(
                            nextTransactionId++,
                            account.getAccountNumber(),
                            "Withdrawal",
                            amount,
                            java.time.LocalDate.now().toString()
                    )
            );

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

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}