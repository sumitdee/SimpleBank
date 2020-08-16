package simplebank;

import java.util.Scanner;

public class Bank {

    Scanner scanB = new Scanner(System.in);

    private String accountNumber;
    private long availableBalance;
    private String customerName;

    void openAccount() {
        System.out.println("Account number: ");
        accountNumber = scanB.next();
        System.out.println("What is the name of the customer?: ");
        customerName = scanB.next();
        System.out.println("Please input the intial balance you need to deposit: ");
        availableBalance = scanB.nextLong();
    }

    void showAccountDetails() {
        System.out.println("The account number is " + accountNumber);
        System.out.println("The name of the customer is " + customerName);
        System.out.println("The current Balance is " + availableBalance);
    }

    void depositMoney() {
        long amount;
        System.out.println("Please enter the amount you wish to deposit. ");
        amount = scanB.nextLong();
        availableBalance += amount;
    }

    void withdrawMoney() {
        long amount;
        System.out.println("Please enter the amount you wish to withdraw. ");
        amount = scanB.nextLong();

        if (availableBalance >= amount) {
            System.out.println("Amount withdrawn.");
            availableBalance -= amount;
            System.out.println("The available balance after withdrawal is ~ " + availableBalance);
        } else {
            System.out.println("Transaction Failed.");
            System.out.println("The available balance is " + availableBalance + ", but you are trying to withdraw " +
                               amount);
        }
    }
    
    boolean searchAccount(String accountN){
        if(accountNumber.equals(accountN)){
            showAccountDetails();
            return true;
        }
        return false;
    }

}
