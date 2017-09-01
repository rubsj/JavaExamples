package com.ruby.multithreading.fileprocessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.atomic.AtomicInteger;

public class FileProcessor {
    private static Object syncObj = new Object();
    private static AtomicInteger uniqueFileID = new AtomicInteger();
    Path inputpath = Paths.get(".\\src\\main\\java\\com\\ruby\\multithreading\\fileprocessing", "FileTestInput.txt").normalize().toAbsolutePath();   //"FileTestInput.txt"  "testother"


    public void processFileAtomicApproach(String threadName) {
        // synchronized (syncObj) {
        int localid = uniqueFileID.incrementAndGet();
        System.out.printf("Thread : %s got id %d %n", threadName, localid);
        Path outputPath = Paths.get(".\\src\\main\\resources\\filegeneration.output", "testFile" + localid + ".txt").normalize().toAbsolutePath();
        System.out.printf("Thread : %s got path %s %n", threadName, outputPath.toString());

        try (BufferedReader reader = Files.newBufferedReader(inputpath); BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write("The writer Object being used is" + writer.toString() + " thread " + threadName);
            writer.newLine();
            String line = null;
            while ((line = reader.readLine()) != null) {
                writer.write(line + " thread " + threadName);
                writer.newLine();
                writer.flush();
            }


        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}
//}
