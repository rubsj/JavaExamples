package com.ruby.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;
import java.util.Comparator;

/**
 * Write a simple Java application that gets a list of all files in the /tmp directory that have a .txt suffix.
 * <p>
 * The application then prints out the size and name of the files in ascending order by size and name.
 *
 * Dependency on - commons-io-2.5.jar
 *     <dependency>
 *             <groupId>commons-io</groupId>
 *             <artifactId>commons-io</artifactId>
 *             <version>2.5</version>
 *         </dependency>
 *         
 */
public class ReadFiles {

    public static void main(String[] args) {
        //get the directoru c:\tmp
        File directoryTOTraverse = new File("\\C:\\Software");
        //if directory not available print message and end the flow
        if (directoryTOTraverse.isDirectory()) {
            //get the list of all files with extn txt recursively from this directory
            Collection<File> files = FileUtils.listFiles(directoryTOTraverse, new String[]{"txt"}, true);
            //create comparator lambda which will sort based on size and then name in ascending order
            Comparator<File> sizeThenNameComparator =
                    Comparator.comparing(FileUtils::sizeOf)
                            .thenComparing(File::getName);

            //convert file collection to stream and then do sorting using the above created comparator and print name and size
            files.stream().sorted(sizeThenNameComparator).forEach(s -> {
                System.out.printf("File name is %s and size of file is %d bytes %n", s.getName(), FileUtils.sizeOf(s));
            });
        } else {
            System.out.printf("the directory not available %s%n ", directoryTOTraverse);
        }


    }
}

