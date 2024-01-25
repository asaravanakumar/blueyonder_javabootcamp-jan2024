package com.labs.java.oops.bankingapp;

import java.util.Scanner;

public class AccountMain {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Banking App!!!");

        String status = "ACTIVE";

        // int id, String name, double balance, String status, double roi
        SavingsAccount savings = new SavingsAccount(100, "Prem", 50000.0, AccountStatus.valueOf(status), 2.7);
        System.out.println(savings.checkBalance());
        savings.deposit(10000);
        System.out.println(savings.checkBalance());
        savings.withdraw(5000);
        System.out.println(savings.checkBalance());
//        savings.closeAccount();

        System.out.println(savings);

        System.out.println(savings.getId() + " " + savings.getName() + " " + savings.getBalance() + " " + savings.getStatus());

        //int id, String name, double balance, String status, double roi, int tenure, boolean autoRenew
//        DepositAccount deposit = new DepositAccount(101, "Karthik", 500000.0, "Active", 7.5, 5, false);
//        System.out.println(deposit.checkBalance());
//        System.out.println(deposit.checkMaturityAmount());
//        deposit.preClose();
//
//        com.labs.java.oops.Account savings1 = new SavingsAccount(102, "Kumar", 25000.0, "Active", 2.7);
//        System.out.println(savings1.checkBalance());
//
//        PreCloseable savings2 = new DepositAccount(101, "Karthik", 500000.0, "Active", 7.5, 5, false);
//        savings2.preClose();





//        com.labs.java.oops.Account account = new com.labs.java.oops.Account();
//
//        while(true) {
//            System.out.println();
//            System.out.println("1. Open com.labs.java.oops.Account");
//            System.out.println("2. Check Balance");
//            System.out.println("3. Deposit");
//            System.out.println("4. Withdraw");
//            System.out.println("5. Suspend com.labs.java.oops.Account");
//            System.out.println("6. Close com.labs.java.oops.Account");
//            System.out.println("7. Exit");
//
//            System.out.print("Enter the option: ");
//            int option = in.nextInt();
//
//            switch (option) {
//                case 1:
//                    readAccountDetails(account);
//                    account.openAccount();
//                    System.out.println("com.labs.java.oops.Account Opened");
//                    break;
//                case 2:
//                    double balance = account.checkBalance();
//                    System.out.println("com.labs.java.oops.Account balance is " + balance);
//                    break;
//                case 3:
//                    System.out.println("Enter the amount to deposit: ");
//                    double depAmt = in.nextDouble();
//                    boolean depStatus = account.deposit(depAmt);
//                    if(depStatus) System.out.println(depAmt + " is deposited");
//                    break;
//                case 4:
//                    System.out.println("Enter the amount to withdraw: ");
//                    double wthAmt = in.nextDouble();
//                    boolean wthStatus = account.withdraw(wthAmt);
//                    if(wthStatus) System.out.println(wthAmt + " is withdrawn");
//                    break;
//                case 5:
//                    account.suspendAccount();
//                    System.out.println("com.labs.java.oops.Account suspended");
//                    break;
//                case 6:
//                    account.closeAccount();
//                    System.out.println("com.labs.java.oops.Account closed");
//                    break;
//                case 7:
//                    System.out.println("Thank you!!!");
//                    in.close();
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid Option. Please try again!!!");
//                    continue;
//            }
//
//        }
    }

    // Pass by Reference
//    public static void readAccountDetails(com.labs.java.oops.Account account) {
//        System.out.print("Enter com.labs.java.oops.Account ID: ");
//        account.id = in.nextInt();
//
//        System.out.print("Enter com.labs.java.oops.Account Name: ");
//        account.name = in.next();
//
//        System.out.print("Enter Initial Deposit Amount: ");
//        account.balance = in.nextDouble();
//
//        System.out.print("Enter com.labs.java.oops.Account Type: ");
//        account.type = in.next();
//    }

}
