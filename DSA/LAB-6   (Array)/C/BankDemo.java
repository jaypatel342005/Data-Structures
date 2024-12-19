

import java.util.Scanner;

class BankAccount {
    int accountNumber;
    double balance;
    String accountHolderName;

    // Constructor to initialize BankAccount object
    public BankAccount(int accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    // Method to check balance
    public double checkBalance() {
        return balance;
    }

    // Getter methods
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of bank accounts: ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume the newline character

        BankAccount[] accounts = new BankAccount[n];

        // Create bank accounts
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for account " + (i + 1) + ":");
            System.out.print("Account Number: ");
            int accountNumber = sc.nextInt();
            sc.nextLine();  // Consume the newline character

            System.out.print("Account Holder Name: ");
            String accountHolderName = sc.nextLine();

            System.out.print("Initial Balance: ");
            double initialBalance = sc.nextDouble();

            accounts[i] = new BankAccount(accountNumber, accountHolderName, initialBalance);
        }

        // Simulate some operations
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Deposit
                    System.out.print("Enter account number: ");
                    int depositAccountNumber = sc.nextInt();
                    BankAccount depositAccount = findAccount(accounts, depositAccountNumber);

                    if (depositAccount != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 2:
                    // Withdraw
                    System.out.print("Enter account number: ");
                    int withdrawAccountNumber = sc.nextInt();
                    BankAccount withdrawAccount = findAccount(accounts, withdrawAccountNumber);

                    if (withdrawAccount != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    // Check balance
                    System.out.print("Enter account number: ");
                    int checkBalanceAccountNumber = sc.nextInt();
                    BankAccount checkBalanceAccount = findAccount(accounts, checkBalanceAccountNumber);

                    if (checkBalanceAccount != null) {
                        System.out.println("Current balance: " + checkBalanceAccount.checkBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    // Exit
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }

    // Method to find a BankAccount by account number
    private static BankAccount findAccount(BankAccount[] accounts, int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}