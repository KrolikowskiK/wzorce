package com.example.authenticator;

public class PasswordAuthenticator extends UserAuthenticator {
    @Override
    public boolean authenticate(String user) {
        System.out.println("Autoryzacja użytkownika hasłem: " + user);
        return true;
    }
}