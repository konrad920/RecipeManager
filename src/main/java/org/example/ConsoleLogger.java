package org.example;

public class ConsoleLogger {
    public void info(String message){
        System.out.println("INFO: " + message);
    }

    public void error(String message){
        System.out.println("ERROR: " + message);
    }
}
