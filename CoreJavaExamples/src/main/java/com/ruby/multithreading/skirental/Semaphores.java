package com.ruby.multithreading.skirental;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rjha on 10/11/2016.
 */
public class Semaphores {
    public static void main(String[] args) {
        Random rand = new Random();
        final SkisForRent sfr = new SkisForRent();

        ExecutorService[] executors = new ExecutorService[SkisForRent.MaxSkiPairs + 1];
        for (ExecutorService executor : executors) {
            executor = Executors.newSingleThreadExecutor();
            executor.execute(()-> {
                String name = Thread.currentThread().getName();
                try {
                    while (true) {
                        SkiPair sp = sfr.rentSkiPair();
                        System.out.printf("%s renting %s%n", name, sp.getName());
                        Thread.sleep(rand.nextInt(2000));  // skiing
                        System.out.printf("%s returning %s%n", name, sp.getName());
                        sfr.returnSkiPair(sp);
                    }
                } catch (Exception e) {
                    System.err.println(e);
                }
            });
        }
    }
}
