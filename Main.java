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
            System.out.println("7. View Transactions");
            System.out.println("8. Exit");

            System.out.print("Choose option: ");
            choice = scanner.nextInt();

            switch (choice) {
               
                case 1:
            System.out.print("Enter Account Number: ");
            int accountNumber = scanner.nextInt();

            scanner.nextLine();

            System.out.print("Enter Customer Name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter Phone Number: ");
            String phone = scanner.nextLine();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            Customer customer =
                   new Customer(accountNumber, customerName, phone, email);

            System.out.print("Enter Initial Balance: ");
            double balance = scanner.nextDouble();

            manager.createAccount(accountNumber, customer, balance);
            break;

                case 2:

                    manager.viewAccounts();

                    break;

                case 3:

                    System.out.print("Enter Account Number: ");
                    int searchNumber = scanner.nextInt();

                    BankAccount foundAccount = manager.searchAccount(searchNumber);

                    if (foundAccount != null) {

                        foundAccount.displayAccount();
                    } else {

                        System.out.println("Account not found.");

                    }

                    break;

                case 4:

                    System.out.print("Enter Account Number: ");
                    int depositNumber = scanner.nextInt();

                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = scanner.nextDouble();

                    manager.depositMoney(depositNumber, depositAmount);

                    break;

                case 5:

                    System.out.print("Enter Account Number: ");
                    int withdrawNumber = scanner.nextInt();

                    System.out.print("Enter Withdrawal Amount: ");
                    double withdrawAmount = scanner.nextDouble();

                    manager.withdrawMoney(withdrawNumber, withdrawAmount);

                    break;

                case 6:

                    System.out.print("Enter Account Number to Delete: ");
                    int deleteNumber = scanner.nextInt();

                    manager.deleteAccount(deleteNumber);

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