package com.me.slots;

import com.me.battery.Battery;

public class BatterySlot extends Slot {
    public Battery battery = null;

    public boolean isPoweredOn() {
        return poweredOn && isFitted();
    }

    public boolean isFitted() {
        return battery != null;
    }

    public void fitBattery(Battery battery) {
        this.battery = battery;
    }
}
