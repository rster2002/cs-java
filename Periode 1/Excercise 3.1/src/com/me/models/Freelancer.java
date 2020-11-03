package com.me.models;

public class Freelancer implements Payable {
    private final double hourlyRate;
    private final int workedHours;

    public Freelancer(double hourlyRate, int workedHours) {
        this.hourlyRate = hourlyRate;
        this.workedHours = workedHours;
    }

    @Override
    public double getPayout() {
        return hourlyRate * workedHours;
    }
}
