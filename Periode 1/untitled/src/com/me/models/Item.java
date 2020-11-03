package com.me.models;

public class Item {
    private final double volume;
    private final double weight;

    public Item(double volume, double weight) {
        this.volume = volume;
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }
}
