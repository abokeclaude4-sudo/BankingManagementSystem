# Banking System Project

A Java-based Banking System application developed using Object-Oriented Programming (OOP) principles. This project simulates core banking operations including account creation, deposits, withdrawals, transaction history tracking, file persistence, and account management.

## Features

- Create bank accounts
- Deposit money
- Withdraw money
- View account details
- Delete accounts
- Track transaction history
- Persistent file storage using `accounts.txt`
- Automatic loading of saved accounts
- Savings and Current account support
- Object-Oriented Programming structure

## Technologies Used

- Java
- Eclipse IDE
- ArrayList
- File Handling
- OOP Concepts
- Inheritance
- Encapsulation

## Project Structure

```text
Main.java
BankManager.java
BankAccount.java
SavingsAccount.java
CurrentAccount.java
Transaction.java
FileManager.java
```

## OOP Concepts Applied

### Encapsulation
Protected account data using private fields and getter methods.

### Inheritance
SavingsAccount and CurrentAccount extend the BankAccount class.

### Constructors
Used constructors to initialize account objects automatically.

### Method Interaction
Classes communicate through methods to manage banking operations and file persistence.

## File Persistence

The system saves account information into:

```text
accounts.txt
```

Saved accounts automatically reload when the program starts.

## Future Improvements

- Java Swing GUI
- User authentication/login system
- Database integration (MySQL)
- Money transfer between accounts
- Admin dashboard
- Encryption and security features

## Author

Claude Aboke Alobo

GitHub:
https://github.com/abokeclaude4-sudo
