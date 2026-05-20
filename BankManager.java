import java.util.ArrayList;

public class BankManager {

    // ArrayList to store bank accounts
    private ArrayList<BankAccount> accounts = new ArrayList<>();

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
            System.out.println("-------------------");
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

// Delete Account
public void deleteAccount(int accountNumber) {

    BankAccount accountToRemove = searchAccount(accountNumber);

    if (accountToRemove != null) {

        accounts.remove(accountToRemove);

        System.out.println("Account deleted successfully.");

    } else {

        System.out.println("Account not found.");
    }
}
}