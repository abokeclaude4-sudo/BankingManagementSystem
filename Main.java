import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BankManager manager = new BankManager();

        int choice;

        do {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Search Account");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Delete Account");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int accountNumber = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String accountHolder = scanner.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();

                    manager.createAccount(accountNumber, accountHolder, balance);
                    break;

                case 2:
                    manager.viewAccounts();
                    break;

                case 3:
                    System.out.print("Enter Account Number to Search: ");
                    int searchNumber = scanner.nextInt();

                    BankAccount found = manager.searchAccount(searchNumber);

                    if (found != null) {
                        found.displayAccount();
                    } else {
                        System.out.println("Account not found.");
                    }

                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int depositAccountNumber = scanner.nextInt();

                    BankAccount depositAccount = manager.searchAccount(depositAccountNumber);

                    if (depositAccount != null) {
                        System.out.print("Enter Deposit Amount: ");
                        double depositAmount = scanner.nextDouble();

                        depositAccount.deposit(depositAmount);
                        depositAccount.displayBalance();
                    } else {
                        System.out.println("Account not found.");
                    }

                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    int withdrawAccountNumber = scanner.nextInt();

                    BankAccount withdrawAccount = manager.searchAccount(withdrawAccountNumber);

                    if (withdrawAccount != null) {
                        System.out.print("Enter Withdrawal Amount: ");
                        double withdrawAmount = scanner.nextDouble();

                        withdrawAccount.withdraw(withdrawAmount);
                        withdrawAccount.displayBalance();
                    } else {
                        System.out.println("Account not found.");
                    }

                    break;

                case 6:
                    System.out.print("Enter Account Number to Delete: ");
                    int deleteAccountNumber = scanner.nextInt();

                    manager.deleteAccount(deleteAccountNumber);
                    break;

                case 7:
                    manager.viewTransactions();
                    break;

                case 8:
                   System.out.println("Goodbye!");
                   break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 8);

        scanner.close();
    }
}