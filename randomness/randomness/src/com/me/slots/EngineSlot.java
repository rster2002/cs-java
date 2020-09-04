package com.me.slots;

import com.me.engine.Engine;

public class EngineSlot extends Slot {
    public Engine engine = null;

    public boolean isFitted() {
        return engine != null;
    }

    public boolean isPoweredOn() {
        return poweredOn && isFitted();
    }

    public void fitEngine(Engine engine) {
        this.engine = engine;
    }
}
