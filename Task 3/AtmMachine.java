import java.util.Scanner;

public class AtmMachine {

    private double balance;
    private Scanner scanner;

    public AtmMachine(double initialBalance) {
        this.balance = initialBalance;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction() {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = readIntFromUser();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    public double getBalance() {
        return balance;
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: $");
        double amount = readDoubleFromUser();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: $");
        double amount = readDoubleFromUser();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    private int readIntFromUser() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private double readDoubleFromUser() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static void main(String[] args) {
        AtmMachine atm = new AtmMachine(1000);
        atm.performTransaction();
    }
}