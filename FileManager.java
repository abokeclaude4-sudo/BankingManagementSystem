import java.io.*;
import java.util.ArrayList;

public class FileManager {

    // Save one account
    public static void saveAccount(BankAccount account) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("accounts.txt", true));

            Customer customer = account.getCustomer();

            writer.println(
                    account.getAccountNumber() + "," +
                    customer.getCustomerId() + "," +
                    customer.getFullName() + "," +
                    customer.getPhone() + "," +
                    customer.getEmail() + "," +
                    account.getBalance()
            );

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving account.");
        }
    }

    // Save all accounts after update/delete/deposit/withdraw
    public static void saveAllAccounts(ArrayList<BankAccount> accounts) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("accounts.txt"));

            for (BankAccount account : accounts) {
                Customer customer = account.getCustomer();

                writer.println(
                        account.getAccountNumber() + "," +
                        customer.getCustomerId() + "," +
                        customer.getFullName() + "," +
                        customer.getPhone() + "," +
                        customer.getEmail() + "," +
                        account.getBalance()
                );
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving accounts.");
        }
    }

    // Load bank accounts
    public static ArrayList<BankAccount> loadAccounts() {
        ArrayList<BankAccount> accounts = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length < 6) {
                    continue;
                }

                int accountNumber = Integer.parseInt(data[0]);
                int customerId = Integer.parseInt(data[1]);
                String fullName = data[2];
                String phone = data[3];
                String email = data[4];
                double balance = Double.parseDouble(data[5]);

                Customer customer = new Customer(customerId, fullName, phone, email);

                BankAccount account = new BankAccount(accountNumber, customer, balance);

                accounts.add(account);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("No saved accounts found.");
        }

        return accounts;
    }

    // Save user
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

    // Load users
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

                User user = new User(
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5]
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