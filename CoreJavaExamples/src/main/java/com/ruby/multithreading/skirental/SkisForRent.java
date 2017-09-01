package com.ruby.multithreading.skirental;

import java.util.concurrent.Semaphore;

/**
 * Created by rjha on 10/11/2016.
 */
public class SkisForRent {
    public static final int MaxSkiPairs = 150;
    private static final int MinInStock = 5;
    private final Semaphore semaphore = new Semaphore(MaxSkiPairs - MinInStock);
    private SkiPair[] inventory;

    SkisForRent() {
        inventory = new SkiPair[MaxSkiPairs];
        for (int i = 0; i < MaxSkiPairs; i++) {
            inventory[i] = new SkiPair("skiPair-" + i, false);
        }
    }

    public SkiPair rentSkiPair() throws Exception {
        semaphore.acquire();  // get the ticket (acquire() is thread-safe
        return getSkiPair();  // use tick to retrieve pair
    }

    protected synchronized SkiPair getSkiPair() {
        for (SkiPair sp : inventory)
            if (!sp.isInUse()) {
                sp.setInUse(true);
                return sp;
            }
        return null; // out of luck
    }

    public void returnSkiPair(SkiPair sp) {
        if (isReturnable(sp)) semaphore.release(); // release() is thread-safe
    }

    protected synchronized boolean isReturnable(SkiPair sp) {
        if (sp.isInUse()) {
            sp.setInUse(false);
            return true;
        }
        return false;
    }
}
