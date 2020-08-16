package simplebank;

import java.util.Scanner;

public class MainBank {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //starting the program by creating a new account
        System.out.println("Hi There! Welcome to the Banking Application by Sumit");
        System.out.println("How many accounts do you wish to create in this bank? Please enter a number.");

        int numberOfAccounts = scan.nextInt();
        Bank objArr[] = new Bank[numberOfAccounts];

        for (int i = 0; i < numberOfAccounts; i++) {
            objArr[i] = new Bank();
            System.out.println("Account details for number " + (i+1));
            objArr[i].openAccount();
        }

        int choice;
        do {
            System.out.println("Main Menu\n1. Display all Accounts\n 2. Search By Account number\n 3. Deposit Money\n 4. Withdraw Money\n 5. Exit ");
            System.out.println("What Choice do you want to select? :");
            choice = scan.nextInt();

            switch (choice) {
            case 1:
                for (int i = 0; i < objArr.length; i++) {
                    objArr[i].showAccountDetails();
                }
                break;

            case 2:
                System.out.print("Enter the Account Number you wish to search : ");
                String account = scan.next();
                boolean foundAccount = false;
                for (int i = 0; i < objArr.length; i++) {
                    foundAccount = objArr[i].searchAccount(account);
                    if (foundAccount) {
                        break;
                    }
                }
                if (!foundAccount) {
                    System.out.println("Sorry. The account number was not found! ");
                }
                break;

            case 3:
                System.out.println("Please enter the account number you wish to deposit the money in. ");
                account = scan.next();
                foundAccount = false;
                for (int i = 0; i < objArr.length; i++) {
                    foundAccount = objArr[i].searchAccount(account);
                    if (foundAccount) {
                        objArr[i].depositMoney();
                        break;
                    }
                }
                if (!foundAccount) {
                    System.out.println("Sorry. The account number was not found! ");
                }
                break;
            
            case 4: 
                System.out.println("Please enter the account number you wish to withdraw the money from. ");
                account = scan.next();
                foundAccount = false;
                for (int i = 0; i < objArr.length; i++) {
                    foundAccount = objArr[i].searchAccount(account);
                    if (foundAccount) {
                        objArr[i].withdrawMoney();
                        break;
                    }
                }
                if (!foundAccount) {
                    System.out.println("Sorry. The account number was not found! ");
                }
                break;
            
            case 5: 
                System.out.println("Thank you for your time. ");
                break;
            }

        } while (choice != 5);

    }
}
