package com.assignment.service;

import com.assignment.entities.User;

public interface UserService {

    public String addUser(String username, String role);

    public String removeUser(String username);

    boolean checkIfUserExists(String username);

    public User getUserFromUsername(String username);

}
