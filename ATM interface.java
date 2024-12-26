import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to check balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " has been successfully deposited.");
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    // Method to withdraw amount
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " has been successfully withdrawn.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Transaction failed.");
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        }
    }
}

class ATM {
    private final BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    // Display menu options
    public void displayMenu() {
        System.out.println("\n--- ATM Interface ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    // Handle user input and perform actions
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Your current balance is: ₹%.2f%n", account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ₹");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}

public class Main {  // Class name matches the file name
    public static void main(String[] args) {
        // Initialize a bank account with an initial balance of ₹10,000
        BankAccount userAccount = new BankAccount(10000);

        // Create an ATM and link it to the bank account
        ATM atm = new ATM(userAccount);

        // Start the ATM interface
        atm.start();
    }
}