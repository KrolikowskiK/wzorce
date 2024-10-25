package com.example.database;

public interface Database {
    void connect();
    void executeQuery(String query);
}