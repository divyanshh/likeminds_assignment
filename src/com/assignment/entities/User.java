package com.assignment.entities;

public class User {

    private String username;
    private String role;

    public User (String username, String role) {
        this.role = role;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getUserRole() {
        return role;
    }

}
