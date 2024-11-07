package com.example.authenticator;


public class BiometricAuthenticator extends UserAuthenticator {
    @Override
    public boolean authenticate(String user) {
        System.out.println("Autoryzacja użytkownika biometrycznie: " + user);
        return true;
    }
}