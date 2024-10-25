package com.example.database;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DBProxy implements Database {
    private static RealDB realDatabase;
    private static ArrayList<String> eventLogs;

    @Override
    public void connect() {
        if (realDatabase == null) {
            System.out.println("Connecting database...");
            realDatabase = new RealDB();
            eventLogs = new ArrayList<>();
            eventLogs.add("Connected at: " + LocalDateTime.now());
        }
    }

    @Override
    public void executeQuery(String query) {
        if (realDatabase == null) {
            connect();
        }
        System.out.println("Executing query: " + query);
        eventLogs.add("Query: " + query + " executed at: " + LocalDateTime.now());
        realDatabase.executeQuery(query);
    }

    public void printDbLogs() {
        for (String log : eventLogs) {
            System.out.println(log);
        }
    }
}
