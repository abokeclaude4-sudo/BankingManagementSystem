public class User {

    private String username;
    private String password;
    private String role;
    private String fullName;
    private String securityQuestion;
    private String securityAnswer;

    public User(String username, String password, String role, String fullName, String securityQuestion, String securityAnswer) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
    public String getFullName() {
        return fullName;
    }
    public String getSecurityQuestion() {
        return securityQuestion;
    }
    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void displayUser() {
        System.out.println("Username: " + username);
        System.out.println("Full Name: " + fullName);
        System.out.println("Role: " + role);
        System.out.println("Security Question: " + securityQuestion);
       
    }
    @Override
    public String toString() {
    return "Username: " + username +
           "\nFull Name: " + fullName +
           "\nRole: " + role;
   }
}