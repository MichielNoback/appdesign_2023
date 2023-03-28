package nl.bioinf.lesson10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static jdk.jfr.consumer.EventStream.openFile;

public class DemoExceptions {
    public static void main(String[] args) {
        try {
            new DemoExceptions().doIt();
        } catch (MyAppException e) {
            System.err.println("an error occurred ");
            System.err.println(e.getMessage());
        }
    }

    private void doIt() {
        doItMore();
    }

    private void doItMore() {
        openFile();
    }

    private void openFile() {
        String fileName = "/Users/michiel/IdeaProjects/JavaIntroProgrammingAssignments/data/proteins.fa";

        Path path = Paths.get(fileName);
        System.out.println("Files.isReadable(path) = " + Files.isReadable(path));
        System.out.println("Files.isDirectory(path) = " + Files.isDirectory(path));
        try {
            Path copy = Paths.get("/Users/michiel/Desktop/test.fa");
            //delete if it already exists
            Files.deleteIfExists(copy);
            Files.copy(path, copy);
        } catch (IOException e) {
            throw new MyAppException("The input file is missing", e);
//            e.printStackTrace();
        }
    }


}
