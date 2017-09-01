package com.ruby.multithreading.skirental;

/**
 * Created by rjha on 10/11/2016.
 */
public class SkiPair {
    private String name;
    private boolean inUse;

    public SkiPair(String name, boolean inUse) {
        setName(name);
        setInUse(inUse);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public boolean isInUse() {
        return this.inUse;
    }
}
