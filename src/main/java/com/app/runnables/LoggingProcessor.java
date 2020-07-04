package com.app.runnables;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingProcessor implements Callable {
    @Override
    public Object call() throws Exception {
        Logger.getLogger(LoggingProcessor.class.getName()).log(Level.INFO, "logging something");
        return true;
    }
}
