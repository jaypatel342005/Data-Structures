

import java.util.Scanner;

class BankAccount {
    private int accountNumber;
    private double balance;
    private String accountHolderName;

    public BankAccount(int accountNumber, double initialBalance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.accountHolderName = accountHolderName;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    public double getBalance() {
        return balance;
    }
}




public class Lab6_37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int accNumber = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter initial balance: $");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Enter account holder name: ");
        String accHolderName = scanner.nextLine();

        
        BankAccount account = new BankAccount(accNumber, initialBalance, accHolderName);

        
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using our banking system!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
