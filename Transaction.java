public class Transaction {

    private int transactionId;
    private int accountId;
    private String type;
    private double amount;
    private String date;

    // Full Constructor
    public Transaction(int transactionId, int accountId, String type, double amount, String date) {

        this.transactionId = transactionId;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    // Simple Constructor
    public Transaction(String type, double amount) {

        this.type = type;
        this.amount = amount;
    }

    // Getters
    public int getTransactionId() {
        return transactionId;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    // Display Transaction
    @Override
    public String toString() {

        return type + " - $" + amount;
    }
}