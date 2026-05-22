import java.util.ArrayList;
public class BankAccount {
    

    private int accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<Transaction> transactions;

    // Constructor
    public BankAccount(int accountNumber, String accountHolder, double balance) {

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    // Deposit Method
    public void deposit(double amount) {
    balance += amount;

        transactions.add(
          new Transaction("Deposit", amount)
    );

    System.out.println("Deposit successful.");

    }

    // Withdraw Method
    public void withdraw(double amount) {

        if (amount <= balance) {
            balance -= amount;

            transactions.add(
                new Transaction("Withdrawal", amount)
            );

            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Display Balance
    public void displayBalance() {

        System.out.println("Current Balance: $" + balance);
    }

    // Display Account
    public void displayAccount() {

    System.out.println("\nAccount Number: " + accountNumber);
    System.out.println("Account Holder: " + accountHolder);
    System.out.println("Balance: $" + balance);

    }

    // Getter
    public int getAccountNumber() {

        return accountNumber;
    }

    public double getBalance() {

        return balance;
    }
}

