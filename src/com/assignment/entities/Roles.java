package com.assignment.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Roles {

    public static String ROLE_USER = "USER";
    public static String ROLE_ADMIN = "ADMIN";

    public static List<String> getRolesList() {
        return new ArrayList<>(Arrays.asList(ROLE_USER, ROLE_ADMIN));
    }

}
