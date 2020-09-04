package com.me.position;

public class Rotation {
    public double rol = 0;
    public double pitch = 0;
    public double yaw = 0;

    public Rotation() {
        this(0, 0, 0);
    }

    public Rotation(double rol, double pitch, double yaw) {
        setRotation(rol, pitch, yaw);
    }

    public void setRotation(double rol, double pitch, double yaw) {
        setRol(rol);
        setPitch(pitch);
        setYaw(yaw);
    }

    public void setRol(double value) {
        rol = value;
    }

    public void setPitch(double value) {
        pitch = value;
    }

    public void setYaw(double value) {
        yaw = value;
    }

    private double processRotationValue(double value) {
        if (value > 180) {
            return processRotationValue(-180 + value);
        } else if (value < -180) {
            return processRotationValue(180 + value);
        } else {
            return value;
        }
    }

    public void relativeRol(double value) {
        setRol(processRotationValue(rol + value));
    }

    public void relativePitch(double value) {
        setPitch(processRotationValue(pitch + value));
    }

    public void relativeYaw(double value) {
        setYaw(processRotationValue(yaw + value));
    }

    public void relativeRotate(double rol, double pitch, double yaw) {
        relativeRol(rol);
        relativePitch(pitch);
        relativeYaw(yaw);
    }
}
