package com.me.models;

public class BankAccount {
    private int accountNumber;
    private double balance = 200.00;

    public double getBalance() {
        return balance;
    }

    public WithdrawSuccessStatus withdraw(double amount) {
        if (amount < 0) return WithdrawSuccessStatus.NEGATIVE_INPUT;
        if (amount > balance) return WithdrawSuccessStatus.INSUFFICIENT_BALANCE;

        balance -= amount;
        return WithdrawSuccessStatus.SUCCESS;
    }
}