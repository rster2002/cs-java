package com.me.position;

public class Location {
    public double x = 0;
    public double y = 0;
    public double z = 0;

    public Location() {
        this(0, 0, 0);
    }

    public Location(double x, double y, double z) {
        setPosition(x, y, z);
    }

    public void setPosition(double x, double y, double z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    public void setX(double value) {
        x = value;
    }

    public void setY(double value) {
        y = value;
    }

    public void setZ(double value) {
        z = value;
    }

    public void moveX(double value) {
        setX(x + value);
    }

    public void moveY(double value) {
        setY(y + value);
    }

    public void moveZ(double value) {
        setZ(z + value);
    }
}
