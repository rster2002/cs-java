package com.me.models;

public class Employee implements Payable {
    private final double grossSalary;

    public Employee(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    @Override
    public double getPayout() {
        return grossSalary * 0.70;
    }
}
