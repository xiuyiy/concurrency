package com.app.runnables;

public class AppRunnable implements Runnable {
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) {
        AppRunnable runnable = new AppRunnable();
    }
}
