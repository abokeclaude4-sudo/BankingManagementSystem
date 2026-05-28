import java.util.ArrayList;

public class BankAccount {

    private int accountNumber;
    private String ownerName;
    protected double balance;
    private Customer customer; 

    private ArrayList<Transaction> transactions;

    public BankAccount(int accountNumber, Customer customer, double balance) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }
    public BankAccount(int accountNumber, String accountHolder, double balance) {

    this.accountNumber = accountNumber;
    this.customer = new Customer(accountNumber, accountHolder, "N/A", "N/A");
    this.balance = balance;
    this.transactions = new ArrayList<>();
}

    public int getAccountNumber() {
        return accountNumber;
    }
    public void displayAccount() {

    System.out.println("Account Number: " + accountNumber);
    System.out.println("Customer Name: " + customer.getFullName());
    System.out.println("Balance: $" + balance);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
    public void displayTransactions() {
        if (transactions.isEmpty()) {
        System.out.println("No transactions found.");
        } else {
        System.out.println("\nTransaction History:");

        for (Transaction t : transactions) {
            System.out.println(t);
        }

        System.out.println("Current balance: $" + balance);
    }
}

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
               ", Name: " + ownerName +
               ", Balance: $" + balance;
    }
}