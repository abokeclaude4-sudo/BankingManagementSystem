import java.io.*;
import java.util.ArrayList;

public class FileManager {

    // =========================
    // SAVE BANK ACCOUNT
    // =========================
    public static void saveAccount(BankAccount account) {

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("accounts.txt", true));

            writer.println(
                    account.getAccountNumber() + "," +
                    account.getOwnerName() + "," +
                    account.getBalance()
            );

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving account.");
        }
    }

    // =========================
    // LOAD BANK ACCOUNTS
    // =========================
    public static ArrayList<BankAccount> loadAccounts() {

        ArrayList<BankAccount> accounts = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length < 3) {
                    continue;
                }

                int accountNumber = Integer.parseInt(data[0]);
                String ownerName = data[1];
                double balance = Double.parseDouble(data[2]);

                BankAccount account = new BankAccount(accountNumber, ownerName, balance);

                accounts.add(account);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("No saved accounts found.");
        }

        return accounts;
    }

    // =========================
    // SAVE USER
    // =========================
    public static void saveUser(User user) {

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("users.txt", true));

            writer.println(
                    user.getUsername() + "," +
                    user.getPassword() + "," +
                    user.getRole() + "," +
                    user.getFullName() + "," +
                    user.getSecurityQuestion() + "," +
                    user.getSecurityAnswer()
            );

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving user.");
        }
    }

    // =========================
    // LOAD USERS
    // =========================
    public static ArrayList<User> loadUsers() {

        ArrayList<User> users = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length < 6) {
                    continue;
                }

                String username = data[0];
                String password = data[1];
                String role = data[2];
                String fullName = data[3];
                String securityQuestion = data[4];
                String securityAnswer = data[5];

                User user = new User(
                        username,
                        password,
                        role,
                        fullName,
                        securityQuestion,
                        securityAnswer
                );

                users.add(user);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("No saved users found.");
        }

        return users;
    }
}