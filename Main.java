import java.util.Scanner;

class DigitalWallet {
    String ownerName;
    double balance;
    double transactionFee;

    DigitalWallet(String ownerName, double transactionFee) {
        this.ownerName = ownerName;
        this.balance = 0;
        this.transactionFee = transactionFee;
    }

    void addMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Added: " + amount);
            showBalance();
        } else {
            System.out.println("Invalid amount!");
        }
    }

    void spendMoney(double amount) {
        double totalAmount = amount + transactionFee;

        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (totalAmount <= balance) {
            balance -= totalAmount;
            System.out.println("Spent: " + amount);
            System.out.println("Transaction fee: " + transactionFee);
            showBalance();
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void showBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter wallet owner name: ");
        String name = input.nextLine();

        DigitalWallet wallet = new DigitalWallet(name, 2.0);

        while (true) {
            System.out.println("\n--- Digital Wallet Menu ---");
            System.out.println("1. Add Money");
            System.out.println("2. Spend Money");
            System.out.println("3. Show Balance");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.print("Enter amount to add: ");
                double amount = input.nextDouble();
                wallet.addMoney(amount);
            } else if (choice == 2) {
                System.out.print("Enter amount to spend: ");
                double amount = input.nextDouble();
                wallet.spendMoney(amount);
            } else if (choice == 3) {
                wallet.showBalance();
            } else if (choice == 4) {
                System.out.println("Exiting wallet system...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        input.close();
    }
}