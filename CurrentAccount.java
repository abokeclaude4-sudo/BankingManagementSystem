public class CurrentAccount extends BankAccount {

    private double overdraftLimit;

    public CurrentAccount(int accountNumber,
                          String ownerName,
                          double balance,
                          double overdraftLimit) {

        super(accountNumber, ownerName, balance);

        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {

        if (amount <= (getBalance() + overdraftLimit)) {

            setBalance(getBalance() - amount);

            System.out.println("Withdrawal successful.");

        } else {

            System.out.println("Overdraft limit exceeded.");
        }
    }
}