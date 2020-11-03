package com.me.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class Container {
    private final List<Item> items = new ArrayList<>();
    private final double maxVolume;

    public Container(double maxVolume) {
        this.maxVolume = maxVolume;
    }

    public void ItemAddedToContainerResult(Item item) {

    }

    public double getMaxVolume() {
        return maxVolume;
    }

    public double currentVolume() {
        return items.stream()
                .map(Item::getVolume)
                .reduce(Double::sum).stream().collect(Collector.of(Double.getClass()));
    }
}
