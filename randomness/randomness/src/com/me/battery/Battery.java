package com.me.battery;

public abstract class Battery {
    public String modelName;
    public double currentCharge;
    public double maxCharge;

    public Battery(String modelName, double maxCharge) {
        this(modelName, 0, maxCharge);
    }

    public Battery(String modelName, double currentCharge, double maxCharge) {
        this.modelName = modelName;
        this.currentCharge = currentCharge;
        this.maxCharge = maxCharge;
    }

    public boolean drain(double amount) {
        if (amount > currentCharge) return false;

        currentCharge -= amount;
        return true;
    }

    public boolean charge(double amount) {
        if (currentCharge == maxCharge) return false;
        currentCharge += maxCharge;

        if (currentCharge > maxCharge) currentCharge = maxCharge;
        return true;
    }
}
