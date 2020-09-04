package com.me.engine;

import com.me.object.ShipPart;

public abstract class Engine extends ShipPart {
    public String modelName;
    public double energyConsumption;

    public Engine(String modelName, double energyConsumption, int maxHealth) {
        super(maxHealth);

        this.modelName = modelName;
        this.energyConsumption = energyConsumption;
    }
}
