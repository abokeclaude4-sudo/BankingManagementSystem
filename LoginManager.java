import java.util.ArrayList;

public class LoginManager {

    private ArrayList<User> users;

    public LoginManager() {
        users = new ArrayList<>();
    }
public void registerUser(String username, String password, String role,
                         String fullName, String securityQuestion, String securityAnswer) {

    User newUser = new User(username, password, role, fullName, securityQuestion, securityAnswer);
    users.add(newUser);

    System.out.println("User registered successfully.");
}
    

    public User login(String username, String password) {

        for (User user : users) {

            if (user.getUsername().equals(username) &&
                user.getPassword().equals(password)) {

                System.out.println("Login successful.");
                return user;
            }
        }

        System.out.println("Invalid username or password.");
        return null;
    }
}