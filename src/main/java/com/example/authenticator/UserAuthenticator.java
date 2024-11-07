package com.example.authenticator;

public class UserAuthenticator {
    public boolean authenticate(String user) {
        System.out.println("Autoryzacja użytkownika: " + user);
        return true;
    }
}
