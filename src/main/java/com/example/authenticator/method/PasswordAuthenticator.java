package com.example.authenticator.method;

import com.example.authenticator.Authenticator;

public class PasswordAuthenticator implements Authenticator {
    @Override
    public boolean authenticate(String user) {
        System.out.println("Autoryzacja użytkownika hasłem: " + user);
        return true;
    }
}