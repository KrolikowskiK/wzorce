package com.example.authenticator;

import com.example.user.User;

public class AuthenticatorService {
    public boolean authenticate(User user) {
        return user.getDefaultAuthenticator().authenticate(user.getName());
    }
}
