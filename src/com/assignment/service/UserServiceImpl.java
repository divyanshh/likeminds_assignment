package com.assignment.service;

import com.assignment.entities.Roles;
import com.assignment.entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    Map<String, User> usernameVsUserMap = new HashMap<>();

    @Override
    public String addUser(String username, String role) {
        if (username.equals("")) {
            return "ERROR : username cannot be empty";
        }
        if (usernameVsUserMap.containsKey(username)) {
            return "ERROR : User already exists in the system!";
        }
        if (Roles.getRolesList().contains(role)) {
            User user = new User(username, role);
            usernameVsUserMap.put(username, user);
            return "SUCCESS : User ".concat(username).concat(" successfully added!");
        } else {
            return "ERROR : Role does not exist";
        }
    }

    @Override
    public String removeUser(String username) {
        return "will implement later";
    }

    @Override
    public boolean checkIfUserExists(String username) {
        return usernameVsUserMap.containsKey(username);
    }

    @Override
    public User getUserFromUsername(String username) {
        return usernameVsUserMap.get(username);
    }


}
