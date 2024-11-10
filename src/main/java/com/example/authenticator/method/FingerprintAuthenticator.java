package com.example.authenticator.method;

public class FingerprintAuthenticator extends BiometricAuthenticator {
    @Override
    protected boolean checkBioFeature() {
        System.out.println("Skan odcisku palca...");
        return true;
    }
}
