package com.example.user;

import com.example.authenticator.Authenticator;
import com.example.cart.Cart;

public class User {
    private String name;
    private String email;
    private Cart cart = new Cart();
    private Authenticator defaultAuthenticator;

    public User(String name, Authenticator authenticator) {
        this.name = name;
        this.defaultAuthenticator = authenticator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Authenticator getDefaultAuthenticator() {
        return defaultAuthenticator;
    }

    public void setDefaultAuthenticator(Authenticator defaultAuthenticator) {
        this.defaultAuthenticator = defaultAuthenticator;
    }
}
