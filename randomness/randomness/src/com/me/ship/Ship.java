package com.me.ship;

import com.me.slots.BatterySlot;
import com.me.slots.EngineSlot;
import com.me.position.*;

public abstract class Ship {
    public String modelName;

    public Location currentPosition = new Location();
    public Rotation currentRotation = new Rotation();

    public EngineSlot[] engineSlots;
    public BatterySlot[] batterySlots;

    public double weight = 0;

    public Ship(String modelName, double weight, int numberOfEngineSlots, int numberOfBatterySlots) {
        this.weight = weight;
        this.modelName = modelName;

        engineSlots = new EngineSlot[numberOfEngineSlots];
        batterySlots = new BatterySlot[numberOfBatterySlots];

        for (int i = 0; i < numberOfEngineSlots; i++) {
            engineSlots[i] = new EngineSlot();
        }

        for (int i = 0; i < numberOfBatterySlots; i++) {
            batterySlots[i] = new BatterySlot();
        }
    }
}