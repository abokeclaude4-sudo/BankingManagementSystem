import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BankManager manager = new BankManager();
        LoginManager loginManager = new LoginManager();

        boolean loggedIn = false;
        User loggedInUser = null;

        // =========================
        // LOGIN SYSTEM
        // =========================

        while (!loggedIn) {

            System.out.println("\n===== BANK LOGIN SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int loginChoice = scanner.nextInt();
            scanner.nextLine();

            if (loginChoice == 1) {

                System.out.print("Enter username: ");
                String username = scanner.nextLine();

                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                System.out.print("Enter full name: ");
                String fullName = scanner.nextLine();

                System.out.print("Enter security question: ");
                String securityQuestion = scanner.nextLine();

                System.out.print("Enter security answer: ");
                String securityAnswer = scanner.nextLine();

                loginManager.registerUser(
                        username,
                        password,
                        "Customer",
                        fullName,
                        securityQuestion,
                        securityAnswer
                );

            } else if (loginChoice == 2) {

                System.out.print("Username: ");
                String username = scanner.nextLine();

                System.out.print("Password: ");
                String password = scanner.nextLine();

                loggedInUser = loginManager.login(username, password);

                if (loggedInUser != null) {

                    System.out.println("Welcome " + loggedInUser.getFullName());

                    loggedInUser.displayUser();

                    loggedIn = true;
                }

            } else if (loginChoice == 3) {

                System.out.println("Goodbye.");
                scanner.close();
                return;

            } else {

                System.out.println("Invalid option.");
            }
        }

        // =========================
        // BANK MANAGEMENT SYSTEM
        // =========================

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
                    // CREATE ACCOUNT CODE
                    break;

                case 2:
                    manager.viewAccounts();
                    break;

                case 3:
                    // SEARCH ACCOUNT CODE
                    break;

                case 4:
                    // DEPOSIT CODE
                    break;

                case 5:
                    // WITHDRAW CODE
                    break;

                case 6:
                    // DELETE CODE
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