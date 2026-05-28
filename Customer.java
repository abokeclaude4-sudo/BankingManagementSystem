public class Customer {

    private int customerId;
    private String fullName;
    private String phone;
    private String email;

    public Customer(int customerId, String fullName, String phone, String email) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void displayCustomer() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + fullName);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}