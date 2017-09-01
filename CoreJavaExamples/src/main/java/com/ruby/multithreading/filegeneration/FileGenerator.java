package com.ruby.multithreading.filegeneration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by rjha on 10/7/2016.
 */
public class FileGenerator {
    private static AtomicInteger uniqueFileID= new AtomicInteger();
   // private static Object lock = new Object();
    public  void generateFile(String threadName){
        int localid = uniqueFileID.incrementAndGet();
        System.out.printf("Thread : %s got id %d %n" , threadName , localid);
        Path outputPath = Paths.get(".\\src\\main\\resources\\filegeneration.output" , "testFile"+localid+".txt").normalize().toAbsolutePath();
        System.out.printf("Thread : %s got path %s %n" , threadName , outputPath.toString());

        try(BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardOpenOption.CREATE,StandardOpenOption.APPEND )){
            writer.write("The writer Object being used is" + writer.toString() + " thread " + threadName);
            writer.newLine();
            writer.write("test file generated" + " thread " + threadName);
            writer.newLine();
            writer.write("test file ID : " + localid + " thread " + threadName);
            writer.newLine();
            writer.write("test file written by thread : " + threadName);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
