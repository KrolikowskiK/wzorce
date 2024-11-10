package com.example.authenticator.method;

import com.example.authenticator.Authenticator;

public abstract class BiometricAuthenticator implements Authenticator {
    @Override
    public boolean authenticate(String user) {
        System.out.println("Autoryzacja użytkownika biometrycznie: " + user);
        return true;
    }

    protected abstract boolean checkBioFeature();
}