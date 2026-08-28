package level2;
import java.util.Scanner;

 class BankAccount{
    private String accountNumber;
    private String accountHolder;
    private double balance;


    //Constructor to initialize attributes
    BankAccount(String accNum, String accHold, double bal){
        accountNumber = accNum;
        accountHolder = accHold;
        balance = bal;
    }

    //Method to deposit
    void deposit(Scanner input) {
        System.out.println("Enter amount to deposit:");
        double amount = input.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful! Your new balance is: " + balance);
        } else {
            System.out.println("Deposit unsuccessful! Invalid amount.");
        }
    }

    //Method to withdraw
    void withdraw(Scanner input){
        System.out.println("Enter the amount to withdraw:");
        double amount = input.nextDouble();

        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdrawal successful! Your new balance is: " + balance);
        } else {
            System.out.println("Withdrawal unsuccessful! Invalid amount.");
        }
    }

    //Method to display account details
    void display(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

public class BankingSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Get account information
        System.out.print("Enter account number: ");
        String accountNumber = input.nextLine();

        System.out.print("Enter account holder name: ");
        String accountHolder = input.nextLine();

        System.out.print("Enter initial balance: ");
        double initialBalance = input.nextDouble();

        // Create bank account
        BankAccount account = new BankAccount(
                accountNumber,
                accountHolder,
                initialBalance
        );

        int choice;

        // Banking menu
        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Display Account Details");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    account.display();
                    break;

                case 2:
                    account.deposit(input);
                    break;

                case 3:
                    account.withdraw(input);
                    break;

                case 4:
                    System.out.println("Thank you for using the banking system!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        input.close();
    }
}
