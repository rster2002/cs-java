package com.me.slots;

public abstract class Slot {
    public boolean poweredOn = false;

    public abstract boolean isPoweredOn();

    public boolean toggle() {
        poweredOn = !poweredOn;
        return poweredOn;
    }

    public void turnOn() {
        poweredOn = true;
    }

    public void turnOff() {
        poweredOn = false;
    }

    public abstract boolean isFitted();
}
