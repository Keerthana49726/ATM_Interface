/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm_interface;

/**
 *
 * @author LENOVO
 */
import java.util.Scanner;

public class AtM_Interface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner scanner = new Scanner(System.in);
        // Initialize a bank account with an initial balance
        BankAccount account = new BankAccount(500.00); // Starting balance: $500
        ATM atm = new ATM(account);

        System.out.println("Welcome to the ATM!");

        // Main loop for the ATM menu
        while (true) {
            atm.displayMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            atm.handleChoice(choice);
        }
    }
    
}

// Class representing the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit an amount into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    // Method to withdraw an amount from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Your current balance is: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        }
    }
}

// Class representing the ATM machine
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display the ATM menu
    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    // Method to handle the user's choice
    public void handleChoice(int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1:
                // Check balance
                System.out.println("Current Balance: $" + account.getBalance());
                break;
            case 2:
                // Deposit money
                System.out.print("Enter amount to deposit: $");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                break;
            case 3:
                // Withdraw money
                System.out.print("Enter amount to withdraw: $");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
                break;
            case 4:
                // Exit
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }
    }
}


