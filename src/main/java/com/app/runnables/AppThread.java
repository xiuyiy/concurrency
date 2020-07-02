package com.app.runnables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AppThread extends Thread {

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("/Users/xiye/Library/mstrPractice/concurrency/src/main/resources/sample.txt")))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + " reading the line: " + line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
