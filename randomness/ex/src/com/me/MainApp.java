package com.me;

import com.me.models.BankAccount;
import com.me.models.WithdrawSuccessStatus;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        System.out.printf("Balance is now: %.2f ", bankAccount.getBalance());

        // Look until exit clause (input is 0)
        while(true) {
            System.out.println("");

            // Create scanner and display a prompt
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter an amount to withdraw or 0 to stop: ");

            // Get the next double value
            double amount = scanner.nextDouble();
            if (amount == 0) {
                System.out.print("End program.....");
                break;
            }

            // Try a bank balance withdraw
            WithdrawSuccessStatus status = bankAccount.withdraw(amount);

            // Handle the SuccessStatus returned from the withdraw method
            if (status == WithdrawSuccessStatus.NEGATIVE_INPUT) System.out.println("Cannot withdraw negative amount");
            else if (status == WithdrawSuccessStatus.INSUFFICIENT_BALANCE) System.out.println("You don't have enough balance to make this withdraw");
            else System.out.println("Withdraw was successful");

            // Displays the current balance of this user
            System.out.printf("Balance is now: %.2f ", bankAccount.getBalance());
        }
    }
}