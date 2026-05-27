import java.io.*;
import java.util.ArrayList;

public class FileManager {

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

    public static ArrayList<BankAccount> loadAccounts() {

        ArrayList<BankAccount> accounts = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int accountNumber = Integer.parseInt(data[0]);
                String ownerName = data[1];
                double balance = Double.parseDouble(data[2]);

                BankAccount account =
                        new BankAccount(accountNumber, ownerName, balance);

                accounts.add(account);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("No saved accounts found.");
        }

        return accounts;
    }
}