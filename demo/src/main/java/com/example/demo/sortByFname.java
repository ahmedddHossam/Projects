package com.example.demo;

import java.util.Comparator;

public class sortByFname implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getFirstname().compareTo(o2.getFirstname());
    }
}
