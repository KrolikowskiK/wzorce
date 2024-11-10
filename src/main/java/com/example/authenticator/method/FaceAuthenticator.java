package com.example.authenticator.method;

public class FaceAuthenticator extends BiometricAuthenticator {
    @Override
    protected boolean checkBioFeature() {
        System.out.println("Skan twarzy...");
        return true;
    }
}
