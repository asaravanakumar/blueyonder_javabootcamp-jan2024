package com.blueyonder.bankingapp;

import com.blueyonder.bankingapp.exception.AccountException;
import com.blueyonder.bankingapp.exception.AccountValidationException;
import com.blueyonder.bankingapp.model.Account;
import com.blueyonder.bankingapp.model.DepositAccount;
import com.blueyonder.bankingapp.model.LoanAccount;
import com.blueyonder.bankingapp.model.SavingsAccount;
import com.blueyonder.bankingapp.service.AccountService;
import com.blueyonder.bankingapp.service.AccountServiceArrListImpl;
import com.blueyonder.bankingapp.service.AccountServiceLnkListImpl;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingAppMain {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Banking App!!!");

        AccountService accService = new AccountServiceArrListImpl();
//        AccountService accService = new AccountServiceLnkListImpl();


        while(true) {
            System.out.println();
            System.out.println("1. Create Account");
            System.out.println("2. List Accounts");
            System.out.println("3. View Account");
            System.out.println("4. Update Account");
            System.out.println("5. Delete Account");
            System.out.println("6. Exit");

            System.out.print("Enter the option: ");
            int option = in.nextInt();
            int id = 0;

            try {
                switch (option) {
                    case 1:
                        Account account = readAccountDetails();
                        accService.createAccount(account);
                        System.out.println("Account Opened");
                        break;

                    case 2:
                        Collection<Account> accounts = accService.listAccounts();
                        displayAccountDetails(accounts);
                        break;

                    case 3:
                        System.out.print("Enter the Account ID: ");
                        id = in.nextInt();
                        Account acc = accService.viewAccount(id);
                        displayAccountDetails(acc);
                        break;

                    case 4:
                        System.out.print("Enter the Account ID: ");
                        id = in.nextInt();

                        Account accForUpdate = accService.viewAccount(id);
                        // TODO: Logic to update
                        boolean updateStatus = accService.updateAccount(id, accForUpdate);
                        System.out.println(updateStatus ? "Account Update Successful" : "Account Update Failed");
                        break;

                    case 5:
                        System.out.print("Enter the Account ID: ");
                        id = in.nextInt();

                        boolean deleteStatus = accService.deleteAccount(id);
                        System.out.println(deleteStatus ? "Account Deletion Successful" : "Account Deletion Failed");
                        break;

                    default:
                        System.out.println("Invalid Option");
                        continue;
                }
            }catch (AccountException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }

    public static Account readAccountDetails() throws AccountValidationException {
        System.out.println("Choose the type of Account");
        System.out.println("1. Savings");
        System.out.println("2. Deposit");
        System.out.println("3. Loan");

        System.out.print("Enter the option: ");
        int option = in.nextInt();
        Account account = null;
        switch (option) {
            case 1:
                account = captureSavingsAccountDetails();
                break;
            case 2:
                account = captureDepositAccountDetails();
                break;
            case 3:
                account = captureLoanAccountDetails();
                break;
            default:
        }

        return account;
    }

    public static Account captureSavingsAccountDetails() throws AccountValidationException {
        SavingsAccount account = new SavingsAccount();

        try {
            System.out.print("Enter Account Name: ");
            account.setName(in.next());

            System.out.print("Enter Initial Deposit Amount: ");
            account.setBalance(in.nextDouble());

            System.out.print("Enter ROI: ");
            account.setRoi(in.nextDouble());
        }catch(InputMismatchException ime) {
            throw new AccountValidationException("Invalid Input. Please try again. " + ime.getMessage() );
        }

        return account;
    }

    public static Account captureDepositAccountDetails() throws AccountValidationException {
        DepositAccount account = new DepositAccount();

        try {
            System.out.print("Enter Account Name: ");
            account.setName(in.next());

            System.out.print("Enter Initial Deposit Amount: ");
            account.setBalance(in.nextDouble());

            System.out.print("Enter ROI: ");
            account.setRoi(in.nextDouble());

            System.out.print("Enter Tenure: ");
            account.setTenure(in.nextInt());

            System.out.print("Is Auto Renewable? (Y/N): ");
            account.setAutoRenew(in.next().equalsIgnoreCase("Y") ? true : false);
        }catch (InputMismatchException ime) {
            throw new AccountValidationException("Invalid Input. Please try again. " + ime.getMessage() );
        }

        return account;
    }

    public static Account captureLoanAccountDetails() throws AccountValidationException{
        LoanAccount account = new LoanAccount();

        try {
            System.out.print("Enter Account Name: ");
            account.setName(in.next());

            System.out.print("Enter Initial Deposit Amount: ");
            account.setBalance(in.nextDouble());

            System.out.print("Enter ROI: ");
            account.setRoi(in.nextDouble());

            System.out.print("Enter Tenure: ");
            account.setTenure(in.nextInt());

            System.out.print("Enter EMI: ");
            account.setEmi(in.nextDouble());
        }catch (InputMismatchException ime) {
            throw new AccountValidationException("Invalid Input. Please try again. " + ime.getMessage() );
        }
        return account;
    }

    public static void displayAccountDetails(Collection<Account> accounts) {
        printHeader();
        for(Account account: accounts) {
            printDetail(account);
        }
    }

    public static void displayAccountDetails(Account account) {
        printHeader();
        printDetail(account);
    }

    private static void printHeader() {
        System.out.format("\n%5s %15s %10s %10s %15s %5s", "ID", "Name", "Balance", "ROI", "Status",
                "Tenure");
    }

    private static void printDetail(Account account) {
        if (account == null) {
            return;
        }

        if(account instanceof SavingsAccount) {
            SavingsAccount savings = (SavingsAccount) account;
            System.out.format("\n%5d %15s %10f %10f %15s", savings.getId(), savings.getName(), savings.getBalance(), savings.getRoi(), savings.getStatus());
        } else if(account instanceof DepositAccount) {
            DepositAccount deposit = (DepositAccount)  account;
            System.out.format("\n%5d %15s %10f %10f %15s %5d", deposit.getId(), deposit.getName(), deposit.getBalance(), deposit.getRoi(), deposit.getStatus(), deposit.getTenure());
        } else if(account instanceof LoanAccount) {
            LoanAccount loan = (LoanAccount) account;
            System.out.format("\n%5d %15s %10f %10f %15s %5d", loan.getId(), loan.getName(), loan.getBalance(), loan.getRoi(), loan.getStatus(), loan.getTenure());
        }
    }
}
