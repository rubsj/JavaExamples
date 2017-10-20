package com.ruby.stream;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ParseCSV {

    public void init() throws Exception {

        Path path = Paths.get("csvfile.csv");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            List<String> columns = reader.lines().findFirst().map(line -> Arrays.asList(line.split(","))).get();
            // find the relevant sections from the CSV file
            // we are only interested in the row with the CA ServiceName
            int serviceNameIndex = columns.indexOf("ServiceName");
            int col1Index = columns.indexOf("Column1");
            int col2Index = columns.indexOf("Column2");


        }
    }

    public static void main(String[] args) throws Exception {
        ParseCSV parseCSV  = new ParseCSV();
        parseCSV.init();
    }

}
