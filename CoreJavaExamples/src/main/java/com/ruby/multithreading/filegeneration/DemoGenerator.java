package com.ruby.multithreading.filegeneration;

import com.ruby.multithreading.fileprocessing.FileProcessor;

/**
 * Created by rjha on 10/7/2016.
 */
public class DemoGenerator {
    public static void main(String[] args) {
        try {
            long starttime = System.currentTimeMillis();
            for (int i = 1; i < 11; i++) {
                Thread thread = new Thread(new RunnableWorker(), "MyName" + i);

                thread.start();
               // thread.join();
            }

            Thread.sleep(2000);
            long endTime = System.currentTimeMillis();
            System.out.println("Total time taken : " + (endTime - starttime) + " milllisecond");
            System.out.println("ending main method");


        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
