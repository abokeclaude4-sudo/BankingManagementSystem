import java.util.ArrayList;

public class BankAccount {

    private int accountNumber;
    private String ownerName;
    protected double balance;

    private ArrayList<Transaction> transactions;

    public BankAccount(int accountNumber, String ownerName, double balance) {

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;

        transactions = new ArrayList<>();
    }
    public void setBalance(double balance) {
    this.balance = balance;
   } 

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {

        balance += amount;

        transactions.add(new Transaction("Deposit", amount));

        System.out.println("Deposit successful.");
    }

    public void withdraw(double amount) {

        if (amount <= balance) {

            balance -= amount;

            transactions.add(new Transaction("Withdraw", amount));

            System.out.println("Withdrawal successful.");

        } else {

            System.out.println("Insufficient funds.");
        }
    }

    public void displayBalance() {

        System.out.println("Current Balance: $" + balance);
    }

    public void displayTransactions() {

        if (transactions.isEmpty()) {

            System.out.println("No transactions found.");

        } else {

            System.out.println("\nTransaction History:");

            for (Transaction t : transactions) {

                System.out.println(t);
            }
        }
    }

    @Override
    public String toString() {

        return "Account Number: " + accountNumber +
               ", Name: " + ownerName +
               ", Balance: $" + balance;
    }
}