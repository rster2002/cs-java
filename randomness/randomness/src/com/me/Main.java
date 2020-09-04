package com.me;

import com.me.battery.MediumBattery;
import com.me.engine.BasicEngine;
import com.me.ship.BasicShip;

public class Main {

    public static void main(String[] args) {
        Main program = new Main();
        program.start();
    }

    public void start() {
        BasicShip ship1 = createShip();
        BasicShip ship2 = createShip();

        System.out.println(ship1);
        System.out.println(ship2);
    }

    private BasicShip createShip() {
        BasicShip ship = new BasicShip();

        ship.engineSlots[0].fitEngine(new BasicEngine());
        ship.engineSlots[1].fitEngine(new BasicEngine());

        ship.batterySlots[0].fitBattery(new MediumBattery());
        ship.batterySlots[1].fitBattery(new MediumBattery());
        ship.batterySlots[2].fitBattery(new MediumBattery());
        ship.batterySlots[3].fitBattery(new MediumBattery());

        return ship;
    }
}
