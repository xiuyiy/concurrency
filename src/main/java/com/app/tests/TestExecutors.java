package com.app.tests;

import com.app.dao.UserDao;
import com.app.runnables.UserProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestExecutors {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        List<String> users = getUsersFromFile("/Users/xiye/Library/mstrPractice/concurrency/src/main/resources/new_users.txt");
        UserDao dao = new UserDao();
        for(String user: users) {
            //per user record, we are going to submit a user save
            Future<Integer> future = service.submit(new UserProcessor(user, dao));
            try {
                //see the result of the future object
                System.out.println("Result of the operation is " + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
        System.out.println("Main execution over");


    }

    public static List<String> getUsersFromFile(String fileName) {
        List<String> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                users.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }
}
