package com.me.object;

public abstract class ShipPart {
    public int currentHealth;
    public int maxHealth;

    public ShipPart(int maxHealth) {
        this.currentHealth = maxHealth;
        this.maxHealth = maxHealth;
    }

    public boolean isDestroyed() {
        return currentHealth <= 0;
    }

    public void applyDamage(int damage) {
        if (currentHealth < 0) return;
        currentHealth -= damage;
    }

    public void repair(int damage) {
        if (isDestroyed()) return;
        currentHealth += damage;

        if (currentHealth > maxHealth) currentHealth = maxHealth;
    }
}
