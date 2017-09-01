package com.ruby.multithreading.filegeneration;

import com.ruby.multithreading.fileprocessing.FileProcessor;

public class RunnableWorker implements Runnable {

    @Override
    public void run() {
        long starttime = System.currentTimeMillis();
        Thread thread = Thread.currentThread();
        //Thread.sleep(1000);
        System.out.println("RunnableJob is being run by " + thread.getName() + " (" + thread.getId() + ")  .. Start work");
        FileGenerator processor = new FileGenerator();
      //  for(int i= 0 ; i<10 ; i++) {
            processor.generateFile(thread.getName());
        //}
        System.out.println("RunnableJob is being run by " + thread.getName() + " (" + thread.getId() + ")  .. End work");
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken : by  " + thread.getName() + "  " + (endTime - starttime) + " milllisecond");
    }

}
