package su.intercraft;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        File directory = new File("v17");
        File[] files = directory.listFiles();
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (File file : files) {
            executor.submit(new Reader(file));
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        Writer.writePng();
    }
}